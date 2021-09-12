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
    
    boolean isBalanced = true;
    
    private int getHeight(TreeNode node) {
        
        if (node == null) return 1;
        
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        
        getHeight(root);
        
        return isBalanced;
        
    }
    
}
