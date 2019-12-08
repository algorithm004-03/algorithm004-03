package org.geektime.weak01;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class LeetCode_189_178 {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6};
        LeetCode_189_178 instance = new LeetCode_189_178();
        instance.rotate3(nums,3);

    }

    /**
     * 暴力破解
     */
    public void rotate1(int[] nums, int k) {
        int temp,previous =0;
        for (int i = 0;i<k;i++){
            previous = nums[nums.length-1];
            for (int j = 0;j < nums.length ;j++){
                    temp  = nums[j];
                    nums[j] = previous;
                    previous = temp;
                }
            }
        }

    /**
     * 开辟新的空间存放数据
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，
     *      也就是原本数组里下标为 i 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
     *      然后把新的数组拷贝到原数组中。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i= 0;i < nums.length;i++){
            //类似于大数据里hash分片的思想
            a[(i+k) % nums.length] = nums[i];
        }
        for (int i = 0;i < nums.length;i++){
            nums[i]=a[i];
        }
    }

    /**
     * 使用环状替换算法
     * 如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。
     *   因此，我们需要把被替换的数字保存在变量 temp 里面。
     *   然后，我们将被替换数字（temp）放到它正确的位置，
     *   并继续这个过程 n 次， n 是数组的长度。这是因为我们需要将数组里所有的元素都移动。
     *   但是，这种方法可能会有个问题，如果 n%k==0，其中 k=k%n （
     *      因为如果 k 大于 n ，移动 k 次实际上相当于移动 k%n 次）。
     *      这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。
     *      此时，我们应该从下一个数字开始再重复相同的过程。
     *
     * 现在，我们看看上面方法的证明。假设，数组里我们有 n个元素并且 k 是要求移动的次数。更进一步，假设 n%k=0 。
     *  第一轮中，所有移动数字的下标 i 满足 i%k==0 。这是因为我们每跳 k 步，
     *  我们只会到达相距为 k 个位置下标的数。每一轮，我们都会移动 n/k 个元素
     *  下一轮中，我们会移动满足 i%k==1 的位置的数。这样的轮次会一直持续到我们再次遇到
     *      i%k==0的地方为止，此时 i=k 。此时在正确位置上的数字共有 k * (n/k) = n个,因此所有数字都在正确位置上
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void rotate3(int[] nums, int k) {

        //类似与 今天过多少天是周几,周期性循环
        k = k % nums.length;
        int count = 0;
        for (int start = 0;count < nums.length;start++){
            int current  = start;
            //prev存储当前指针所指向的对象
            int prev = nums[start];
            do{
                //next 表示当前位置的元素该移动至哪个位置
                int next   = (current + k) % nums.length;
                //temp 接收目的地位置的原住民信息
                int temp = nums[next];
                //prev  移动至 ->  目的地位置(nums[next])
                nums[next]  = prev;
                //prev  移动至目的地后,接受目的地原住户的信息
                prev = temp;
                //当前指针位置为  next
                current = next;
                //count计算器 +1
                count++;
            }while (start != current);//让一次轮循完成
        }

    }

    /**
     * 使用反转算法
     *
     * 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
     *
     * 假设 n=7   且   k=3。
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 个人理解:
     *  先做出原数组的镜像,镜像 与 原数组 组成环,k=为镜像中需要遍历的长度,镜像索引 与 原数组索引位置相同，依次放入 mirror_Array[--(k-1)],--(k-1) >=0
     */
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k-1);
        reverse(nums,0,nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp  = nums[start];
            nums[start]  = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 别人家的暴力破解法
     * @param nums
     * @param k
     */
    public void rotate5(int[] nums, int k) {
        if (nums.length <= 1) return;
        k = k % nums.length;
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, temp.length);

    }

    /**
     * 反转法优化
     * @param nums
     * @param k
     */
    public void rotate6(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return;
    }
    k = k % nums.length;
        if (k == 0) {
        return;
    }
    swap(nums, 0, nums.length - k - 1);
    swap(nums, nums.length - k, nums.length - 1);
    swap(nums, 0, nums.length - 1);

}

    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }



}
