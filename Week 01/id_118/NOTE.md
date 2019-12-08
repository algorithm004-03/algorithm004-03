# [118-Week01] Recap

## 1. Practice

- There's really no shortcut to it, just practice relentlessly by following the 5-step method. Peace out AI...

  ![AI]( https://i.ytimg.com/vi/K9ZQhyOZCNE/maxresdefault.jpg )

## 2. Time-Space Tradeoff

- Using more space for better performance is a common practice

- Skip List is a good example here, use additional references to speed up the lookup process

  ![skiplist](https://upload.wikimedia.org/wikipedia/commons/8/86/Skip_list.svg)

- Definition from wikipedia:

  -  A space–time or time–memory trade-off in computer science is a case where an algorithm or program trades increased space usage with decreased time. 
  - Here, space refers to the data storage consumed in performing a given task, and time refers to the time consumed in performing a given task. 

  

## 3. Common Techniques. 

- Iterate an array with two pointers without lookup elements repetitively

  - It uses nested loop, so its time complexity is at least O(n^2)

  ```python
  for i in range(len(arr) - 1):
      for j in range(i+1, len(arr)):
          # do something
          pass
  ```

- Use two pointers on either side of array, then converge to the middle

  - It doesn't use nested loop, so its time complexity starts from O(n)

  ```python
  i = 0
  for j in range(len(arr)-1, i, -1):
      #do something
      i += 1
  ```

  - Alternatively use `while` loop

  ```python
  i, j = 0, len(arr)-1
  while i < j:
      # do something
      i += 1
      j -= 1
  ```

  

- Fast and Slow Pointers

  - Used to find if there's a loop in the linked list
  - Space complexity is O(1)

  ```python
  fast = node.nxt
  slow = node.nxt.nxt
  # check if fast and slow will meet
  ```

  

- Find all the solutions, start with Brute Force if possible

- Try to find a solution progressively (Climbing Stairs):
  - What's the simplest case
  - Generalization: find the most recent and repeatable sub-problem and its solution
  - In the end, all the algorithms can be converted to `if...else`, `for`, `while` or recursion

## 4. Linked List

- A truly dynamic linear data structure

- Time complexity of common operations

  | Operations    | Linked List | Array |
  | ------------- | ----------- | :---- |
  | Add Last      | O(1)        | O(1)  |
  | Remove Last   | O(1)        | O(1)  |
  | Add any       | O(1)        | O(n)  |
  | Remove any    | O(1)        | O(n)  |
  | Random Lookup | O(n)        | O(1)  |

- Implement a Linked List in Python

  - Will only implement initialization, delete and add
  - Add Last, Remove Last can be built from general add and remove methods

  ```python
  class LinkedList:
      
      class _Node:
          # internal Node class
          def __init__(self, val=None, nxt=None):            
              self.val = val
              # use nxt here for next as next is a keyword in Python
              self.nxt = nxt
              
      def __init__(self):
          self._dummy_head = self._Node() 
          # create a dummy head of None, pointing to None
          self._size = 0
          # size of the Linked List initiated to 0
          
      def add(self, idx, e):
          # report error if index is illegal
          if not(0 <= idx < self._size):
              raise ValueError("Add Failed. Illegal Index Position")
              
          # iterate from the dummy head to idx
          curr = self._dummy_head
          for i in range(idx):
              curr = curr.next
          new_node = self._Node(e)
          # key: first connect new_node next, then reconnect original idx
          new_node.nxt = curr.nxt
          curr.nxt = new_node
          # resize the linked list
          self._size += 1
          
      def remove(self, idx):
          # report error if index is illegal
          if not(0 <= idx < self._size):
              raise ValueError("Add Failed. Illegal Index Position")
          # iterate from the dummy head to idx
          curr = self._dummy_head
          for i in range(idx):
              curr = curr.nxt
          delete_node = curr.nxt
          # jump over delete_node
          curr.nxt = curr.nxt.nxt
          delete_node.nxt = None
          self._size -= 1
          
  ```

  

## 5. Stack

- FILO

- Time complexity is O(1) for pop and append

- Time complexity is O(n) for lookup, as elements in stacks are orderless

- In Python, list can be used to implement a stack  [Python Doc]( https://docs.python.org/3/tutorial/datastructures.html?highlight=stack )

- Implement a stack in Python using list
  - `list.pop()`remove the top element from the stack
  - `list.append()` add the element to the top of the stack

- Implement a stack in Python

  ```python
  class Stack:
      def __init__(self):
          self._data = list()
          
      def push(self, ele):
          self._data.append(ele)
          
      def pop(self):
          if not len(self._data) > 0:
          	raise ValueError("Stack is empty")
          self._data.pop()
  ```

  

  

## 6. Queue
- FIFO
- Time complexity is O(1) for enqueue and dequeue
- Time complexity is O(n) for lookup, as elements in queues are orderless
- Python has a built-in [queue library]( https://docs.python.org/3/library/queue.html )
  - Queue classes are usually used in threaded programming
  - `queue.Queue()` FIFO queue, the regular queue as we know
  - `queue.SimpleQueue` it's also a FIFO queue, but it cannot be used for task tracking
  - `queue.LifoQueue()` LIFO queue, similar to a stack
  - `queue.PriorityQueue()` , Priority queue, kept sorted with [heapq]( https://docs.python.org/3/library/heapq.html#module-heapq )

- Common built-in Queue methods

  - `Queue.qsize()` get the size of the queue
  - `Queue.empty()` check if a queue is empty
  - `Queue.full()`check if a queue is full
  - `Queue.put()`Put item into the queue => enqueue
  - `Queue.get()`Remove and return the removed element from queue => dequeue

- A queue can also be simply implemented with list in python

  ```python
  class Queue:
      def __init__(self):
          self._data = list()
          
      def enqueue(self, ele):
          # add data to the front of queue
          self._data.insert(0, ele)
          
      def dequeue(self):
          if not len(self._data) > 0:
          	raise ValueError("Queue is empty")
          self._data.pop()        
  ```

  

## 7. Deque

- double-end queue

- Can perform enqueue and dequeue on both top and tail

- Python has a built-in deque data structure in collections library [Deque]( https://docs.python.org/2/library/collections.html#collections.deque )

- Common methods

  - `append(ele)`, add element to the right side of the deque

  - `appendleft(ele)`, add element to the left side of the deque

  - `pop()` Remove and return an element from the right side of the deque. If deque is empty, raise IndexError

  - `popleft()` Remove and return an element from the left size of the deque. If deque is empty, raise IndexError

    Additionally, python deque and extend iterables (list, tuple etc.)

  - `extend(iterable)` extend the right side of the deque by appending elements from the iterable

  - `extendleft(iterable)` extend the left side of the deque by appending elements form the iterable

- Use Python to rewrite Deque, it's quite different from Java, so just for reference

  ```python
  from collections import deque
  d = deque()
  # python can extend a whole iterable into a deque
  d.extend(["a", "b", "c"])
  print(d)
  # for peek, python deque doesn't have built-in method, but there's no need
  # simply look it up as a list
  # peekFirst is equivalent to d[0], peekLast is equivalent to d[-1]
  str = d[0]
  
  while not d.empty():
      d.pop()
  print(d)
  ```



## 8. Priority Queue

- Elements in Priority Queues have priorities, it's more similar to a tree-like data structure.
- There are multiple ways to implement it, e.g. heap, BST, AVL, Red-Black Tree etc.
- Time Complexity is O(1) to add element
- Time Complexity is O(logN) to remove element
- For priority queues, it's important to keep the elements in order. 
  - Assume using a maxheap to represent a priority queue
  - Enqueue: 
    - step1: when add an element, add it to the last of queue 
    
    - step2: then need to use sift up to make sure all elements are in order
  
```python
def _sift_up(self, k):
    while k > 0 and self._data.get(k) > self._data.get(self._parent(k)):
    self._data.swap(k, self._parent(k))
    k = self._parent(k)
```

  - Dequeue
    - step 1: remove the the max element
    
    - step 2: after removing max element, perform sift down to make sure the elements are in order

```python
def _sift_down(self, k):
    while self._left_child(k) < self._data.get_size():
        j = self._left_child(k)
        if j + 1 < self._data.get_size() and self._data.get(j + 1) > self._data.get(j):
            # right child is greater
            j = self._right_child(k)
        # self._data.get(j) is the max(left.child, right.child)
        if self._data.get(k) > self._data.get(j):
            break
        self._data.swap(k, j)
        k = j
```

- Python uses `heapq` to keep the priority queues in order. Here, they use the min heap rather than max heap. some commonly useful methods

  - `heapq.heapify(x)`: transform a list into a heap, in-place, complexity is O(n)

  - `heapq.heappush(heap, item)`: push the item into the heap, keeping the heap in order
  - `heapq.headpop(heap)`Pop and return the smallest item from the heap, keeping the heap in order
