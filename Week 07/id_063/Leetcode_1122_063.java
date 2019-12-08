/*

计数排序实现

 */


import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int cnt[] = new int[1001];
        int[] ans = new int[arr1.length];

        for (int val : arr2) cnt[val]--;

        int j = arr1.length - 1;
        int sortCnt = 0;
        for (int i = arr1.length - 1; i >= 0; i--) {
            cnt[arr1[i]] = (cnt[arr1[i]] == 0) ? 0 : (cnt[arr1[i]] == -1) ? 1 : cnt[arr1[i]] + 1;
            if (cnt[arr1[i]] == 0) {
                ans[j--] = arr1[i];
                sortCnt++;
            }
        }

        j = 0;
        for (int value : arr2) {
            if (cnt[value] > 0) {
                while (cnt[value] > 0) {
                    ans[j++] = value;
                    cnt[value]--;
                }
            }
        }

        if (sortCnt > 0) {
            Arrays.sort(ans, ans.length - sortCnt, ans.length);
        }

        return ans;
    }
}