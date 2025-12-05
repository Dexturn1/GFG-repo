class Solution {
    public int findMin(int n) {
        // code here
     
     int []coins = {10, 5, 2, 1};
     int count = 0; 
     
     
     int i = 0;
     while( n > 0 && i<coins.length){
         
         if(n >=  coins[i]){
             count++;
             n = n - coins[i];
         }else{
             i++;
         }
     }
     
     return count;
     
    }
}
