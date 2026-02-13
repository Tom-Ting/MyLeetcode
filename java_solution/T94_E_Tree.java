import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T94_E_Tree {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
//    @Test
//    public void Test(){
//        System.out.println(inorderTraversal);
//    }

// 所谓访问，就是把节点加入到数组
