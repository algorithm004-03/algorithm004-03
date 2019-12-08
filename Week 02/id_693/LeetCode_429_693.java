package id_693;

import java.util.*;

/**
 * @Author 李雷（KyLin）
 * @Desc 429. N叉树的层序遍历   https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @Date 2019/10/22
 */
public class LeetCode_429_693 {
    //迭代法 + 队列的方式进行实现，
    // 采用队列来实现数据隔离，然后每次获取上一次保存的队列数量，相当于一次添加 内部在循环
    //第一个for：负责把当前节点的数据都添加到list集合
    //第二个for：负责把所有当前节点的子节点都添加到队列(嵌套在第一个for循环内)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                res.add(Objects.requireNonNull(temp).val);
                for (Node node : temp.children) {
                    queue.offer(node);
                }
            }
            list.add(res);
        }
        return list;
    }

    //代码优化
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                res.add(Objects.requireNonNull(queue.peek()).val);
                queue.addAll(Objects.requireNonNull(queue.poll()).children);
            }
            list.add(res);
        }
        return list;
    }


    public static void main(String[] args) {
        //test que
        Node l = new Node();
        l.val = 10;
        l.children = Collections.EMPTY_LIST;
        Node m = new Node();
        m.val = 1203;
        m.children = Collections.EMPTY_LIST;
        List<Node> d = new ArrayList<>();
        d.add(l);
        d.add(m);
        Node root = new Node(3,d);
        System.out.println(new LeetCode_429_693().levelOrder(root));
        System.out.println(new LeetCode_429_693().levelOrder2(root));
    }
}
