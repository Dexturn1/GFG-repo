class Solution {
    int [][]dp;
    public int cutRod(int[] price) {
        // code here
        
        int N = price.length;
        dp = new int[N][N+1];
        
        for(int []row: dp) Arrays.fill(row, -1);
        
        return solve(N-1, N, price);
    }
    
    int solve(int index, int N, int []price){
        
        if(index == 0)
            return N * price[0];
            
        if(dp[index][N] != -1) return dp[index][N];
            
            
        int notTake = solve(index-1, N, price);
        
        int take = Integer.MIN_VALUE;
        int rodLength = index+1;
        
        if(rodLength <= N){
            take = price[index] + solve(index, N - rodLength, price);
        }
        
        return dp[index][N] = Math.max(take, notTake);
        
    }
}