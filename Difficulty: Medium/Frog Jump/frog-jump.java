class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n-1, height, dp);
    }
    
    static int solve(int i, int[] height, int[] dp){
        
        if(i == 0){
            return 0;
        }
        
        if(dp[i] != -1) return dp[i];
        
        int left = solve(i-1, height, dp) + Math.abs(height[i]-height[i-1]);
        
        int right = Integer.MAX_VALUE;
        if(i>1)
        right = solve(i-2, height, dp) + Math.abs(height[i] - height[i-2]);
        
        return dp[i] = Math.min(left, right);
         
    }
    
}