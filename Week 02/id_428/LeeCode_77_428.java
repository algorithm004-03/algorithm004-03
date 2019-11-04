import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        comb(1, n, k, new ArrayList<Integer>(), combs);
        return combs;
    }

    private static void comb(int start, int end, int k, ArrayList<Integer> comb, List<List<Integer>> combs) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= (end - k + 1); i++) {
            comb.add(i);
            comb(i + 1, end, k-1, comb, combs);
            comb.remove(comb.size() - 1);
        }
    }
}