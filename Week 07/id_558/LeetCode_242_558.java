package Week06;


/**
 * @see <a href="242">https://leetcode-cn.com/problems/valid-anagram/</a>
 * 有效的字母异位词
 */
public class LeetCode_242_558 {
//    public static void quickSort(char[] arr, int begin, int end) {
//        if (end <= begin) return;
//        int pivot = partition(arr, begin, end);
//        quickSort(arr, begin, pivot - 1);
//        quickSort(arr, pivot + 1, end);
//
//    }
//
//    private static int partition(char[] arr, int begin, int end) {
//        int counter = begin;
//        for (int i = begin; i < end; i++) {
//            if (arr[i] < arr[end - 1]) {
//                char temp = arr[i];
//                arr[i] = arr[counter];
//                arr[counter] = temp;
//                counter++;
//            }
//        }
//        char temp = arr[counter];
//        arr[counter] = arr[end - 1];
//        arr[end - 1] = temp;
//        return counter;
//    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int arr[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] += 1;

        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)] -= 1;
            if (arr[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        String s1 = "eat";
//        String s2 = "tea";
//        char[] c1 = s1.toCharArray();
//        // char[] c2 = s2.toCharArray();
//        quickSort(c1, 0, c1.length);
//        // quickSort(c2, 0, c2.length);
//        System.out.println(String.valueOf(c1));
//    }


}
