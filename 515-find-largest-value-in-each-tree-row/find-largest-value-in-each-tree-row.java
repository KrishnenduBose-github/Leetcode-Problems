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
    class Custom{
        TreeNode node;
        int lvl;
        Custom(TreeNode node,int lvl){
            this.node = node;
            this.lvl = lvl;
        }
    }
    ArrayList<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
       /* HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Custom> q = new LinkedList<>();
        if(root == null) return new ArrayList<>();
        q.add(new Custom(root,0));
        while(q.size() > 0){
            Custom curr = q.remove();
            TreeNode node = curr.node;
            int lvl = curr.lvl;
            if(map.containsKey(lvl)) {
                int max = Math.max(node.val,map.get(lvl));
                map.put(lvl,max);
            }else{
                map.put(lvl,node.val);

            }
            if(node.left != null) q.add(new Custom(node.left,lvl+1));
            if(node.right != null) q.add(new Custom(node.right,lvl+1));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer x : map.values()){
            list.add(x);
        }
        return list;*/
        LargeValues(root,0);
        return ans;

    }
    public void LargeValues(TreeNode node,int lvl){
         if(node == null) return;
         if(ans.size() <= lvl) ans.add(node.val);
         else ans.set(lvl,Math.max(node.val,ans.get(lvl)));
         LargeValues(node.left,lvl+1);
         LargeValues(node.right,lvl+1);
    }
}