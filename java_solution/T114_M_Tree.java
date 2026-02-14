public class T114_M_Tree {
    TreeNode point = new TreeNode();
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        point.right = root;
        point = point.right;
        flatten(root.left);
        flatten(root.right);
    }
}
