class Solution {
    int floorSqrt(int n) {
        // code here
        
        int low = 0;
        int high = n;
        int ans = Integer.MIN_VALUE;
        
        while(low <= high){
        
            int mid = low + (high - low )/ 2;
            
            int sq = mid * mid;
            
            if(sq == n){
                return mid;
            }
            else if(sq< n){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
            
        }
        return ans;
    }
}