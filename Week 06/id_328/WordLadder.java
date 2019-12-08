class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null ||beginWord == null || endWord == null) return 0;
        if(!wordList.contains(endWord)) return 0;
        if(beginWord.equals(endWord)) return 2;

        Set<String> meets = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        return ladderLength(1,beginSet,endSet,meets);
    }

    private int ladderLength(int level,Set<String> beginSet,Set<String> endSet,Set<String> meets){
		if (beginSet.size() == 0 || endSet.size() == 0)
			return 0;

		meets.removeAll(beginSet);
		level++;
		Set<String> nextLevelSet = new HashSet<>();
		for (String beginWord : beginSet) {
			char[] chars = beginWord.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char temp = chars[i];
				for (char ch = 'a'; ch < 'z'; ch++) {
					chars[i] = ch;
					String newWord = String.valueOf(chars);
					if (!meets.contains(newWord))
						continue;
					if (endSet.contains(newWord))
						return level;
					nextLevelSet.add(newWord);
				}
				chars[i] = temp;
			}
		}

		if (nextLevelSet.size() <= endSet.size()) {
			beginSet = nextLevelSet;
		} else {
			beginSet = endSet;
			endSet = nextLevelSet;
		}

		return this.ladderLength(level, beginSet, endSet, meets);
    }
}