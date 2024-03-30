class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] mat = new int[n][n];
        for(int i =0 ;i<n;i++){
            for(int j =0;j<n;j++){
                mat[i][j] = 1;
            }
        }
        for(int[] mine : mines){
            int row = mine[0] , col = mine[1];
            mat[row][col] = 0;
        }
        int[][] L = new int[n][n];
        int[][] R = new int[n][n];
        int[][] U = new int[n][n];
        int[][] D = new int[n][n];
        int count = 0;
        for(int i =0;i<n;i++){
              count = 0;
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1){
                    count++;
                    L[i][j] = count;
                }else{
                    count = 0;
                }
             // System.out.print(L[i][j]);
            }
           // System.out.println();
        }
        for(int i =0;i<n;i++){
              count = 0;
            for(int j = n-1;j>=0;j--){
                if(mat[i][j] == 1){
                    count++;
                    R[i][j] = count;
                }else{
                    count = 0;
                }
             //   System.out.print(R[i][j]);
            }
          //  System.out.println();
        }
        for(int j =0;j<n;j++){
              count = 0;
            for(int i = 0;i<n;i++){
                if(mat[i][j] == 1){
                    count++;
                    U[i][j] = count;
                }else{
                    count = 0;
                }

            }
        }
        for(int j =0;j<n;j++){
              count = 0;
            for(int i = n-1;i>=0;i--){
                if(mat[i][j] == 1){
                    count++;
                    D[i][j] = count;
                }else{
                    count = 0;
                }

            }
        }
        int ans =0;
        for(int i =0 ;i<n;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j] == 1){
                  int LR = Math.min(L[i][j],R[i][j]);
                  int UD = Math.min(U[i][j],D[i][j]);
                  int min = Math.min(LR,UD);
                   ans = Math.max(ans,min);

                   
                }
               // System.out.print(R[i][j]);
            }
          //  System.out.println();
        }
        return ans;
    }
}