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
    class DiaPair{
        int ht;
        int dia;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        DiaPair ans = dia(root);
        return ans.dia;
    }
    public DiaPair dia(TreeNode root){
        if(root== null) {
            DiaPair a = new DiaPair();
            a.ht = -1;
            a.dia = 0;
            return a; 
        }

        DiaPair left = dia(root.left);
        DiaPair right = dia(root.right);

        DiaPair main = new DiaPair();
        main.ht = Math.max(left.ht,right.ht) +1;
        main.dia = Math.max(left.ht+right.ht+2,Math.max(left.dia,right.dia));

        return main;
    }
}