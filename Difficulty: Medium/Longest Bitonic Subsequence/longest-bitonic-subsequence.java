class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here

        
        int []dp1 = new int[n];
        int []dp2 = new int[n];
        
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        int []nums1 = new int[n];
        
        int k = 0;
        for(int i = n-1; i >= 0; i--)nums1[k++] = nums[i];
        
    
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j < i; j++){
                
                if(nums[j] < nums[i] && dp1[j]+1 > dp1[i]){
                    dp1[i] = dp1[j] + 1;
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j < i; j++){
                if(nums1[j] < nums1[i] && dp2[j]+1 > dp2[i]){
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
        
        int max = 0;
            
        for(int i = 0; i< n ; i++){
           if (dp1[i] > 1 && dp2[n - 1 - i] > 1) {
                max = Math.max(max, dp1[i] + dp2[n - 1 - i] - 1);
            }
        }
        
        return max;
    }
}












