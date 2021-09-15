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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        q2.add(root);
        
        while (!q2.isEmpty()) {
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }    
            
            List<Integer> li = new ArrayList<>();
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                li.add(node.val);
                
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            result.add(li);
        }
        
        return result;
    }
}
