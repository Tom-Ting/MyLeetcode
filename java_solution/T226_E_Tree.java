import org.junit.Test;

public class T226_E_Tree {
    //    public TreeNode invertTree(TreeNode root) {
//        if (root == null){
//            return null;
//        }
//        TreeNode temp = root.left;
//        root.right = root.left;
//        root.left = temp;
//        return null;
//    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;
        return root;
    }

    @Test
    public void Test() {

    }
}
