/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int count = 0;
    
    public int goodNodes(TreeNode root) {
        
        dfs(root, Integer.MIN_VALUE);
        
        return count;
    }
    
    private void dfs(TreeNode node, int value) {
        
        if (node == null) return;
        
        if (value <= node.val) count++;
        
        dfs(node.left, Math.max(node.val, value));
        dfs(node.right, Math.max(node.val, value));
        
    }
}
