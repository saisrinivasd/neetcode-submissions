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
    Map<Integer, Integer> inorderIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        for(int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, 
        int[] inorder, int inStart, int inEnd) {
            if(preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            int mid = inorderIndex.get(rootVal);
            int leftSize = mid - inStart;
            root.left = build(preorder, preStart+1, preStart + leftSize, inorder, inStart, mid-1);
            root.right = build(preorder, preStart+leftSize+1, preEnd, inorder, mid+1, inEnd);
            return root;
        }
}
