//
//  LRUCache.swift

import Foundation
class LRUCache {
    class RecencyNode {
        let key: Int
        var value: Int
        var next: RecencyNode?
        var prev: RecencyNode?

        init(key: Int, value: Int) {
            self.key = key
            self.value = value
        }
    }

    var head: RecencyNode?
    var tail: RecencyNode?

    var buckets: [Int: RecencyNode]

    let capacity: Int
    init(_ capacity: Int) {
        buckets = [Int: RecencyNode]()
        buckets.reserveCapacity(capacity)
        self.capacity = capacity
    }
    
    func get(_ key: Int) -> Int {
      if let existing = buckets[key] {
          upgradeRecency(existing)
          return existing.value
      }
      return -1
    }
    
    func put(_ key: Int, _ value: Int) {
        let node: RecencyNode
        if let existingNode = buckets[key] {
            // value exists for this key, just modify it
            existingNode.value = value
            node = existingNode
        } else {
            // new insert, should check for possible eviction
            if buckets.count == self.capacity {
                evict()
            }
            node = RecencyNode(key: key, value: value)
        }

        upgradeRecency(node)
        buckets[key] = node
    }

    private func evict() {
        guard let oldHead = head else { return }
        guard buckets.count >= capacity else { return }

        self.head = oldHead.next
        if self.head == nil {
            tail = self.head
        }
        
        buckets[oldHead.key] = nil
        oldHead.next = nil
        oldHead.prev = nil
        
    }

    private func upgradeRecency(_ node: RecencyNode) {
         
         if let tail = tail {
               if tail === node { return }
               if let head = head, head === node {
                   self.head = head.next
               }
            
               node.prev?.next = node.next
               node.next?.prev = node.prev
               node.prev = tail
               node.next = nil
               tail.next = node
               self.tail = tail.next
              
          } else {
              // empty list
              tail = node
              head = tail
          }
    }
}
