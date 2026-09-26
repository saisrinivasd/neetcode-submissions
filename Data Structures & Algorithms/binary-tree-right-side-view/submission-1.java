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
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> rightView = new ArrayList<>();
    //     if(root == null) {
    //         return rightView;
    //     }
    //     Deque<TreeNode> queue = new ArrayDeque<>();
    //     queue.offer(root);
    //     while(!queue.isEmpty()) {
    //         TreeNode tmp;
    //         int levelSize = queue.size();
    //         for(int i = 0; i < levelSize; i++) {
    //             tmp = queue.poll();
    //             if(tmp.left != null) {
    //                 queue.offer(tmp.left);
    //             }
    //             if(tmp.right != null) {
    //                 queue.offer(tmp.right);
    //             }
    //             if(i == levelSize-1) {
    //                 rightView.add(tmp.val);
    //             }
    //         }
    //     }
    //     return rightView;
    // }
    List<Integer> rightView = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return rightView;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        if(depth == rightView.size()) {
            rightView.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
