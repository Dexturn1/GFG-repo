class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int low = 0;
        int high = arr.length - 1; 
        int min = Integer.MAX_VALUE;
        int index = -1;
        
        while(low <= high){
            
            if(arr[low]<= arr[high]){
                if( arr[low] < min){
                    min = arr[low];
                    index = low;
                }
               break;
            }
            
            
            int mid = low + (high - low) /2;
            // if the left side is sorted
            if(arr[low]<= arr[mid]){
                
                if(arr[low] < min){
                    min = arr[low];
                    index = low;
                }
                
                low = mid +1;
            }
            //  if the right portion is sorted
            else{
                if(arr[mid] < min){
                    min = arr[mid];
                    index = mid;
                }
                high = mid -1;
            }
            
        }
        return index;
        
    }
}