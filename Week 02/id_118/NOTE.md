# 1. Methodologies


## Four Steps Problem Solving Process

- Clarification
- List all possible solutions => optimal (time & space)
- Code
- Test


## Consolidate Good Solutions

-   Consolidate all the good solutions for each problem
-   Review before interviews


# 2. Hash Table, Map and Set


## Hash Table


### Gist

-   Hash tables store key: value pairs
-   Look up the element with time complexity of O(1)
-   Map the key value into a position (index) in the table to speed up the lookup process
    -   this mapping function is called a hashing fuction
    -   this table storing records is called a hash table


### Real world implementation

-   Yello pages
-   User lists
-   LRU Cache
-   Redis


### Hash Function

-   val => Hash Function => index
-   Hash Colision: some values will generate the same index value after mapped by the hash function
-   Solution in Java: use a Linked List, adding another dimension. The downside of this solution is as the linked list grows, it will increase the time complexity, approaching O(n)


### Big O

1.  Time

    -   average: O(1) for lookup, insertion, deletion
    -   worst: O(n) => Hash Table is degraded to a Linked List

2.  Space

    -   O(n)


### Python Implementation

1.  Dictionary

2.  Set


### LeetCode 242 Valid Anagram

1. Thought Process

   -   To determin if two strings s, t are anagram, they need to be:
       -   have the same unique letters
       -   the counts of each unique letters are the same
       -   use dictionary with key is the letter, value is the count

2. Code 1

   ```python
     class Solution:
         def isAnagram(self, s:str, t: str) -> bool:
             s_d, t_d = {}, {}
     
             s_d = self._strTodict(s)
             t_d = self._strTodict(t)
             return s_d == t_d
         
         # def _compareDict(self, s_d:dict, t_d:dict) -> bool:
         #     for k in s_d.keys():
         #         if k not in t_d:
         #             return False
         #         else:
         #             if s_d[k] != t_d[k]:
         #                 return False
         #     return True
     
         def _strTodict(self, s:str) -> dict:
             s_d = {}
             for l in s:
                 if l in s_d:
                     s_d[l] += 1
                 else:
                     s_d[l] = 1
             return s_d
     
     def test():
         s = "anagram"
         t = "nagaram"
     
         sol = Solution()
         print(sol.isAnagram(s, t))
     
     def test2():
         s = "rat"
         t = "car"
         sol = Solution()
         print(sol.isAnagram(s, t))
     
     if __name__ == "__main__":
         test()
         test2()
     
     True
     False
   ```


## Review HashMap in Java


### constructor

1. constructor

   ```java
     public HashMap() {
         this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
     }
   ```

2. default load factor

   ```java
     /**
      * The load factor used when none specified in constructor.
      */
     static final float DEFAULT_LOAD_FACTOR = 0.75f;
   ```

3. put

   ```java
     public V put(K key, V value) {
         return putVal(hash(key), key, value, false, true);
     }
   ```

     1. putVal

        - Initially, the table is empty, table length is 0, invoke the resize function

          ```java
          final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                         boolean evict) {
              Node<K,V>[] tab; Node<K,V> p; int n, i;
              if ((tab = table) == null || (n = tab.length) == 0)
                  n = (tab = resize()).length;
          ```

        - resize will copy the old table and old table threshold

          ```java
          final Node<K,V>[] resize() {
              Node<K,V>[] oldTab = table;
              int oldCap = (oldTab == null) ? 0 : oldTab.length;
              int oldThr = threshold;
          ```

        - Assign new Cap and new Threshold

          ```java
          else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
          }
          ```

        - What's the value of newCap?

          - move 1 to the left by 4 digits => 16

            ```java
            static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
            ```

          - What's the value of new Threshold? 

            `DEFAULT_LOAD_FACTOR` \* `DEFAULT_INITIAL_CAPACITY` = 16 \* 0.75 = 12

        - Why n is the power of 2

          ```java
          if ((p = tab[i = (n - 1) & hash]) == null)
          ```

          It will guarantee the `&` operation here, if it's not the power of 2, it will generate meaningless result

        - Create a new table, which is an array of Nodes

          ```java
          Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
          ```

        - Node should be a node of a linked list

          ```java
          static class Node<K,V> implements Map.Entry<K,V> {
              final int hash;
              final K key;
              V value;
              Node<K,V> next;
          ```


# 3. Tree, Graph, Binary Tree, BST


## 2-D Data Structure

-   The biggest issue with linear data structure is its lookup performance. Time complexity is usually O(n)
-   The key to improve the speed is to create an additional dimension
-   The most common 2-D data structures are Tree and Graph


## Tree


### Gist

