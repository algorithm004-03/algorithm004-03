/**
 * 双向BFS
 */
class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// endWord也是transformed word, 所以必须存在于wordList中, 否则返回0, 表示无法从beginWord变成endWord
		if (!wordList.contains(endWord)) {
			return 0;
		}

		HashMap<String, ArrayList<String>> patterns = buildPatterns(beginWord, wordList);

		HashSet<String> begin = new HashSet<>();
		HashSet<String> end = new HashSet<>();
		begin.add(beginWord);
		end.add(endWord);

		HashSet<String> visited = new HashSet<>();
		int len = 1;

		while (!begin.isEmpty() && !end.isEmpty()) {
			// 当前循环从哪个方向进行bfs; 让begin指向size更小的集合, 这样就不会一直从一个方向bfs了
			if (begin.size() > end.size()) {
				HashSet<String> tmp = begin;
				begin = end;
				end = tmp;
			}

			HashSet<String> nextWords = new HashSet<>();
			for (String word : begin) {
				for (int i = 0; i < word.length(); i++) {
					String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

					ArrayList<String> matchWords = patterns.get(pattern);

					if (matchWords == null) {
						continue;
					}

					for (String matchWord : matchWords) {
						if (end.contains(matchWord)) {
							return len + 1;
						}

						if (!visited.contains(matchWord)) {
							visited.add(matchWord);
							nextWords.add(matchWord);
						}
					}
				}
			}

			begin = nextWords;
			len++;
		}

		return 0;
	}

	private HashMap<String, ArrayList<String>> buildPatterns(String beginWord, List<String> wordList) {
		HashMap<String, ArrayList<String>> patterns = new HashMap<>();

		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
				if (!patterns.containsKey(pattern)) {
					patterns.put(pattern, new ArrayList<String>());
				}

				patterns.get(pattern).add(word);
			}
		}

		return patterns;
	}
}