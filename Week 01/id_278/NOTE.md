# NOTE

## 数组、链表、跳表的基本实现和特性

### Array

* 高级语言 泛型
* Inserting: move avg O(n/2) and resize (double size)
* Deleting: move and resize
* prepend - O(1) ?
* append - O(1)
* lookup - O(1)
* insert - **O(n)**
* delete - **O(n)**

### Linked List (LRU cache)

* For frequent insertion and deletion
* Java implemetion is doubly linked
* prepend - O(1)
* append - O(1)
* lookup - **O(n)**
* insert - O(1)
* delete - O(1)

### Skip List (Redis)

* **increase dimension, space for time**
* multi-level indexing
* O(logn) levels with O(logn) time for lookup
* O(logn) for insert and delete, 'cause need to update index
* in reality, it might not be perfect alignments due to element insertion and deletion
* Space O(n)

## Leetccode

* five times
* keep functionally independent util code sections in mind, by repetitive practice
