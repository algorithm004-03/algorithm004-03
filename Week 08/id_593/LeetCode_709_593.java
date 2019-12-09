class LeetCode_709_593 {
    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            builder.append(c);
        }
        return builder.toString();
    }
}