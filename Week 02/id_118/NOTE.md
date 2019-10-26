
# Table of Contents

1.  [Methodologies](#org98cc219)
    1.  [Four Steps Problem Solving Process](#org51bf1b6)
        1.  [Clarification](#org777a343)
        2.  [List all possible solutions => optimal (time & space)](#org49d2222)
        3.  [Code](#org65bfb39)
        4.  [Test](#org27fcd6a)
    2.  [Consolidate Good Solutions](#org4594ee6)
2.  [Hash Table, Map and Set](#orgb82791d)
    1.  [Hash Table](#orgee5490e)
        1.  [Gist](#org84ba80d)
        2.  [Real world implementation](#org99ec3f8)
        3.  [Hash Function](#orge877797)
        4.  [Big O](#org0c7ca11)
        5.  [Python Docs](#org42ddf99)
    2.  [LeetCoding](#org9acb863)
        1.  [LeetCode 242 Valid Anagram](#orgea2f061)
        2.  [LeetCode 2 Two Sum](#org67b0640)
    3.  [Review HashMap in Java](#org529d441)
        1.  [constructor](#orgb1ef46c)
3.  [Tree, Graph, Binary Tree, BST](#org1d65c9c)
    1.  [2-D Data Structure](#org419f7c1)
    2.  [Tree](#orgf4b95b1)
        1.  [Gist](#org90ed210)
        2.  [Binary Tree](#org39330aa)
        3.  [Code](#org8566dff)
        4.  [Traversal](#orgd862e92)
    3.  [Graph](#orgb9685ef)
        1.  [Gist](#orgddf0abf)
4.  [Generic Recursion](#orge7c2f8c)
    1.  [Template](#orgd8a4ac0)
        1.  [Python Code](#orgc91e4d9)
        2.  [Key takeaway](#org70717f3)
    2.  [Generate Parentheses](#orga37b9df)
        1.  [Step 1](#org768848a)
        2.  [Code Generate Parentheses without validity check](#org077893f)
        3.  [Check validity](#orgf5b6ec2)
5.  [Divide & Conquer](#org9db46b6)
    1.  [Generic Recursion](#org2c08284)
        1.  [Terminator](#org581cc6c)
        2.  [Process logic of the current level](#orgdfd5a5c)
        3.  [Drill down](#org09b20cc)
        4.  [Reverse](#org6add458)
        5.  [Code template](#orgbb48e37)
    2.  [Generic D&C](#orga5ecc41)
        1.  [Template Code](#orgebb0bbf)
6.  [Backtracking](#orgb5aceed)



<a id="org98cc219"></a>

# Methodologies


<a id="org51bf1b6"></a>

## Four Steps Problem Solving Process


<a id="org777a343"></a>

### Clarification


<a id="org49d2222"></a>

### List all possible solutions => optimal (time & space)


<a id="org65bfb39"></a>

### Code


<a id="org27fcd6a"></a>

### Test


<a id="org4594ee6"></a>

## Consolidate Good Solutions

-   Consolidate all the good solutions for each problem
-   Review before interviews


<a id="orgb82791d"></a>

# Hash Table, Map and Set


<a id="orgee5490e"></a>

## Hash Table


<a id="org84ba80d"></a>

### Gist

-   Hash tables store key: value pairs
-   Look up the element with time complexity of O(1)
-   Map the key value into a position (index) in the table to speed up the lookup process
    -   this mapping function is called a hashing fuction
    -   this table storing records is called a hash table


<a id="org99ec3f8"></a>

### Real world implementation

-   Yello pages
-   User lists
-   LRU Cache
-   Redis


<a id="orge877797"></a>

### Hash Function

-   val => Hash Function => index
-   Hash Colision: some values will generate the same index value after mapped by the hash function
-   Solution in Java: use a Linked List, adding another dimension. The downside of this solution is as the linked list grows, it will increase the time complexity, approaching O(n)


<a id="org0c7ca11"></a>

### Big O

1.  Time

    -   average: O(1) for lookup, insertion, deletion
    -   worst: O(n) => Hash Table is degraded to a Linked List

2.  Space

    -   O(n)


<a id="org42ddf99"></a>

### Python Docs

1.  Dictionary

2.  Set


<a id="org9acb863"></a>

## LeetCoding


<a id="orgea2f061"></a>

### LeetCode 242 Valid Anagram

1.  Though Process

    -   To determin if two strings s, t are anagram, they need to be:
        -   have the same unique letters
        -   the counts of each unique letters are the same
        -   use dictionary with key is the letter, value is the count

2.  Code 1

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


<a id="org67b0640"></a>

### LeetCode 2 Two Sum


<a id="org529d441"></a>

## TODO Review HashMap in Java


<a id="orgb1ef46c"></a>

### constructor

1.  constructor

        public HashMap() {
            this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
        }

2.  default load factor

        /**
         * The load factor used when none specified in constructor.
         */
        static final float DEFAULT_LOAD_FACTOR = 0.75f;

3.  put

        public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true);
        }
    
    1.  putVal
    
        -   Initially, the table is empty, table length is 0, invoke the resize function
        
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                           boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
        
        1.  resize
        
            -   resize will copy the old table and old table threshold
            
                final Node<K,V>[] resize() {
                    Node<K,V>[] oldTab = table;
                    int oldCap = (oldTab == null) ? 0 : oldTab.length;
                    int oldThr = threshold;
        
        2.  assign new Cap and new Threshold
        
                else {               // zero initial threshold signifies using defaults
                    newCap = DEFAULT_INITIAL_CAPACITY;
                    newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
                }
            
            1.  What's the value of newCap?
            
                -   move 1 to the left by 4 digits => 16
                
                    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
            
            2.  What's the value of new Threshold?
            
                -   `DEFAULT_LOAD_FACTOR` \* `DEFAULT_INITIAL_CAPACITY` = 16 \* 0.75 = 12
            
            3.  Why n is the power of 2
            
                    if ((p = tab[i = (n - 1) & hash]) == null)
        
        3.  Create a new table
        
            -   Create a new table, which is an array of Nodes
            
                Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        
        4.  table
        
            -   it's an array of Nodes
            
                transient Node<K,V>[] table;
        
        5.  Node
        
            -   Node should be a node of a linked list
            
                static class Node<K,V> implements Map.Entry<K,V> {
                    final int hash;
                    final K key;
                    V value;
                    Node<K,V> next;


<a id="org1d65c9c"></a>

# Tree, Graph, Binary Tree, BST


<a id="org419f7c1"></a>

## 2-D Data Structure

-   The biggest issue with linear data structure is its lookup performance. Time complexity is usually O(n)
-   The key to improve the speed is to create an additional dimension
-   The most common 2-D data structures are Tree and Graph


<a id="orgf4b95b1"></a>

## Tree


<a id="org90ed210"></a>

### Gist

-   When a Linked List has multiple next pointers => it becomes a Tree
-   Representation
    ![img](./assets/binary_tree.jpg)
-   Key elements
    -   Root
    -   Sub-tree
    -   Parent
    -   Child: left, right (for Binary Tree)
    -   Leaf: node without child
    -   Siblings


<a id="org39330aa"></a>

### Binary Tree

-   The most common trees are Binary Trees
-   A binary tree only has 2 children: left and right


<a id="org8566dff"></a>

### Code

1.  Python

        class TreeNode:
            def __init__(self, val):
                self.val = val
                self.left, self.right = None, None


<a id="orgd862e92"></a>

### Traversal

-   One of the most important Tree operations is traversal


<a id="orgb9685ef"></a>

## Graph


<a id="orgddf0abf"></a>

### Gist

-   The biggest difference between a Tree and a Graph is the Tree doesn't circle backwards
    -   A Linked List is a special type of Tree
    -   Tree is a Graph without loops


<a id="orge7c2f8c"></a>

# Generic Recursion


<a id="orgd8a4ac0"></a>

## Template


<a id="orgc91e4d9"></a>

### Python Code

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


<a id="org70717f3"></a>

### Key takeaway

-   Don't perform recursions mannually
-   Find the most recent, repeatable sub-problems (because all of our codes can be converted only to: if&#x2026;else, loop and recursion)
-   Math induction and synthesis
    -   prove the base case, e.g. n = 1, n = 2
    -   prove n + 1 given n
-   MECE: Mutually exclusive; completely exhaustive


<a id="orga37b9df"></a>

## Generate Parentheses


<a id="org768848a"></a>

### Step 1

-   generate all the permutation of n pairs
-   don't think about "valid" at this point
-   terminator


<a id="org077893f"></a>

### Code Generate Parentheses without validity check

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
        sol.generateParenthesis(3)
    
        
    if __name__ == "__main__":
        test()

    ((((((
    ((((()
    (((()(
    (((())
    ((()((
    ((()()
    ((())(
    ((()))
    (()(((
    (()(()
    (()()(
    (()())
    (())((
    (())()
    (()))(
    (())))
    ()((((
    ()((()
    ()(()(
    ()(())
    ()()((
    ()()()
    ()())(
    ()()))
    ())(((
    ())(()
    ())()(
    ())())
    ()))((
    ()))()
    ())))(
    ()))))
    )(((((
    )(((()
    )((()(
    )((())
    )(()((
    )(()()
    )(())(
    )(()))
    )()(((
    )()(()
    )()()(
    )()())
    )())((
    )())()
    )()))(
    )())))
    ))((((
    ))((()
    ))(()(
    ))(())
    ))()((
    ))()()
    ))())(
    ))()))
    )))(((
    )))(()
    )))()(
    )))())
    ))))((
    ))))()
    )))))(
    ))))))


<a id="orgf5b6ec2"></a>

### Check validity

-   left can be added anytime as long as its number is <= n
-   right:
    -   cannot start
    -   must follow a left, and the number of left must be greater than the number of right

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
    
    def test():
        sol = Solution()
        print(sol.generate_parentheses(3))
    
        
    if __name__ == "__main__":
        test()

    ['((()))', '(()())', '(())()', '()(())', '()()()']


<a id="org9db46b6"></a>

# Divide & Conquer

-   D&C is a type of recursion
-   It breaks down the target problem into several sub-problems
    -   solve each sub-problem
    -   merge solutions


<a id="org2c08284"></a>

## Generic Recursion


<a id="org581cc6c"></a>

### Terminator


<a id="orgdfd5a5c"></a>

### Process logic of the current level


<a id="org09b20cc"></a>

### Drill down


<a id="org6add458"></a>

### Reverse


<a id="orgbb48e37"></a>

### Code template

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


<a id="orga5ecc41"></a>

## Generic D&C

-   Compare to generic recursion, generic D&C need merge the sub-solutions into a general solution


<a id="orgebb0bbf"></a>

### Template Code

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


<a id="orgb5aceed"></a>

# Backtracking

-   A type of recursion
-   Trial and error on each level

