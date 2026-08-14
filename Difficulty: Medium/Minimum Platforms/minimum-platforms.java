class Solution {
    public int minPlatform(int arr[], int dep[]) {
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int n = arr.length;
        
        int i = 0;
        int j = 0;
        int max = 0;
        
        int count = 0;
        
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        
        return max;
        
    }
}
 