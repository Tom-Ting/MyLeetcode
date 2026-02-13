public class T543_E_Tree {
    int maxRoad = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 0;
        }
        depth(root);
        return maxRoad;
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        maxRoad = Math.max(maxRoad, L+R);
        return Math.max(R, L)+1;
    }
}
/*
    二叉树的特点：不能横插一脚。所以他们找最短通路就是找一个共同的父母节点。算一下他们三个的深度，H1+H2-2H0
    现在问题是，怎么找到公共的父节点。

    调转思维，不要去遍历路径，而是抓住节点。每个节点都有成为公共父节点的潜力。

    下面是，计算其左右子树的深度和。看看怎么算。

    困难之处在于，如何保存每个节点的深度信息

    计算树深时，顺便计算节点数。反正左右子树都要计算的。
 */