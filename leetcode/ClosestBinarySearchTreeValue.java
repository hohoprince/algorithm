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
    
    List<Integer> arr = new ArrayList<>();
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        arr.add(node.val);
        inorder(node.right);
    }
    
    public int closestValue(TreeNode root, double target) {
        inorder(root);
        
        System.out.println(arr);
        
        int minNodeValue = Collections.min(arr, (a, b) -> 
                                           Double.compare(Math.abs(a - target), Math.abs(b - target)));
        
        return minNodeValue;
    }
}
