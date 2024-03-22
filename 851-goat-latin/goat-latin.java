class Solution {
    public String toGoatLatin(String sentence) {
        sentence.toLowerCase();
        String[] arr = sentence.split(" ");
        String ans = "";
        int index = 1;
        for(int i =0;i<arr.length;i++){
            String curr = arr[i];
            char p = curr.charAt(0);
            if(p=='a'|| p=='e'||p=='i'||p=='o'||p=='u'
            ||p=='A'||p=='E'||p=='I'||p=='O'||p=='U'){
                ans += curr+ "ma";
            }else{
                ans += curr.substring(1) + p + "ma";
            }
            for(int j =0;j<index;j++){
                ans+= 'a';
            }
            index++;
            ans+= " ";

        }
        return ans.substring(0,ans.length()-1);
    }
}