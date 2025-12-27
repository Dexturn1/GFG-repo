class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length-1] - stalls[0];
        int ans = 0;
        
        while(low <= high){
            int mid = (low + high) /2;
            
            if( canPlace(stalls, k, mid) ){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid -1;
        }
        return ans;
    }
    
    public boolean canPlace(int[] stalls, int cows, int minDist){
        int count = 1;
        int lastPlaced = stalls[0];
        
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-lastPlaced >= minDist){
                count++;
                lastPlaced = stalls[i];
                if(count >= cows) return true;
            }
        }
        return false;
    }
    
}