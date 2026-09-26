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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left, max);
        int rightHeight = height(root.right, max);
        max[0] = Math.max(leftHeight + rightHeight, max[0]);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
