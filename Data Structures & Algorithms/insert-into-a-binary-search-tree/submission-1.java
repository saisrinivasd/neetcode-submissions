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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        //recursive
        // if(val > root.val) {
        //     root.right = insertIntoBST(root.right, val);
        // } else {
        //     root.left = insertIntoBST(root.left, val);
        // }
        // return root;

        //iterative
        TreeNode cur = root;
        while(true) {
            if(cur.val > val) {
                if(cur.left == null) {
                    cur.left = new TreeNode(val);
                    return root;
                }
                cur = cur.left;
            } else {
                if(cur.right == null) {
                    cur.right = new TreeNode(val);
                    return root;
                }
                cur = cur.right;
            }
        }
    }
}