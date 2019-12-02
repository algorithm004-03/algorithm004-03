class Solution{
//  n叉树后续遍历，这个可以利用二叉树的遍历的思路来解这个题。
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList();
        sortt(list, root);
        return list;
    }
    public void sortt(List list, Node root) {
        if(root != null ) {
            if(root.children != null) {
                for(int i = 0; i < root.children.size(); i++){
                    sortt(list,root.children.get(i));
                }
            }
            list.add(root.val);
        }
    }
//  n叉树前序续遍历，如上
//  n叉树不不存在中序遍历的。
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        sortt1(list, root);
        return list;
    }
    public void sortt1(List list, Node root) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for(int i = 0; i < root.children.size(); i++)
                sortt1(list, root.children.get(i));
            }
        }
    }
}