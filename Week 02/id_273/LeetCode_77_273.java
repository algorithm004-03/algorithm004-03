//77. 组合

//解法1：递归
//时间复杂度O(n^k)
//空间复杂度O(k)
class Solution {
	public  List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<Integer>(), 1, 4, 2);
        return result;
    }

    public  void combine(List<List<Integer>> result, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(result, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }	
}