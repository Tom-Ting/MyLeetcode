import java.util.*;

public class T114_M_Tree {
    public void flatten(TreeNode root) {
        TreeNode point = root;
        while (point != null){
            if (point.left != null){
                TreeNode RightestOfLeft = point.left;
                while (RightestOfLeft.right != null){
                    RightestOfLeft = RightestOfLeft.right;
                }
                RightestOfLeft.right = point.right;
                point.right = point.left;
                point.left = null;
            }
            point = point.right;
        }
    }
}

/**
 * ===== 原思路
 *  问题在于，point.right = root改变了point的右子节点，而flatten(root.right)访问了新的右子节点（而不是原思路中的root节点的右节点）
 *     TreeNode point = new TreeNode();
 *     public void flatten(TreeNode root) {
 *         if (root == null){
 *             return;
 *         }
 *         point.right = root;
 *         point = point.right;
 *         flatten(root.left);
 *         flatten(root.right);
 *     }
 * <p>
 *
 *
 * ===== 正确思路1：使用前序遍历+额外空间
 *     List<TreeNode> list;
 *     public void flatten(TreeNode root) {
 *         if (root == null){
 *             return;
 *         }
 *         list = new ArrayList<>();
 *         dfs(root);
 *         for (int i = 1; i < list.size(); i++) {
 *             list.get(i-1).right = list.get(i);
 *             list.get(i-1).left = null;
 *         }
 *         list.get(list.size()-1).left = null;
 *         list.get(list.size()-1).right = null;
 *     }
 *     // 先序遍历
 *     public void dfs(TreeNode root){
 *         if (root == null){
 *             return;
 *         }
 *         list.add(root);
 *         dfs(root.left);
 *         dfs(root.right);
 *     }
 *
 * ===== 正确思路2：使用栈模拟递归，在遍历的同时重新链接链表
 *     public void flatten(TreeNode root) {
 *         if (root == null){
 *             return;
 *         }
 *         Stack<TreeNode> stack = new Stack<>();
 *         stack.push(root);
 *         TreeNode prePoint = null;
 *         while (!stack.isEmpty()){
 *             TreeNode point = stack.pop();
 *             if (prePoint != null){
 *                 prePoint.left = null;
 *                 prePoint.right = point;
 *             }
 *
 *             if (point.right != null){
 *                 stack.push(point.right);
 *             }
 *             if (point.left != null){
 *                 stack.push(point.left);
 *             }
 *             prePoint = point;
 *         }
 *     }
 *
 * ===== 错误思路1：使用队列模拟递归，在遍历的同时重新链接链表
 * 队列只能实现层序遍历，不能实现中序遍历
 * 相比于栈，队列是局部先进先出，不是整体先进先出。所以队列和栈不能简单转换。
 *
 *
 * ===== 正确思路3：模拟法
 *  发现某个节点存在左子节点后：
 *     - 将该节点的右节点全部转移到左子节点的最右子节点
 *     - 将该节点的左子节点转移到右子节点上
 *         public void flatten(TreeNode root) {
 *         TreeNode point = root;
 *         while (point != null){
 *             if (point.left != null){
 *                 TreeNode RightestOfLeft = point.left;
 *                 while (RightestOfLeft.right != null){
 *                     RightestOfLeft = RightestOfLeft.right;
 *                 }
 *                 RightestOfLeft.right = point.right;
 *                 point.right = point.left;
 *                 point.left = null;
 *             }
 *             point = point.right;
 *         }
 *     }
 */