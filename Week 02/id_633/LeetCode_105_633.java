package lesson8;

import java.util.HashMap;

public class LeetCode_105_633 {

        int preIndex = 0;
        int[] preOrder;
        int[] inOrder;
        HashMap<Integer, Integer> build_map = new HashMap<Integer, Integer>();

        public TreeNode build(int inLeft, int inRight) {
            if (inLeft == inRight)
                return null;

            int rootValue = preOrder[preIndex];
            TreeNode root = new TreeNode(rootValue);

            int index = build_map.get(rootValue);

            preIndex++;
            root.left = build(inLeft, index);
            root.right = build(index + 1, inRight);
            return root;
        }

        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            this.preOrder = preOrder;
            this.inOrder = inOrder;

            int build = 0;
            for (Integer val : inOrder)
                build_map.put(val, build++);
            return build(0, inOrder.length);
        }

}

