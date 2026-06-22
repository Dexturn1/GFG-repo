class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low = 0;
        int high = 0;
        int ans = 0;
        
        for(int i = 0; i< arr.length; i++){
            low = Math.max(low , arr[i]);
            high += arr[i];
        }
        
    
        while( low <= high){
            int mid = low + (high -low)/2;
            
            if(canPaint(arr, k, mid)){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    
    
    boolean canPaint(int[] arr, int k, int maxtime){
        int count = 1;
        int painted = arr[0];
        
        for(int i = 1; i<arr.length; i++){
            if(painted + arr[i] <= maxtime){
                painted += arr[i];
            }else{
                count++;
                painted = arr[i];
                if(count > k)return false;
            }
        }
        return true;
    }
    
}
