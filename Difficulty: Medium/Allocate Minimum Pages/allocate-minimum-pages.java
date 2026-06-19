class Solution {
    public int findPages(int[] arr, int k) {
        // code here
    
        if(k > arr.length) return -1;
        
        int low = 0;
        int high = 0;
        int ans = -1;
        
        for(int book: arr){
            low = Math.max(low, book); // FIXED
            high += book;
        }
        
        
        while( low <= high){
            int mid = low + (high - low)/2;
            
            if(canAssign(arr, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid +1;
            }
        }
        
        return ans;
    }
    
    boolean canAssign(int []books, int students, int maxPage){
        int count = 1;
        int totalPageCount = 0;
        for(int pages: books){
            
            if(totalPageCount + pages <= maxPage){
                totalPageCount += pages;
            }else{
                count++;
                totalPageCount = pages;
                
                if(count > students) return false;
            }
        }
        return true;
    }
}