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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        TreeNode left, right;
        if(p.val <= q.val) {
            left = p;
            right = q;
        } else {
            right = p;
            left = q;
        }
        if(root.val > right.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(root.val < left.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