-   When a Linked List has multiple next pointers => it becomes a Tree
-   Representation
    ![img](https://www.tutorialspoint.com/data_structures_algorithms/images/binary_tree.jpg)
-   Key elements
    -   Root
    -   Sub-tree
    -   Parent
    -   Child: left, right (for Binary Tree)
    -   Leaf: node without child
    -   Siblings


### Binary Tree

-   The most common trees are Binary Trees
-   A binary tree only has 2 children: left and right


### Code

1. Python

   ```python
   class TreeNode:
       def __init__(self, val):
       		self.val = val
       		self.left, self.right = None, None
   ```


### Traversal

-   One of the most important Tree operations is traversal


## Graph


### Gist

-   The biggest difference between a Tree and a Graph is the Tree doesn't circle backwards
    -   A Linked List is a special type of Tree
    -   Tree is a Graph without loops


# 3. Generic Recursion


## Template


### Python Code

```python
def recursion(level, p1, p2, ...):
    # recursion terminator: must have to avoid stack overflow
    if level > MAX_LEVEL:
        process_result
        return

    # process the logic in the current level
    process(level, data...)

    # drill down
    self.recursion(level+1, p1, p2,...)

    # reverse the current level if needed
```


### Key takeaway

-   Don't perform recursions mannually
-   Find the most recent, repeatable sub-problems (because all of our codes can be converted only to: if&#x2026;else, loop and recursion)
-   Math induction and synthesis
    -   prove the base case, e.g. n = 1, n = 2
    -   prove n + 1 given n
-   MECE: Mutually exclusive; completely exhaustive


## Generate Parentheses


### Step 1

-   generate all the permutation of n pairs
-   don't think about "valid" at this point
-   terminator


### Code Generate Parentheses without validity check

```python
class Solution:
    def generateParenthesis(self, n):
        # terminator level is 0
        # total number of string is 2*n, which is the max level
        # initial state is an empty string ""
        return self._generate(0, 2*n, "")
    
    def _generate(self, level, max_level, curr_state):
        # terminator
        if level >= max_level:
            print(curr_state)
            return
        
        # process current level
        s1 = curr_state + "("
        s2 = curr_state + ")"
        
        # drill down
        self._generate(level + 1, max_level, s1)
        self._generate(level + 1, max_level, s2)        
        
        # reverse state
        # no need as s1, s2 are all local variables
        # didn't use global var

def test():
    sol = Solution()
    sol.generateParenthesis(2)
```


​        

```python
if __name__ == "__main__":
    test()

((((
((()
(()(
(())
()((
()()
())(
()))
)(((
)(()
)()(
)())
))((
))()
)))(
))))
```


### Check validity

- left can be added anytime as long as its number is <= n

- right:

  -   cannot start
  -   must follow a left, and the number of left must be greater than the number of right

  ```python
  class Solution:
      def __init__(self):
          self.res = []
          
  def generate_parentheses(self, n):
      self._gen_par(0, 0, n, "")
      return self.res
  
  def _gen_par(self, left, right, n, curr_state):
      # terminator
      if left == n and right == n:
          self.res.append(curr_state)
          return
  
      # process the current level
      if left < n:
          self._gen_par(left+1, right, n, curr_state+"(")
  
      if right < left:
          self._gen_par(left, right + 1, n, curr_state+")")
  ```

  ```python
  def test():
      sol = Solution()
      print(sol.generate_parentheses(3))
  
  
  if __name__ == "__main__":
      test()
  
  ['((()))', '(()())', '(())()', '()(())', '()()()']
  ```


# 4. Divide & Conquer

-   D&C is a type of recursion
-   It breaks down the target problem into several sub-problems
    -   solve each sub-problem
    -   merge solutions


## Generic Recursion

- Terminator
- Process logic of the current level
- Drill down
- Reverse


### Recursion template code

```python
def gen_recursion(level, max_level, p1, p2,...):
    # 1. Terminator
    if level >= max_level:
        process_result
        return
    # 2. Process the current logic
    # do something
    process(level, data...)
    # 3. Drill down
    self.gen_recursion(level+1, max_level, p1, p2,...)

    # 4. Reverse        
```


## Generic D&C

-   Compare to generic recursion, generic D&C need merge the sub-solutions into a general solution


### D&C template code

```python
def divide_conquer(self, problem, p1, p2, ...):
    # terminator
    if problem is None:
        # there's no subproblems to solve
        do_something
        return

    # prepare data
    data = pre_data(problem)
    # split target problme into subproblems
    subproblems = split_problem(problem, data)

    # conquer sub problems
    sol1 = self.divide_conquer(subproblems[0], p1,...)
    sol2 = self.divide_conquer(subproblems[1], p1,...)
    sol3 = self.divide_conquer(subproblems[2], p1,...)

    # merge the sub-solutions into the final solution
    sol = merge_sol(sol1, sol2, sol3, ...)

    # revert the current level states    
```


# 5. Backtracking

-   A type of recursion
-   Trial and error on each level
