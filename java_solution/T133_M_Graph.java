import java.util.*;

public class T133_M_Graph {
    // 以下为深度优先遍历
    /*

    HashMap<Node, Node> clone = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null){
            return node;
        }

        if (clone.containsKey(node)){
            return clone.get(node);
        }

        Node nowclone = new Node(node.val);
        nowclone.neighbors = new ArrayList<>();

        clone.put(node,nowclone);

        for (Node neighbor : node.neighbors) {
            nowclone.neighbors.add(cloneGraph(neighbor));
        }
        return nowclone;
    }
    */

    // 以下为广度优先遍历
    public Node cloneGraph(Node node) {
        if (node == null){
            return node;
        }

        HashMap<Node, Node> cloned = new HashMap<>();

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        cloned.put(node, new Node(node.val, new ArrayList<>()));

        while (!q.isEmpty()){
            Node cloning = q.remove();

            for (Node neighbor : cloning.neighbors) {
                if (!cloned.containsKey(neighbor)){
                    Node newNode = new Node(neighbor.val, new ArrayList<>());
                    cloned.put(neighbor, newNode);
                    q.add(neighbor);
                }
                cloned.get(cloning).neighbors.add(cloned.get(neighbor));
            }
        }
        return cloned.get(node);
    }
}
