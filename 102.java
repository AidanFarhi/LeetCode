import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * 
 * Given the root of a binary tree, 
 * return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subResult = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode next = queue.poll();
                if (next != null) {
                    if (next.left != null) queue.add(next.left);
                    if (next.right != null) queue.add(next.right);
                    subResult.add(next.val);
                }
            }
            result.add(subResult);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}