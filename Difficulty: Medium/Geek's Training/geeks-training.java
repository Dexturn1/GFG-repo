class Solution {
    int dp[][];
    public int maximumPoints(int mat[][]) {
        // code here
        dp = new int[mat.length][4];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(mat.length-1, 3, mat);
    }
    
    
    int solve(int day, int last, int mat[][]){
        
        
        if (dp[day][last] != -1)
            return dp[day][last];
        
       if (day == 0) {

            int max = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    max = Math.max(max, mat[0][task]);
                }
            }

            return dp[0][last] = max;
        }

        int max = 0;
        for(int i = 0; i<3; i++){
            if(i!=last){
                max = Math.max(max,solve(day-1, i, mat)+mat[day][i]);
            }
        }
        return dp[day][last] = max;
        
    }
}