import java.util.HashMap;
import java.util.Map;

public class T105_M_Tree {
    private Map<Integer, Integer> InorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0){
            return null;
        }
        // 树中每个节点的值都是唯一的
        // 节点值 -> 中序遍历数组位置
        InorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            InorderIndexMap.put(inorder[i], i);
        }

        TreeNode root = buildNode(preorder, inorder, 0, n-1, 0, n-1);
        return root;
    }

    public TreeNode buildNode(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight){
            return null;
        }
        /*
        p数组中，根节点索引为pLeft
        i数组中，根节点索引为InorderIndexMap.get(preorder[pLeft])
        i数组中，左子树位置为[iLeft, InorderIndexMap.get(preorder[pLeft])-1]。左子树长度为InorderIndexMap.get(preorder[pLeft]) - iLeft
        i数组中，右子树位置为[InorderIndexMap.get(preorder[pLeft])+1, iRight].右子树的长度为iRight - InorderIndexMap.get(preorder[pLeft])
        p数组中,左子树的位置为[pLeft+1， pLeft+leftLength]
        p数组中,右子树的位置为[pRight-rightLength+1， pRight]
         */
        int rootInorderIndex = InorderIndexMap.get(preorder[pLeft]);
        int leftLength = rootInorderIndex - iLeft;
        int rightLength = iRight - rootInorderIndex;

        TreeNode root = new TreeNode(preorder[pLeft]);

        root.left = buildNode(preorder,inorder,pLeft+1,pLeft+leftLength,iLeft,rootInorderIndex-1);
        root.right = buildNode(preorder,inorder,pRight-rightLength+1,pRight,rootInorderIndex+1,iRight);

        return root;
    }
}
