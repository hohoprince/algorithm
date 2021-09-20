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
    
    Map<TreeNode, TreeNode> map;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        
        dfs(root, null);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(null);
        q.add(target);
        
        Set<TreeNode> seen = new HashSet<>();
        seen.add(null);
        seen.add(target);
        
        int d = 0;
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                if (d == k) {
                    List<Integer> answer = new ArrayList<>();
                    for (TreeNode n : q) {
                        answer.add(n.val);
                    }
                    return answer;
                }
                q.offer(null);
                d++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    q.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    q.offer(node.right);
                }
                TreeNode par = map.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    q.offer(par);
                }
            }
        }
        
        return new ArrayList<Integer>();
        
    }
    
    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            map.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
