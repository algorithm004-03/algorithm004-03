package leetcode.week7;

/**
 * @author eason.feng at 2019/12/1/0001 17:40
 **/
public class LeetCode_QuickSort {

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] a, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }

}
