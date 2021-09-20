/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode result;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        search(root, p, q);
        
        return result;
        
    }
    
    private boolean search(TreeNode node, TreeNode p, TreeNode q) {
        
        if (node == null) return false;
        
        int left = search(node.left, p, q) ? 1 : 0;
        int right = search(node.right, p, q) ? 1 : 0;
        int current = (node == p || node == q) ? 1 : 0;
        
        if (current + left + right >= 2) result = node;
        
        return (current + left + right > 0);
        
    }
    
}
