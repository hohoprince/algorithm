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
    
    int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return getTree(0, nums.length - 1);
    }
    
    public TreeNode getTree(int leftIndex, int rightIndex) {
        
        if (leftIndex > rightIndex) return null;
        
        int parentIndex = (leftIndex + rightIndex) / 2;
        
        TreeNode root = new TreeNode(nums[parentIndex]);
        root.left = getTree(leftIndex, parentIndex - 1);
        root.right = getTree(parentIndex + 1, rightIndex);
        
        return root;
        
    }
    
}
