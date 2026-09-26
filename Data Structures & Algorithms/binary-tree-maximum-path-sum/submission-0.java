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
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int[] maxSum = {Integer.MIN_VALUE};
        maxSumDfs(root, maxSum);
        return maxSum[0];
    }

    private int maxSumDfs(TreeNode root, int[]maxSum) {
        if(root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxSumDfs(root.left, maxSum));
        int rightSum = Math.max(0, maxSumDfs(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
