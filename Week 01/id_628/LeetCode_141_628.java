import java.util.HashSet;
import java.util.Set;

import com.leetCode.exercise.struct.ListNode;

//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LeetCode_141_628 {
    public boolean hasCycle(ListNode head) {
    	hasCycle1(head);
    }
    /**
	 * 【思路】快慢指针。
	 *         利用快指针与慢指针同步遍历链表，当有环情况下两者会相遇的特性解题 
	 *         
	 *     先使用快慢指针相遇，识别链环，然后引入参考变量，零点指针计算环的入口节点
	 * 		  快慢指针相遇时
	 *         慢指针走过： p=a+x+n*(x+y)
	 *         快指针走过：2p=a+x+m*(x+y)
	 *       两式合并可得：
	 *         a=(m-2n)(x+y)-x
	 *         a=(m-2n-1)(x+y)+y
	 *         由于x+y是环的长度，为定值。
	 *         也就是慢指针再走a步的话，相当于走了m-2n-1圈以及y步，此时慢指针将回到A点
	 *       故而为保障慢指针走的步数是a步，
	 *       所以引入参考指针-零点指针，使其从零点开始与慢指针从B点开始同时遍历链表，每次走一个节点，
	 *       慢指针走a步后到达A点，零点指针走a步也到达A点
	 *       两个指针将同时走到A点，并在A点相遇,此时零点指针指向节点即为环入口点。     
	 *         
	 *    
	 * 【时间复杂度】O(n+k) 
	 * 【空间复杂度】O(1)
	 * @param head	原始链表头结点
	 * @return <boolean> true-存在环 false-不存在环
	 */
	public static boolean hasCycle1(ListNode head) {
		if (null == head || head.next == null)
			return false;
		ListNode fastNode = head.next.next;// 快指针
		ListNode slowNode = head.next;// 慢指针
		while (fastNode != slowNode) {
			if (fastNode == null || null == fastNode.next)
				return false;
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return true;
	}
	
	/**
	 * 【思路】缓存记录法。
	 *      遍历一遍链表，每项均添加入缓存set中，判断是否遍历过此节点确定是否有环
	 * 【时间复杂度】O(n) 
	 * 【空间复杂度】O(n)
	 * @param head 原始链表头结点
	 * @return <boolean> true-存在环 false-不存在环
	 */
	public static boolean hasCycle2(ListNode head) {
		Set<ListNode> cacheSet = new HashSet<ListNode>();
		while (!cacheSet.contains(head)) {
			if (head == null)
				return false;
			cacheSet.add(head);
			head = head.next;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
