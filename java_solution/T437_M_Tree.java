import java.util.*;

public class T437_M_Tree {
    Map<TreeNode, Set<Integer>> node2Set = new HashMap<>();
    int ans;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        ans = 0;
        SumMapGen(root, targetSum);
        return ans;
    }

    public void SumMapGen(TreeNode root, int targetSum){
        Set<Integer> pathSum = new HashSet<>();
        if (root.val == targetSum){
            ans++;
        }
        pathSum.add(root.val);
        if (root.left != null){
            if (!node2Set.containsKey(root.left)){
                SumMapGen(root.left, targetSum);
            }
            Set<Integer> leftSum = node2Set.get(root.left);
            for (Integer i : leftSum) {
                if (i+root.val == targetSum){
                    ans++;
                }
                pathSum.add(i+root.val);
            }
        }
        if (root.right != null){
            if (!node2Set.containsKey(root.right)){
                SumMapGen(root.right, targetSum);
            }
            Set<Integer> rightSum = node2Set.get(root.right);
            for (Integer i : rightSum) {
                if (i+root.val == targetSum){
                    ans++;
                }
                pathSum.add(i+root.val);
            }
        }
        node2Set.put(root, pathSum);
    }
}