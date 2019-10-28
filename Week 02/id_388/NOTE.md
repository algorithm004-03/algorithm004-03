# NOTE

### 学习总结

四件套：1、过一遍 2、最优  3、code 4、测试样例 

#### 1、数据结构
1、hash  
根据您keyvalue直接访问。映射函数叫三列函数，存放记录的数组叫哈希表（散列表）。 平均时间复杂度是o1，严重的会退化到on

2、Set
不重复元素的集合
hashset实现：add map put.  hashmap-put和get  treemap 和trset都是logn

3、 tree
linklist是另一种形式的tree,tree是另一种形式的图
树的遍历：前序遍历，中序遍历，后续遍历,这期做了几个关于遍历的题目。如序列化，反序列化，根据前序和中序遍历恢复tree
二叉搜索树。左子树的值都小于它的根节点，柚子树大于大的根节点。查询和操作都是 logn

#### 2、算法

##### a、递归模板

1、递归终结条件
2、处理这一层的逻辑
3、下一层
4、清理当前层
```
public void recur(int level,int param) {
    if (level > MAX_LEVEL) {
        //process result
        return;
    }
    process(level,param);
    
    recur(level + 1,newParam)
    //restore current status
}

```

#### b、分治代码模板，两者很相似
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

###### c、关于n换后的对角线问题

pie:  row + col的值,对角线的值都一样，如2，2，2；3，3，3，3
| 0 | 1 |2  | 3 |
| --- | --- | --- | --- |
| 1 | 2 | 3 | 4 |
| 2 | 3 | 4 | 5 |
| 3 | 4 | 5 | 6 |

na：row - col的值，na方向的值都一样
| 0 | -1 |-2  |-3  |
| --- | --- | --- | --- |
| 1 | 0 | -1 | -2 |
| 2 | 1 | 0 | -1 |
| 3 | 2 | 1 | 0 |