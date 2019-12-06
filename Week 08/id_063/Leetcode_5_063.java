/*

经典Manacher 算法求最长回文串长度

 */



public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        // 字符串中间插入#特殊字符，防止奇偶回文串的判断
        StringBuffer buf = new StringBuffer();
        buf.append("#");
        for (int i = 0; i < s.length(); i++) {
            buf.append(s.charAt(i) + "#");
        }
        String ss = buf.toString();

        int R;      // 当所有产生过的回文右边界的最大值
        int C;      // 第一次产生R的时候的回文中心位置
        int[] r = new int[ss.length()];     // r[i]表示以ss[i]为中心的最长回文的半径长度
        int L;      // R C 对应的回文的左边界

        R = 0; C = 0; r[0] = 1;     // 第一个字符用来初始化状态
        for (int i = 1; i < ss.length(); i++) {
            if (i > R) {
                // 当前点不在L R区间里面，直接进行暴力搜索
                int j1 = i, j2 = i;
                while (true) {
                    if ((j1 < 0) || (j2 > ss.length()-1) || ss.charAt(j1) != ss.charAt(j2)) {
                        j1++; j2--;
                        break;
                    }

                    j1--; j2++;
                }

                r[i] = j2 - i + 1;
                if (j2 > R) {
                    R = j2; C = i;
                }

                continue;
            }

            L = C * 2 - R;
            int ii = C *2 - i;      // ii 是 i关于C的镜像点

            if (ii - r[ii] + 1 < L) {
                // 镜像点的最长回文左边界落在L左边，i的最长回文半径就是从ii到L的长度
                r[i] = ii - L + 1;
            } else if (ii - r[ii] + 1 > L) {
                // 镜像点的最长回文左边界落在L右边，i最长回味半径就是ii的最长回文半径
                r[i] = r[ii];
            } else {
                // 镜像点最长回文左边界落在L上, i最长回文半径长度至少就是ii的最长回文半径长度，但是还需要往两边扩，才能知道最长是多长
                int j1 = i - r[ii], j2 = i + r[ii];
                while (true) {
                    if ((j1 < 0) || (j2 > ss.length()-1) || ss.charAt(j1) != ss.charAt(j2)) {
                        j1++; j2--;
                        break;
                    }

                    j1--; j2++;
                }

                r[i] = j2 - i + 1;
                if (j2 > R) {
                    R = j2; C = i;
                }
            }
        }

        int maxR = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < r.length; i++) {
            if (maxR < r[i]) {
                maxR = r[i];
                maxIdx = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = maxIdx - maxR + 1;  i <= maxIdx + maxR -1; ) {
            if (ss.charAt(i) != '#') {
                result.append(ss.charAt(i));
                i += 2;
            } else {
                i++;
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}
