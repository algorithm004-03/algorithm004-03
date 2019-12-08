//思路： 将两个小组排序：优先满足胃口小的小朋友，如果一个饼干不能不满足最小朋友胃口的需求，
//      将饼干尺寸数组的下标右移，直到能够满足小朋友的需求。计算到的小朋友胃口的人数即为所求。
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
    if (g == null || s == null) return 0;
    Arrays.sort(g);
    Arrays.sort(s);
    int gi = 0, si = 0;
    while (gi < g.length && si < s.length) {
        if (g[gi] <= s[si]) {
                gi++;
            }
        si++;
        }
    return gi;
    }
}