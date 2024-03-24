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
    class custom{
        int ht;
        boolean flag;
       
    }
    public boolean isBalanced(TreeNode root) {
        custom ans = check(root);
        return ans.flag;
    }
    public custom check(TreeNode root){
        if(root == null){
            custom p = new custom();
            p.ht = 0;
            p.flag = true;
            return p;
        }

        custom left = check(root.left);
        custom right = check(root.right);

        custom curr = new custom();
        curr.ht = Math.max(left.ht,right.ht) + 1;
        if(Math.abs(left.ht - right.ht) > 1 || left.flag == false || right.flag == false) curr.flag = false;
        else curr.flag = true;

        return curr;
    }
}