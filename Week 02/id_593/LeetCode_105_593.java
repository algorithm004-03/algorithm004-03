
/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * <p>   3
 * <p>  / \
 * <p> 9  20
 * <p>   /  \
 * <p>  15  7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 优秀解答：
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/qian-xu-zhong-xu-bian-li-gou-zao-er-cha-shu-mo-ni-/
 *
 * @author jaryoung
 */
public class LeetCode_105_593 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preOrderIndex, int[] inorder, int inorderLeft, int inorderRight) {
        // terminator
        if (inorderLeft >= inorderRight) {
            return null;
        }
        // process
        TreeNode root = new TreeNode(preorder[preOrderIndex]);
        int inorderIndex = 0;
        while (inorder[inorderIndex] != root.val) {
            inorderIndex++;
        }
        // drill down
        // 根据中序遍历，能得到左子树的结点数，inorderIndex - inorderLeft。从而可以计算右子树的根的位置等于，
        // 前序遍历的左结点的位置 + （中序遍历的左子树的长度）+ 1
        root.left = buildTree(preorder, preOrderIndex + 1,
                inorder, inorderLeft, inorderIndex);
        root.right = buildTree(preorder, preOrderIndex + inorderIndex - inorderLeft + 1,
                inorder, inorderIndex + 1, inorderRight);
        return root;
    }
}