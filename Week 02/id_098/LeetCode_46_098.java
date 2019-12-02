// 不允许重复全排列 leetCode 46
//思路：依次固定每个位置上的数字  不完全是回溯算法  目前最优解 DFS
class Solution {

    private Stack<Integer> stack = new Stack<Integer>();
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {

        arraySort(nums, nums.length, 0);

        return res;
    }

    private void arraySort(int[] array, int length, int cur) {

        if(cur == length) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }

        for(int i=0;i<array.length;i++) {
            if(!stack.contains(array[i])) {
                stack.add(array[i]);
                arraySort(array, length, cur+1);
                stack.pop();
            }

        }
    }

}

// 可重复全排列 leetCode 47
// 思路：if(!stack.contains(array[i])) { } 部分替换结果成去重操作，时间不够未来得及细想
