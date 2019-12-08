class LeetCode_711_593 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> countor = new HashSet<>(J.length());
        for (char c : J.toCharArray()) {
            countor.add(c);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (countor.contains(c)) {
                count++;
            }
        }
        return count;
    }
}