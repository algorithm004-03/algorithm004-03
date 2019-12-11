class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" +");
        StringBuilder ret = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) {
                continue;
            }
            ret.append(strs[i].trim() + " ");
        }

        if (ret.length() > 0) {
            ret.deleteCharAt(ret.length() - 1);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(""));
    }
}