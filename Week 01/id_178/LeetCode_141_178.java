package org.geektime.weak01;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fukan on 2019/10/23.
 */
public class LeetCode_141_178 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen =  new HashSet<>();
        while(head != null){
            if(nodesSeen.contains(head)){
                return true;
            }else {
                nodesSeen.add(head);
            }
            head = head.next;
        }


        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}





