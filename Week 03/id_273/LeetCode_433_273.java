//433. 最小基因变化

//解法1：广度优先遍历	执行用时：1ms
//思路：根据基因库遍历转换start序列的每一个基因字符, 观察每一次基因变化的结果是否存在于基因库bank中：
//			若存在于基因库中, 但并不是目标基因end, 那么就以这个基因为start继续进行基因转换（注意不要重复转换之前转换过的基因--Set）
//			若存在于基因库中, 且是目标基因end, return转换的次数即可
//		题目的核心就是图的广度优先遍历
//		例如：                 AACCGGTT(start)
//								  ↓        result+1
//							   AACCGCTA
//								  ↓        result+1
//					    AACCGCTA      AAACGCTA(target)

public int minMutation(String start, String end, String[] bank) {
	Set<String> visited = new HashSet<>(), bankSet = new HashSet<>(Arrays.asList(bank));
	visited.add(start);
	if (!bankSet.contains(end)) return -1;
	Queue<String> queue = new LinkedList<>();
	queue.offer(start);
	char[] genertic = new char[]{'A', 'C', 'G', 'T'};
	int result = 0;
	while (!queue.isEmpty()) {
		int size =  queue.size();
		while (size-- > 0) {
			String str = queue.poll();
			if (str.equals(end)) return result;
			char[] temp = str.toCharArray();
			for (int i = 0; i < temp.length; i++) {
				char old = temp[i];
				for (char c : genertic) {
					temp[i] = c;
					String next = String.valueOf(temp);
					if (visited.add(next) && bankSet.contains(next)) queue.offer(next);
				}
				temp[i] = old;
			}
		}
		result++;
	}
	return -1;
}

//解法2：双向BFS	执行用时：1ms
//思路：同127. 解法2
public int minMutation(String start, String end, String[] bank) {
	if (start.equals(end)) return 0;
	List<String> bankList = new ArrayList<>(Arrays.asList(bank));
	Set<String> visited = new HashSet<>(), startSet = new HashSet<>(),
			endSet = new HashSet<>(), bankSet = new HashSet<>(bankList);
	if (!bankSet.contains(end)) return -1;
	startSet.add(start);
	endSet.add(end);
	char[] genertc = new char[]{'A', 'C', 'G', 'T'};
	int len = 1;
	while (!startSet.isEmpty() && !endSet.isEmpty()) {
		if(startSet.size() > endSet.size()) {
			Set<String> set = startSet;
			startSet = endSet;
			endSet = set;
		}
		Set<String> temp = new HashSet<>();
		for (String s : startSet) {
			char[] charArr = s.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				char c = charArr[i];
				for (int j = 0; j < genertc.length; j++) {
					charArr[i] = genertc[j];
					String next = String.valueOf(charArr);
					if (endSet.contains(next)) return len;
					if (bankSet.contains(next) && visited.add(next)) temp.add(next);
				}
				charArr[i] = c;    
			}
		}
		startSet = temp;
		len++;
	}   
	return -1;
}