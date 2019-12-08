# NOTE
Week06学习总结
1.复习BFS/DFS模板
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
     
     3)bfs
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
2.剪枝的理解：CCP即为基于复杂度的剪枝(cost complexity pruning).
3.双向bfs:
	搜索的进程可以看成是从树根出发，遍历一颗倒置的树——搜索树的过程。剪枝就是通过某种判断，避免一些不必要的遍历过程
	相关优化技巧：
	优化搜索顺序
	排除等效冗余
	可行性剪枝
	最优性剪枝
	记忆化
4.启发式搜索：A*搜索，在程序搜索过程中，寻求有利的实现方向的定式。
	A*搜索模板：
			
		def AstartSearch(graph,start,end):
			pq=collections.priority_queue()#借助优先队列，寻求优先级，定义估价函数
			pq.appeand([start]);
			visited.add(start);
			
			while(pq):
				node = pq.pop();//判断是否可以添加更多的有利选项
				visited.add(node)
				
				
				process(node)
				nodes = generate_related_nodes(node)
			unvisited = [node for node in nodes if node not in visited]
				pq.push(unvisited)
			
5.A*搜索场景:
	二进制矩阵中的最短路径(https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china)			

6.AVL树 红黑树 数据结构及特性：
	AVL树：自平衡二叉查找树。在AVL树中任何节点的两个子树的高度最大差别为1，所以它也被称为高度平衡树。增加和删除可能需要通过一次或多次树旋转来重新平衡这个树
	AVL平衡调整策略：
		左旋
		右旋
		左右旋
		右左旋		
		
7.红黑树: 每个节点都带有颜色属性的二叉查找树，颜色或红色或黑色
 	性质1. 节点是红色或黑色。
	性质2. 根节点是黑色。
	性质3 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)
	性质4. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
8.SBT: 节点大小平衡树( Size Balanced Tree),目前为止速度最快的高级二叉搜索树
9.伸展树（Splay Tree），也叫分裂树，是一种二叉排序树，它能在O(log n)内完成插入、查找和删除操作。
10.Treap: Treap=Tree+Heap
 	树堆，在数据结构中也称Treap，是指有一个随机附加域满足堆的性质的二叉搜索树，其结构相当于以随机数据插入的二叉搜索树。其基本操作的期望时间复杂度为O(logn)。相对于其它的平衡二叉搜索树，Treap的特点是实现简单，且能基本实现随机平衡的结构。
 	
