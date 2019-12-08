/**
 * @author gning (id=698)
 */

 public class LeetCode_1122_698 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tmp = new int[1001];
        int[] result = new int[arr1.length];

        for(int i=0; i<arr1.length; i++) {
            tmp[arr1[i]] ++;
        }
        
        int cur = 0;
        for(int i=0; i<arr2.length; i++) {
            while(tmp[arr2[i]] > 0) {
                result[cur++] = arr2[i];
                tmp[arr2[i]] --;
            }
        }

        for(int i=0; i < tmp.length; i++) {
            while(tmp[i] > 0) {
                result[cur++] = i;
                tmp[i]--;
            }
        }

        return result;
    }
 }