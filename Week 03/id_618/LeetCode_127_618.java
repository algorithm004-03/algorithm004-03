class Solution {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}

		Map<String/* pattern */, List<String>/* words */> patternMap = this.buildPatternMap(wordList);
		Set<String> visited = new HashSet<>();
		// 记录每个节点遍历的深度
		Map<String, Integer> levelMap = new HashMap<>();

		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		levelMap.put(beginWord, 1);

		while (!queue.isEmpty()) {
			String currentWord = queue.poll();
			visited.add(currentWord);

			// 当前深度+1
			int level = levelMap.get(currentWord) + 1;

			String[] patterns = this.getPatterns(currentWord);
			for (String pattern : patterns) {
				List<String> linkedWords = patternMap.get(pattern);

				// 当前单词没有与之匹配的其他单词
				if (linkedWords == null) {
					continue;
				}

				// 找到目标 返回level
				if (linkedWords.contains(endWord)) {
					return level;
				}

				for (String linkedWord : linkedWords) {
					// 已访问的节点不再继续
					if (visited.add(linkedWord)) {
						queue.add(linkedWord);
						levelMap.put(linkedWord, level);
					}
				}
			}
		}

		return 0;
	}

	private Map<String, List<String>> buildPatternMap(List<String> wordList) {
		Map<String, List<String>> map = new HashMap<>();

		for (String word : wordList) {
			String[] patterns = this.getPatterns(word);

			for (String pattern : patterns) {
				List<String> list = map.get(pattern);
				if (list == null) {
					list = new ArrayList<String>();
					map.put(pattern, list);
				}

				list.add(word);
			}
		}

		return map;
	}

	private String[] getPatterns(String word) {
		int length = word.length();
		String[] patterns = new String[length];

		for (int i = 0; i < length; i++) {
			String pattern = word.substring(0, i) + "*";
			if (i < length - 1) {
				pattern += word.substring(i + 1, length);
			}

			patterns[i] = pattern;
		}

		return patterns;
	}

}