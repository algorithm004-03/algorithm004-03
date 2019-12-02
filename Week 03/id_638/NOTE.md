# NOTE
visited = set()

def dfs(node, visited):
if node in visited: # terminator
	# already visited
	return

	visited.add(node)

	# process current node here.
	...
	for next_node in node.children():
		if not next_node in visited:
			dfs(next_node, visited)

一：dfs
    递归方式：
    1：判断终止条件，是否被访问过
    2：处理当前曾逻辑
    3：下探下一层
    非递归：
    def DFS(self, tree):

    	if tree.root is None:
    		return []

    	visited, stack = [], [tree.root]

    	while stack:
    		node = stack.pop()
    		visited.add(node)

    		process (node)
    		nodes = generate_related_nodes(node)
    		stack.push(nodes)

    	# other processing work

  二、bfs
  def BFS(graph, start, end):

  	queue = []
  	queue.append([start])
  	visited.add(start)

  	while queue:
  		node = queue.pop()
  		visited.add(node)

  		process(node)
  		nodes = generate_related_nodes(node)
  		queue.push(nodes)

  	# other processing work


二分查找；
    模版：
    left, right = 0, len(array) - 1
    while left <= right: //大部分情况需要等于
    	  mid = (left + right) / 2
    	  if array[mid] == target:
    		    # find the target!!
    		    break or return result
    	  elif array[mid] < target:
    		    left = mid + 1
    	  else:
    		    right = mid - 1





  

