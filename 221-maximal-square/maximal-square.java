class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int ans = 0;
        for(int i =0;i<r;i++){
            for(int j =0;j<c;j++){
                if(i == 0 || j == 0){
                    if(matrix[i][j] == '1'){
                        dp[i][j] = 1;
                        ans = Math.max(ans,dp[i][j]);
                    }
                }else{
                        if(matrix[i][j] == '1'){
                            dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                            ans = Math.max(ans,dp[i][j]);
                        }
                    } 
            }
        }
        return ans*ans;
    }
}