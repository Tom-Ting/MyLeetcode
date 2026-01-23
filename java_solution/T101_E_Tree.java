public class T101_E_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }else if (root.left == null && root.right == null){
            return true;
        }else if (root.left == null || root.right == null){
            return false;
        }else {
            return SymmetricTrees(root.left, root.right);
        }
    }

    public boolean SymmetricTrees(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if (left == null || right == null){
            return false;
        }else if (left.val != right.val){
            return false;
        }else {
            return SymmetricTrees(left.left, right.right) && SymmetricTrees(left.right, right.left);
        }
    }
}
