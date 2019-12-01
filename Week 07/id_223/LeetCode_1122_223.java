class Solution {
    //计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter = new int[1001];
        for (int n : arr1) {
            counter[n]++;
        }
        int i = 0;
        for (int n : arr2) {
            while (counter[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < counter.length; n++) {
            while (counter[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}