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
        int hlvl;
        int vlvl;
        Custom(TreeNode node,int hlvl,int vlvl){
            this.node = node;
            this.hlvl = hlvl;
            this.vlvl = vlvl;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<Custom> q = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Custom(root,0,0));
        while(q.size() > 0){
            Custom curr = q.remove();
            TreeNode node = curr.node;
            int x = curr.hlvl;
            int y = curr.vlvl;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());

            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.val);

            if(node.left != null) q.add(new Custom(node.left,x-1,y+1));
            if(node.right != null) q.add(new Custom(node.right,x+1,y+1));


        }
        List<List<Integer>> answer = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys : map.values()){
            answer.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(nodes.size() > 0)
                answer.get(answer.size() - 1).add(nodes.remove());
            }
        }
      return answer;

    }
}