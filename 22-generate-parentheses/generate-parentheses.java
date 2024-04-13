class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0,0,ans,"",n);
        return ans;
    }
    public void generate(int left,int right,List<String> res,String s, int n){
        if(s.length() == n*2){
            res.add(s);
            return;
        }

        if(left < n) {
            generate(left+1,right,res,s + "(",n);
        }
        if(left > right) generate(left,right+1,res,s + ")",n);


    }
}