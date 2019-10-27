
# Table of Contents

1.  [Methodologies](#org11ca958)
    1.  [Four Steps Problem Solving Process](#orgf1ee777)
        1.  [Clarification](#org1faabe5)
        2.  [List all solutions](#org8de391d)
        3.  [Code](#org65f6583)
        4.  [Test](#orga3e9759)
    2.  [Consolidate Good Solutions](#orgc5737dc)
2.  [Hash Table, Map and Set](#org5d459a8)
    1.  [Hash Table](#org904a0ff)
        1.  [Gist](#org3663b49)
        2.  [Real world implementation](#orga0826be)
        3.  [Hash Function](#org13d5c16)
        4.  [Big O](#org4ad883a)
        5.  [Python Docs](#orgb8f6af5)
    2.  [LeetCoding](#org7dfc7c7)
        1.  [LeetCode 242 Valid Anagram](#org1c9cb3d)
        2.  [LeetCode 2 Two Sum](#orge5e9595)



<a id="org11ca958"></a>

# Methodologies


<a id="orgf1ee777"></a>

## Four Steps Problem Solving Process


<a id="org1faabe5"></a>

### Clarification


<a id="org8de391d"></a>

### List all solutions


<a id="org65f6583"></a>

### Code


<a id="orga3e9759"></a>

### Test


<a id="orgc5737dc"></a>

## Consolidate Good Solutions

-   Consolidate all the good solutions for each problem
-   Review before interviews


<a id="org5d459a8"></a>

# Hash Table, Map and Set


<a id="org904a0ff"></a>

## Hash Table


<a id="org3663b49"></a>

### Gist

-   Hash tables store key: value pairs
-   Look up the element with time complexity of O(1)
-   Map the key value into a position (index) in the table to speed up the lookup process
    -   this mapping function is called a hashing fuction
    -   this table storing records is called a hash table


<a id="orga0826be"></a>

### Real world implementation

-   Yello pages
-   User lists
-   LRU Cache
-   Redis


<a id="org13d5c16"></a>

### Hash Function

-   val => Hash Function => index
-   Hash Colision: some values will generate the same index value after mapped by the hash function
-   Solution in Java: use a Linked List, adding another dimension. The downside of this solution is as the linked list grows, it will increase the time complexity, approaching O(n)


<a id="org4ad883a"></a>

### Big O

1.  Time

    -   average: O(1) for lookup, insertion, deletion
    -   worst: O(n) => Hash Table is degraded to a Linked List

2.  Space

    -   O(n)


<a id="orgb8f6af5"></a>

### Python Docs

1.  Dictionary

2.  Set


<a id="org7dfc7c7"></a>

## LeetCoding


<a id="org1c9cb3d"></a>

### LeetCode 242 Valid Anagram

1.  Though Process

    -   To determin if two strings s, t are anagram, they need to be:
        -   have the same unique letters
        -   the counts of each unique letters are the same
        -   use dictionary with key is the letter, value is the count

2.  Code

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


<a id="orge5e9595"></a>

### LeetCode 2 Two Sum

