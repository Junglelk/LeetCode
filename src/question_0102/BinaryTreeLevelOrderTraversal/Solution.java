package question_0102.BinaryTreeLevelOrderTraversal;
import other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int qs = queue.size();
            for (int i = 0; i < qs; i++) {
                TreeNode head = queue.poll();
                temp.add(head.val);
                if (head.left!=null){
                    queue.add(head.left);
                }
                if (head.right!=null){
                    queue.add(head.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
