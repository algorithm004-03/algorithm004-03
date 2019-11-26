# 

## 总结一下 双向bfs的代码模版 Java 版

```java
	public void ladderLength(graph, start,  end) {
        startQueue;
        endQueue;
        visited;
        startQueue.add(start);
        endQueue.add(end);
        // 双端队列，从这里开始
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
        	// 看那个队列的长度短，就处理那个队列
            if (endQueue.size() < startQueue.size()) {
                tempQueue = startQueue;
                startQueue = endQueue;
                endQueue = tempQueue;
            }
            temp;
            // 处理 开始队列 或者 结束队列
            for (node: startQueue) {
            	visited.add(node);
            	process(node);
            	temp = getRelatedNodes(node);	
            }
            startQueue = temp;
            // 处理其他逻辑
        }
    }
```

  

