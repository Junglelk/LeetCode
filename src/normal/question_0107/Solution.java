package normal.question_0107;
import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Stack<Integer> temp = new Stack<>();
            int qs = queue.size();
            for (int i = 0; i < qs; i++) {
                TreeNode head = queue.poll();
                temp.push(head.val);
                if (head.left!=null){
                    queue.add(head.left);
                }
                if (head.right!=null){
                    queue.add(head.right);
                }
            }
            list.add(temp);
        }
        Collections.reverse(list);
        return list;
    }
}
