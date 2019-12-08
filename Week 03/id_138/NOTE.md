# NOTE
Week3学习总结

深度优先遍历(DFS)与广度优先遍历(BFS)
1.算法应用的相关数据结构：树 或者 图（图的数据结构本章课程并未介绍，个人了解一下。因为前面说过，树是一种特殊的图。有助于理解DFS与BFS算法的应用场景。)
	图(Graph)是由顶点的有穷非空集合和顶点之间边的集合组成。图的遍历即从图中某一顶点出发访遍图中其余顶点，且使每一个顶点仅被访问一次。
2.深度优先搜索(Depth First Search)
	思路：类似树的先序遍历，是树的先序遍历的推广。
	1)从树的根节点出发，访问树。
	2)找到刚访问过得节点的第一个未被访问的子节点，访问该节点。以该节点为新节点，重复此步骤，直至刚访问的节点没有未被访问的子节点为止。
	3)返回前一个访问过得且仍有未被访问的节点的父节点，找到该节点的下一个未被访问的子节点，访问该节点。
	4)重复步骤2，3，直至所有节点都被访问过。
	DFS代码模板:
	
	1)递归方式
			visited = set()         #记录已经访问过的节点
			def dfs(node,visited)：    #递归方法
				if node in visited:  #terminater 递归终止条件
					#already visited 
					return
				
					visited.add(node)#加入已访问节点	
					
					#process current node here.
					...
					/*通用处理，如果是二叉树，只需要处理左孩子和右孩子*/
					for next_node in node.children():
						if not next_node in visited:
						dfs(next_node,visited)	
    2)非递归方式
       	def dfs(self,root):
       		if root is None:
       			return [];
       		visited, stack=[],[root]
       		while stack: #循环截止条件：栈为空
       			node = stack.pop() #从栈里弹出节点
       			visited.add(node)#加入到已访问记录
       			
       			proecess(node)#处理当前节点
       			nodes = generate_related_nodes(node)#获取当前节点的子节点
       			stack.push(nodes)#压入栈中
       	#other processing work
       	...			 
	3）应用场景：如果一个问题，能通过归纳画图分解成像树一样的分叉处理，然后重复分叉直到叶子节点，那么都可以归结为深度优先(DFS)处理。
3.广度优先搜索(Breadth First Search)
  	思路：类似树的按层级遍历：
	广度优先搜索使用队列（queue）来实现，整个过程也可以看做一个倒立的树形：
	1)把根节点放到队列的末尾。
	2)每次从队列的头部取出一个元素，查看这个元素所有的下一级元素，把它们放到队列的末尾。并把这个元素记为它下一级元素的前驱。
	3)找到所要找的元素时结束程序。
	4)如果遍历整个树还没有找到，结束程序。
    BFS代码模板：
    
    def bfs(graph,start,end)
      queue = []
      visited = []
      queue.append(start)
      visited.add(start)
      
      while queue:
        node = queue.pop()
        visited.add(node)
        
        
        process(node)
        nodes = genereate_related_nodes(node)
        queue.push(nodes)
        
      #other processing work
      ...   
4.贪心算法
	 贪心算法是指在对某个问题分步骤求解时，总是在当前步骤做出当前的最好选择，而不是考虑所有步骤的情况，即局部最优解。基于此，贪心算法与动态规划算法存在本质的区别。       
        贪心算法对于在每个步骤的解决方案都会做出选择，不能回退。动态规划则会保存每步的解决方案，并根据当前结果进行选择，可以回退。
        贪心算法没有固定的算法框架，算法设计的关键是贪心策略的选择。必须注意的是，贪心算法不是对所有问题都能得到整体最优解，选择的贪心策略必须具备无后效性，即某个状态以后的过程不会影响以前的状态，只与当前状态有关。
    所以对所采用的贪心策略一定要仔细分析其是否满足无后效性。
     由上可知，贪心算法解决问题存在一定的局限性，适应场景必须满足存在最优子结构，并且子问题最优解能递推到最终问题的最优解。例如背包问题，哈夫曼编码问题，图的最小生成树问题。
     贪心算法模板：
     
          从问题的某一初始解出发；
    while （能朝给定总目标前进一步）
    { 
                 利用可行的决策，求出可行解的一个解元素
    }
          由所有解元素组合成问题的一个可行解
    
5.二分查找
	二分查找的前提条件
		1)目标函数单调性，即目标序列是递增或者递减的
		2)存在上下限，不能是无穷的元素(bounded)
		3)能够通过索引访问(index accessible)	    
       二分查找模板(左右边界向中间收敛)
       
     left,right = 0,len(array)-1;
     while(left<=right){
     	mid = (left+right)/2;
     	if array[mid] == target: //find target
     		break or return result; 
        else if array[mid]<target:
        	left=mid+1
        else: 
        	right = mid-1