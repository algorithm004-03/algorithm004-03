package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc
 * @Date 2019/10/28
 */
public class LeetCode_169_693 {
    //Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    //分治
    public int majorityElement2(int[] nums) {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_169_693().majorityElement2(new int[]{3,2,3}) == 3);
        System.out.println(new LeetCode_169_693().majorityElement2(new int[]{2,2,1,1,1,2,2}) == 2);
    }
}
