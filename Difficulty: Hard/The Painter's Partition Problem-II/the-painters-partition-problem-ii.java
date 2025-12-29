class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low = 0;
        int high = 0;
        
        for(int time: arr){
            low = Math.max(low, time);
            high += time;
        }
        
        int ans = 0;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(canComplete(arr, k, mid)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
        
    }
    
    public boolean canComplete(int[]arr, int painters, int maxTime){
        int count = 1;
        int timeTaken = arr[0];
        
        for(int i =1; i<arr.length; i++){
            if(timeTaken + arr[i] > maxTime){
                count++;
                timeTaken = arr[i];
            }else{
                timeTaken += arr[i];
            }
        }
        return count<=painters;
    }
}
