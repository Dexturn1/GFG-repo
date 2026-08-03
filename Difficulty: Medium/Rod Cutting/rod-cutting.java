class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        
        int [][]dp = new int[n][n+1];
        
        
        
        // write the base case 
        for(int len = 0; len <=n; len++){
            dp[0][len] = price[0]*len; 
        }
        
        
        for(int i =1; i<n; i++){
            for(int j = 1; j<=n; j++){

                //  notPick 
                int notPick = dp[i-1][j];
                
                int rodLength = i+1;
                int pick = Integer.MIN_VALUE;
                
                if(rodLength <= j){
                    pick = price[i] + dp[i][j - rodLength];
                }
                
                dp[i][j] = Math.max(pick , notPick);
            }
        }
        
        return dp[n-1][n];
        
    }
}