package study;

import java.util.ArrayList;
import java.util.List;


//1.定义节点
class Node {
	int val;
	Node left;
	Node right;

	Node(int x) {
		this.val = x;
	}
}

public class LeeCode_144_108 {
	// 递归
	public static List<Integer> preorderTraversal(Node root) {
		ArrayList<Integer> list = new ArrayList<>();
		// 递归终结者
		if (root == null)
			return list;
		// 递归实现-处理当前实现
		System.out.print(root.val + " ");
		list.add(root.val);
		// 下探下一层
		list.addAll(preorderTraversal(root.left));
		list.addAll(preorderTraversal(root.right));
		return list;
	}
	
	//建立二叉树
    public static Node creatTree(int[] data, int i) {
        if (i >= data.length || data[i] == -1)
            return null;
        Node temp = new Node(data[i]);
        temp.left = creatTree(data, i * 2 + 1);
        temp.right = creatTree(data, i * 2 + 2);
        return temp;
    }
	
    public static void main(String[] args) {
        int[] array = { 1,4,2,3 };
        Node tree = creatTree(array, 0);
        preorderTraversal(tree);
    }
}
