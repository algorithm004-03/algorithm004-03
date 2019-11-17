//433. 最小基因变化

//解法1：广度优先遍历
//思路：将start序列转换为charArray, 遍历转换每一个字母观察新序列是否存在于基因库bank中, 若存在且之前未访问过就存放至队列用于下一次判断, 重复步骤直到寻找到匹配序列end
public int minMutation(String start, String end, String[] bank) {
	Set<String> visited = new HashSet<>();
	visited.add(start);

	Set<String> bankSet = new HashSet<>();
	for (String s : bank) {
		bankSet.add(s);
	}

	Queue<String> curr = new LinkedList<>();
	curr.add(start);

	final char[] genetic = new char[]{'A', 'C', 'G', 'T'};
	int level = 0;
	
	while (!curr.isEmpty()) {
		int size = curr.size();
		for (int i = 0; i < size; i++) {
			if (curr.peek().equals(end)) return level;
			char[] charArr = curr.poll().toCharArray();
			for (int j = 0; j < charArr.length; j++) {
				char old = charArr[j];
				for (char c : genetic) {
					charArr[j] = c;
					String next = new String(charArr);
					if (!visited.contains(next) && bankSet.contains(next)) {
						visited.add(next);
						curr.offer(next);
					}
				}
				charArr[j] = old;
			}
		}
		level++;
	}
	return -1;
}