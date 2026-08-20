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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(
        int[] preorder,
        int preStart,
        int preEnd,
        int[] inorder,
        int inStart,
        int inEnd,
        HashMap<Integer, Integer> map
    ) {

        if (preStart > preEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = map.get(rootValue);

        int leftSize = rootIndex - inStart;

        root.left = build(
            preorder,
            preStart + 1,
            preStart + leftSize,
            inorder,
            inStart,
            rootIndex - 1,
            map
        );

        root.right = build(
            preorder,
            preStart + leftSize + 1,
            preEnd,
            inorder,
            rootIndex + 1,
            inEnd,
            map
        );

        return root;
    }
}