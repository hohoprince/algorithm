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
    
    private void inorder(TreeNode node, List<Integer> li) {
        
        if (node == null) return;
        
        inorder(node.left, li);
        li.add(node.val);
        inorder(node.right, li);
        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> li = new ArrayList<>();
        
        inorder(root, li);
        
        return li;
        
    }
}
