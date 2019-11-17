# NOTE

### 学习总结

#### 1、深度优先和广度优先
模板
```
1、深度优先
visited = set()
def dfs(node,visited):
    visited.add(node)
    …
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)

def dfs(self,tree):
    if tree.root is None:
        return []
    visited,stack = [],[tree.root]
    while stack:
        node = stack.pop()
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
```

```$xslt
2、广度优先
def bfs(graph,start,end):
    queue = []
    queue.append([start])
    visited.add(start)
    
    while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = generate_relateed_nodes(node)
        queue.push(nodes)
```

单词接龙II（126），比较困的一题，学习了其他人的解法,按层遍历，当首先到满足条件的词语后记录最短路径，其他大于的一律return
```
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord.equals(endWord)) {
            return res;
        }
        HashSet<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return res;
        }
        Map<String,List<String>> nodeNeighbors = new HashMap<>();
        wordDict.add(beginWord);
        for (String str:wordDict) {
            nodeNeighbors.put(str,new ArrayList<>());
            wordDict.add(str);
        }

        Map<String,Integer> distanceMap = new HashMap<>();

        bfs(beginWord,endWord,wordDict,nodeNeighbors,distanceMap);

        List<String> solution = new ArrayList<>();
        dfs(beginWord,endWord,nodeNeighbors,res,solution,distanceMap);

        return res;

    }

    private void dfs(String beginWord, String endWord, Map<String,List<String>> nodeNeighbors, List<List<String>> res, List<String> solution,Map<String,Integer> distanceMap) {
        solution.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next:nodeNeighbors.get(beginWord)) {
                if (distanceMap.get(next) == distanceMap.get(beginWord) + 1) {
                    dfs(next,endWord,nodeNeighbors,res,solution,distanceMap);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    private void bfs(String beginWord, String endWord, HashSet<String> wordDict,
                     Map<String, List<String>> nodeNeighbors, Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        distanceMap.put(beginWord,0);
        int shortestDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) { //level by level

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDistance = distanceMap.get(curr);
                if (currDistance > shortestDistance) {
                    return;
                }
                List<String> neighbors = getNeighbors(wordDict,curr);
                for (String neighbor:neighbors) {
                    nodeNeighbors.get(curr).add(neighbor);

                    if (distanceMap.containsKey(neighbor)) {
                        continue;
                    }
                    distanceMap.put(neighbor,currDistance + 1);
                    if (neighbor.equals(endWord)) {
                        shortestDistance = currDistance + 1;
                    } else {
                        queue.offer(neighbor);
                    }
                }
            }

        }

    }

    private List<String> getNeighbors(HashSet<String> wordDict, String curr) {

        List<String> res = new ArrayList<>();
        char[] chs = curr.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i <chs.length; i++) {

                char old = chs[i];
                chs[i] = c;
                if (wordDict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old;
            }
        }

        return res;

    } 
```

#### 贪心和二分查找
1、贪心算法是一种在每一步选择中都采取当前状态下最好或局部最优的选择，从而希望或者导致全局最优或最好的算法
2、不同：贪心不能回退。动态规划保存以前的运算结果，并根据以前的结果进行选择，有回退功能
解决最优问题
最小生成树，haffman

二分查找
1、目标单调性
2、存在上下边界
3、能够通过索引访问
模板
```
left,right = 0,len(array) - 1
while left <= right:
    mid = (left + right) /2 ;
    if array[mid] == target:
        break or return
    else array[mid] < target:
        left = mid + 1;
    else :
        right = mid - 1;

```
旋转数组中最小值判断加了个临界值判断函数
```
private boolean checkPoint(int midIndex,int[] num) {

        int leftIndex = -1;
        int rightIndex = -1;
        //两边判断
        int len = num.length;

        leftIndex = midIndex - 1;
        if (leftIndex < 0) {
            leftIndex = len - 1;
        }
        rightIndex = midIndex + 1;
        if (rightIndex > len - 1) {
            rightIndex = 0;
        }
        int target = num[midIndex];
        if (target < num[leftIndex] && target < num[rightIndex]) {
            return true;
        }
        return false;
    }
```

