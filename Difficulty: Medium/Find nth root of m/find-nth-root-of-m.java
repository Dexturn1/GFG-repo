class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 0;
        int high = m;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int check = powerCheck (mid, n, m);
            
            if(check == 1) return mid;
            else if(check == 0) low = mid+ 1;
            else high = mid - 1;
        }
        return -1;
        
    }
    
    int powerCheck(int mid , int n, int m){
        long result = 1;
        
        for(int i = 1; i<= n; i++){
            result *= mid;
            if(result > m) return 2;
        }
        if(result == m) return 1;
        return 0;
    }
}