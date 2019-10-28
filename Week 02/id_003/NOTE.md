# NOTE
## 第一课 哈希表、映射、集合的实现与特性
哈希表（hash table）, 也叫散列表，是根据关键码值（Key value）而进行直接访问的数据结构
他通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
这个映射函数叫做散列函数（hash function），存放记录的数组叫做哈希表（或散列表）。
可通过拉链存储法存储多个值解决碰撞
查询时间复杂度O(1)
### homework 
写一个hashMap的小总结

## 项目实战
*[242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)*

> 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
> 示例 1:
> 输入: s = "anagram", t = "nagaram"
> 输出: true
> 示例 2:
> 
> 输入: s = "rat", t = "car"
> 
> 输出: false
> 说明:
> 你可以假设字符串只包含小写字母。
> 
> 进阶:
> 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
```
//方法一： 先排序，后比较
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 //先将字符串大散成数组之后排序，排序后再比较即可
var isAnagram = function(s, t) {
    
    if(s.length != t.length) return false;
    s = sortStr(s);
    t = sortStr(t);
    
    return s === t;
};
sortStr = function(s){
    let arr = s.split('');
    arr = arr.sort();
    s = arr.join('');
    return s;
}
//方法二
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}   
```
*[1.两数之和](https://leetcode-cn.com/problems/two-sum/description/)*
>给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
>
>你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
>
>示例:
>
>给定 nums = [2, 7, 11, 15], target = 9
>
>因为 nums[0] + nums[1] = 2 + 7 = 9
>所以返回 [0, 1]
>进阶：
>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

> 解答：
> 使用哈希表而不是固定大小的计数器。想象一下，分配一个大的数组来适应整个 Unicode 字符范围，这个范围可能超过 100万。哈希表是一种更通用的解决方案，可以适应任何字符范围。
```
1.暴力求解法：
var twoSum = function(nums, target) {
    for (var i = 0; i < nums.length; i++) {
        for ( var j = i+1; j < nums.length; j++)
            if (nums[i] == target - nums[j]) {
                return [i,j]
            }
    }
};

2.两遍哈希法
var twoSum = function(nums, target) {
    var obj = {};
    for( let i = 0; i < nums.length; i++) {
        obj[nums[i]] = i;
    }
    
    for( let i = 0; i < nums.length; i++ ) {
        let complement = target - nums[i];
        //obj[nums[i]] != i用于判断该属性不是同一个属性下面的值
        if (obj.hasOwnProperty(complement) && obj[complement] != i ){
            return [ i, obj[ complement  ] ] 
        } 
    }
    
};

3.一遍哈希法

//在放入的同时查看是否已存在该目标值
var twoSum = function(nums, target) {
    let map = {}
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if(map[complement] != undefined)
            return [map[complement],i]
        map[nums[i]] = i        
    }
};

```
## 作业

*[49. 字母异位词分组 - 力扣（LeetCode）](https://leetcode-cn.com/problems/group-anagrams/)*

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],

输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
```
//将排序后的值作为key进行判断
var groupAnagrams = function(strs) {
    if (strs.length == 0) {
        retuurn [null];
    }
    let map = {};
    strs.map(val => {
        let ans = sort(val);
        // console.log(ans,val);        
        if (map[ans] !=undefined) {
            map[ans].push(val)
        } else  {
            map[ans] = [val]
        }
    })
    let resArr = [];
    for (const val in map) {
        resArr.push(map[val]);
    }
    return resArr;
};

const sort = function(s){
    s = s.split("");
    s = s.sort();
    return s.join('');
}
```

## 第二课 树、二叉树、二叉搜索树的实现和特性
**二叉树**

    结点只有两个 

**二叉搜索树**

 [VisuAlgo - 二叉搜索树，高度平衡树](https://visualgo.net/zh/bst)

也称二叉搜索树、有序二叉树（ordered binary tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：
    1. 左子树上所有结点的值均小于它的根节点的值；
    2. 右子树上所有结点的值均大于它的根节点的值；
    3. 以此类推：左右子树也分别为二叉查找树。
 
 
## 作业

[429. N叉树的层序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

```

// 思路总结：
/* 
  1. 把当前的结点放入队列
  2. 将队列的值依次弹出，弹出是顺便将结点值的孩子结点中的内容全部放入队列
  
*/
var levelOrder = function(root) {
  if (root == null) return [];

  let res = []
  let queue = [];
  
  queue.push(root)

  while (queue.length != 0) {
    let i = queue.length;
    let list = []
    while (i--) {
      let cur = queue.shift();
      
      list.push(cur.val);
      for (const node of cur.children) {
        if (node!=null) {
           queue.push(node);
        }
      }
    }
    res.push(list)
  }
    return res
  };
  
```

[589. N叉树的前序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/)

```
var postorder = function(root) {
    let res = []
    if (root == null) {
        return res;
    }
    fun(root)
    function fun(root){
        if(root == null) return;
        res.push(root.val)
        for (let i = 0; i < root.children.length; i++){
            fun(root.children[i]);
        }
    }
    return res;
};

```

[590. N叉树的后序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)

```
var postorder = function(root) {
    let res = []
    if (root == null) {
        return res;
    }
    fun(root)
    function fun(root){
        if(root == null) return;
        for (let i = 0; i < root.children.length; i++){
            fun(root.children[i]);
        }
        res.push(root.val)
    }
    return res;
};
```

[144. 二叉树的前序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
```
var preorderTraversal = function(root) {
    var result = [];
    function pushRoot(node){
        if(node != null){
            result.push(node.val);
            if(node.left != null){
                pushRoot(node.left);
            }
            if(node.right != null){
                pushRoot(node.right);
            } 
        }
    }
    pushRoot(root);
    return result;
};

```

[94. 二叉树的中序遍历 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
```
var preorderTraversal = function(root) {
    var result = [];
    function pushRoot(node){
        if(node != null){
            if(node.left != null){
                pushRoot(node.left);
            }
            result.push(node.val);
            if(node.right != null){
                pushRoot(node.right);
            } 
        }
    }
    pushRoot(root);
    return result;
};

```

## 第三课 泛型递归 树的递归

   
***实战题目***
* [297. 二叉树的序列化与反序列化 - 力扣（LeetCode）](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
* [111. 二叉树的最小深度 - 力扣（LeetCode）](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
* [104. 二叉树的最大深度 - 力扣（LeetCode）](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
* [98. 验证二叉搜索树 - 力扣（LeetCode）](https://leetcode-cn.com/problems/validate-binary-search-tree/)
* [226. 翻转二叉树 - 力扣（LeetCode）](https://leetcode-cn.com/problems/invert-binary-tree/description/)
* [22. 括号生成 - 力扣（LeetCode）](https://leetcode-cn.com/problems/generate-parentheses/)
* [70. 爬楼梯 - 力扣（LeetCode）](https://leetcode-cn.com/problems/climbing-stairs/)

***课后作业***
* [47. 全排列 II - 力扣（LeetCode）](https://leetcode-cn.com/problems/permutations-ii/)
* [46. 全排列 - 力扣（LeetCode）](https://leetcode-cn.com/problems/permutations/)
* [77. 组合 - 力扣（LeetCode）](https://leetcode-cn.com/problems/combinations/)
* [105. 从前序与中序遍历序列构造二叉树 - 力扣（LeetCode）](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
* [236. 二叉树的最近公共祖先 - 力扣（LeetCode）](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## 第四课 分治回溯1. 分治
   将一个大问题分成几个子问题
   本质：找重复性以及分解问题和最后组合每个子问题的结果（区分变与不变，重复的问题属于不变的）

   代码模板：
```
   def divide_conquer(problem, param1, param2, ...): 
    # recursion terminator 
    if problem is None: 
        print_result 
        return 

    # prepare data 
    data = prepare_data(problem) 
    subproblems = split_problem(problem, data) 

    # conquer subproblems 
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
    subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
    subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
    …

    # process and generate the final result 
    result = process_result(subresult1, subresult2, subresult3, …)
        
    # revert the current level states
```
***预习题目***
* [78. 子集 - 力扣（LeetCode）](https://leetcode-cn.com/problems/subsets/)
```
  var myPow = function(x, n) {
    function pow(x,n){
        if (n==0) {
            return 1.0;
        }

        let half = pow(x,Math.floor(n/2));
        
        if(n % 2 == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }
    let N = n;
    if (N<0) {
        x = 1 / x;
        N = -N;
    }
    return pow(x , N)
};
```
* [Pow(x, n) - Pow(x, n) - 力扣（LeetCode）](https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/)

```
    var subsets = function(nums) {
        ans = [];
        if ( nums == null ) return ans;
        dfs(ans, nums, [], 0);

        function dfs(ans, nums, list, index) {
            if (index == nums.length) {
                ans.push(list);
                return;
            }
        
            dfs(ans,nums, [...list], index+1);
            // dfs(ans,nums, list, index+1);
        
            list.push(nums[index]);
            dfs(ans,nums, [...list], index+1);
            // dfs(ans, nums, list, index+1);
        
            // list.pop();  //这里不行???
        }
        return ans;
    };
```

* [51. N皇后 - 力扣（LeetCode）](https://leetcode-cn.com/problems/n-queens/)
  
* [17. 电话号码的字母组合 - 力扣（LeetCode）](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
  
* [169. 求众数 - 力扣（LeetCode）](https://leetcode-cn.com/problems/majority-element/description/)

* [Leetcode Sqrt(x):牛顿迭代法和Quake-III中的神奇方法 - 程序园](http://www.voidcn.com/article/p-eudisdmk-zm.html)
  
* [牛顿迭代法快速寻找平方根 | Matrix67: The Aha Moments](http://www.matrix67.com/blog/archives/361)
  