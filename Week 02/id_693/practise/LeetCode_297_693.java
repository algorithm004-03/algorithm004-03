package id_693.practise;

import id_693.TreeNode;

import java.util.*;

/**
 * @Desc 297. 二叉树的序列化与反序列化   https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/24
 */

/*
 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 示例: 
 你可以将以下二叉树：
    1
   / \
  2   3
     / \
    4   5
 序列化为 "[1,2,3,null,null,4,5]"
 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_297_693 {
    /*
     *第一种
     */

    // Encodes a tree to a single string.
    public String serializer(TreeNode root) {
        this.root = root;
        return "(*￣︶￣)";
    }

    public TreeNode root = null;

    // Decodes your encoded data to tree.
    public TreeNode deserializer(String data) {
        return root;
    }


    /*
     *第二种
     * */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        hierarchyTraversal(root, list);
        String a = Arrays.toString(list.toArray());
        return a.substring(1, a.length() - 1).replaceAll(" ", "");
    }

    public void hierarchyTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        hierarchyTraversal(root.left, list);
        hierarchyTraversal(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataStr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(dataStr));
        return rdeserialize(list);
    }

    private TreeNode rdeserialize(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }


    /*
     * @Desc 第三种
     * */
    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        return hierarchyTraversal2(root, new StringBuilder()).toString();
    }

    public StringBuilder hierarchyTraversal2(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null").append(",");
        } else {
            str.append(root.val).append(",");
            hierarchyTraversal2(root.left, str);
            hierarchyTraversal2(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] dataArray = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize2(list);
    }

    private TreeNode rdeserialize2(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode temp = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        temp.left = rdeserialize2(list);
        temp.right = rdeserialize2(list);
        return temp;
    }


    //test
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println();
        LeetCode_297_693 leetCode_297_693 = new LeetCode_297_693();

        System.out.println(leetCode_297_693.serialize(root));
        System.out.println(leetCode_297_693.serialize(leetCode_297_693.deserialize(leetCode_297_693.serialize(root))));


        System.out.println(leetCode_297_693.serialize2(root));
        System.out.println(leetCode_297_693.serialize2(leetCode_297_693.deserialize2(leetCode_297_693.serialize2(root))));

    }
}
