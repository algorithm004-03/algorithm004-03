import java.util.Arrays;

/**
 * 位1的个数
 */
public class QuickSort {
  public static void quickSort(int[] array, int begin, int end) {
    // terminator
    if (end <= begin) {
      return;
    }

    int pivot = _partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
  }

  private static int _partition(int[] array, int begin, int end) {
    int pivot = end;
    int pivotIndex = begin;
    for (int i = begin; i < end; i++) {
      if (array[i] < array[pivot]) {
        _swap(array, i, pivotIndex);
        pivotIndex++;
      }
    }

    _swap(array, pivot, pivotIndex);
    return pivotIndex;
  }

  private static void _swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  public static void main(String[] args) {
    int[] array = new int[]{5, 3, 8, 1, 6, 80, 99, -2};
    QuickSort.quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }
}
