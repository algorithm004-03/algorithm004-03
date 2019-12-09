public class Solution {
    private boolean isChar(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int i = arr.length - 1, j = 0;
        while (true) {
            if (i < 0) {
                break;
            }

            if (!isChar(arr[i])) {
                i--;
                continue;
            }

            for (j = i-1; j >= 0; j--) {
                if (isChar(arr[j])) {
                    continue;
                }

                if (arr[j] == ' ') {
                    return i - j;
                } else {
                    i = j - 1;
                    break;
                }
            }

            if (j == -1 && isChar(arr[0])) {
                return i + 1;
            }
        }

        return 0;
    }
}
