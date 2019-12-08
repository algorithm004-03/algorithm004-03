package com.company.leetcode.editor.cn;//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//
// 示例:
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
// Related Topics 树 设计



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.lang.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode_297 {
    int val;
    TreeNode_297 left;
    TreeNode_297 right;
    TreeNode_297(int x) { val = x; }
}
class Codec_297 {

    // Encodes a tree to a single string.

    public String serialize(TreeNode_297 root) {
        return helperSerialize(root,"");
    }

    private String helperSerialize(TreeNode_297 root, String s) {
        if (root == null) {
            s += "null,";
            return s;
        }
        s += helperSerialize(root.left,s);
        s += helperSerialize(root.right,s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode_297 deserialize(String data) {
        String[] res = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(res));
        return helperDeserialize(list);
    }

    private TreeNode_297 helperDeserialize(List<String> list) {

        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode_297 root = new TreeNode_297(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = helperDeserialize(list);
        root.right = helperDeserialize(list);
        return root;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
