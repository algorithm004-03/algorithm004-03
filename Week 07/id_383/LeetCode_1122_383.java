public class LeetCode_1122_383 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter = new int[1001];
        int len = arr1.length;
        for(int i = 0; i < len; i++) {
            counter[arr1[i]]++;
        }
        int[] arr3 = new int[len];
        int index = 0;
        for(int i = 0; i < arr2.length; i++) {
            while(counter[arr2[i]] > 0) {
                arr3[index++] = arr2[i];
                counter[arr2[i]]--;
            }
        }
        for(int i = 0; i < 1001; i++) {
            while(counter[i] > 0) {
                arr3[index++] = i;
                counter[i]--;
            }
        }
        return arr3;
    }
}
