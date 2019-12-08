//127. 单词接龙

//解法1：BFS	执行用时：90ms
//思路：和433. 基因序列的思路一样, 区别仅在于转换单词时需要遍历26个字符
//		实例：			hit(begin)
//							↓ result + 1
//					       hot       
//							↓ result + 1
//						dot    lot
//							    ↓ result + 1
//							   log
//							    ↓ result + 1
//							   cog(end)
//时间复杂度：O(wordList.length * 26 * eachWordLen)
//空间复杂度：O(wordList.len * 3)
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	if (beginWord.equals(endWord)) return 1;
	Set<String> visited = new HashSet<>(), wordSet = new HashSet<>(wordList);
	visited.add(beginWord);
	Queue<String> queue = new LinkedList<>();
	queue.offer(beginWord);
	int result = 1;
	while (!queue.isEmpty()) {
		int size = queue.size();
		while (size-- > 0) {
			String str = queue.poll();
			if (str.equals(endWord)) return result;
			char[] temp = str.toCharArray();
			for (int i = 0; i < temp.length; i++) {
				char old = temp[i];
				for (char j = 'a'; j <= 'z'; j++) {
					temp[i] = j;
					String next = String.valueOf(temp);
					if (visited.add(next) && wordSet.contains(next)) queue.offer(next);
				}
				temp[i] = old;
			}
		}
		result++;
	}
	return 0;
}

//解法2：双向BFS	执行用时：18ms
//思路：start和end两端同时进行BFS遍历, 在中间相遇时return result 
//		至于为什么双向BFS的效率要比单端BFS效率更高, 是因为BFS遍历层数越深, 探索的成本就成倍增加
//		因此, 从两个单端浅遍历的BFS遍历要比一个单端深遍历的BFS成本小很多
//时间复杂度：O(wordList.length * eachWordLen * 26)
//空间复杂度：O(wordList.len * 3)
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	if (beginWord.equals(endWord)) return 1;
	Set<String> visited = new HashSet<>(), start = new HashSet<>(), end = new HashSet<>(), wordListSet = new HashSet<>(wordList);
	if (!wordListSet.contains(endWord)) return 0;
	start.add(beginWord); end.add(endWord);
	visited.add(beginWord); visited.add(endWord);
	int len = 1;
	while (!start.isEmpty() && !end.isEmpty()) {
		if (start.size() > end.size()) {
			Set<String> set = start;
			start = end;
			end = set;
		}
		Set<String> temp = new HashSet<>();
		for (String s : start) {
			char[] charArr = s.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				char old = charArr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					charArr[i] = c;
					String next = String.valueOf(charArr);
					if (end.contains(next)) return len + 1;
					if (wordListSet.contains(next) && visited.add(next)) {
						temp.add(next);
					}
				}
				charArr[i] = old;
			}
		}
		start = temp;
		len++;
	}
	return 0;
}