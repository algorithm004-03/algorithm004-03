import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数字的全排列
 * “回溯搜索”算法即“深度优先遍历 + 状态重置 + 剪枝”
 * @author L
 *
 */
public class LeetCode_46_138 {
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for(int num:nums) {//数组转为list
        	list.add(num);
        }
        permuteHelper(list,size,0);
		
		return res;
    }
	/**
	 * 
	 * @param list 元素集合
	 * @param size 原数组的长度
	 * @param start 第一个整数的索引位置
	 */
	private void permuteHelper(List<Integer> list, int size, int start) {
		if(size == start) {
			res.add(new ArrayList<Integer>(list));
		}
		for(int i=start;i<size;i++) {
			Collections.swap(list, start,i);//在排列中放置元素
			permuteHelper(list, size, start+1);//继续递归生成第i个整数开始的所有排列
			Collections.swap(list, start, i);//回溯 还原状态
		}
	}
}
