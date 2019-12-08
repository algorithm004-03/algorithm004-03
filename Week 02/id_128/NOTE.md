  
Hash table (abstract)

一定要设计好的哈希函数 - 将key均匀映射以尽量避免哈希碰撞

time complexity
average insert, delete, search O(1)
Worst case (bad hash function)  O(n)


binary search tree （sorted binary tree）
左子树所有节点值均小于根节点值
右子树所有节点值均大于根节点值
左右子树也是二叉搜索树

中序遍历二叉搜索树即得到升序排列

递归四步
1. 中介条件
2. 处理当前层
3. 下探
4. 清理当前层变量

解题四步
1. clarification  
    a. 不认识 不明白的词
    b. 边缘情况
    c. case sensitive？
    d。 etc。
2. possible solutions  --> optimal (time&space)
3. code
4. test cases


思维要点：
1. 抵制人肉递归
2. 找到最近最贱的方法， 将其拆解成可重复解决的问题 - 重复子问题
3. 数学归纳法的思维

递归模版
public void recur(int level, int param) { 

  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic 
  process(level, param); 

  // drill down 
  recur( level: level + 1, newParam); 

  // restore current status 
 
}


divide and conquer
理念 - 将原问题拆分成n个规模较小的且与原问题相似的子问题，是的每个子问题都易于求解，然后将子问题结果归并，从而得到原问题的解
递归的变体 - 不是顺序递归， 需要多一步来合并结果

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

back tracking 回溯
是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标
采用试错思想，当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为 回溯点

本周学习时间较短，课程较多。 分治的习题还需要继续练习。
本周贯彻五毒神掌做题法 （第三毒）， 将第一周的题目全部再做了一遍。发现大部分题目已经忘记了具体答案，无法向上一次重复时，直接（默）写出来。但是按照四步解题法，在得出暴力答案之后，很快就能得出最优解思路并且写出解题算法。但是对于每种方法的复杂度分析还拿不准，仍然需要参照题解。


