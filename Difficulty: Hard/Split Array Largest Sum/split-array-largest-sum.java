class Solution {
    public int splitArray(int[] arr, int k) {
        // code here
        int low = 0;
        int high = 0;
        int ans = 0;
        
        for(int i: arr){
            low = Math.max(low, i);
            high += i;
        }
        
        while(low <= high){
            int mid = low +(high - low)/2;
            if(isValid(arr, k, mid)){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
    
    boolean isValid(int []arr, int k, int max){
        
        int sum = arr[0];
        int count = 1;
        
        for(int i = 1; i<arr.length; i++){
            
            if(sum+arr[i] <= max){
                sum += arr[i];
            }else{
                count++;
                sum = arr[i];
                if(count > k)return false;
            }
            
        }
        return true;
    }

};