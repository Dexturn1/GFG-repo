class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        int n = mat.length;
        int [][]dp = new int [n][4];
        for(int[]row :dp)Arrays.fill(row, -1);
        return solve(n-1, 3, mat, dp);
    }
    
    static int solve(int day, int last, int [][]mat, int [][]dp){
        if(dp[day][last] != -1) return dp[day][last];
        
        if(day == 0){
            int max = 0;
            for(int i = 0; i<3; i++){
                if(i != last){
                max = Math.max(mat[0][i], max);
                }
            }
            return dp[day][last] = max;
        }
        
        int max = 0;
        for(int i = 0; i<3; i++){
            if(i!=last){
                int point = mat[day][i] + solve(day-1, i, mat, dp);
                max = Math.max(point, max);
            }
        }
        
        return dp[day][last] = max;
    }
}