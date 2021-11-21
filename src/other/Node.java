package other;

import java.util.List;

/**
 * @author Jungle
 * @since 2021/11/21 10:26
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}