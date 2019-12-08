class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;

        if (!wordList.contains(endWord)) {
            return 0;
        }
        count++;

        HashMap<String, ArrayList> commonMap = new HashMap();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                String temp = word.substring(0, j) + "*" + word.substring(j + 1);
                ArrayList mapWords = commonMap.getOrDefault(temp, new ArrayList<String>());
                mapWords.add(word);
                commonMap.put(temp, mapWords);
            }
        }

        HashSet visitSet = new HashSet();
        HashSet<String> begin = new HashSet();
        HashSet<String> end = new HashSet();
        begin.add(beginWord);
        end.add(endWord);
        while (!end.isEmpty() && !begin.isEmpty()) {
            System.out.println("while");

            if (begin.size() > end.size()) {
                HashSet temp = begin;
                begin = end;
                end = temp;
            }

            HashSet nextSet = new HashSet();
            for (String word : begin) {

                if (end.contains(word)) {
                    return ++count;
                }

                for (int i = 0; i < word.length(); i++) {
                    String temp = word.substring(0, i) + "*" + word.substring(i + 1);

                    if (commonMap.containsKey(temp)) {
                        ArrayList list = commonMap.getOrDefault(temp, new ArrayList());

                        for (int j = 0; j < list.size()&&list.size()>0; j++) {
                            String next = (String) list.get(j);
                            if (end.contains(next)) {
                                return ++count;
                            }
                            if (!visitSet.contains(next)) {
                                nextSet.add(next);
                                visitSet.add(next);
                            }
                        }
                    }

                }



            }
            if (nextSet.size() > 0) {
                count++;
            }
            begin = nextSet;

        }
        return 0;
    }

}