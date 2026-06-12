class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        
        int n = arr.length;
        int dup = -1;
        int missing = -1;
        for(int i = 0; i< n ; i++){
            
        if(arr[Math.abs(arr[i]) -1] > 0){
            arr[Math.abs(arr[i]) -1] *= -1;
        }else{
            dup = Math.abs(arr[i]);
        }
        }
        
        for(int i = 0; i< n; i++){
            if(arr[i] >0){
                missing = i+1;
                break;
            }
        }

        return new ArrayList<>(Arrays.asList(dup, missing));        
    }
}
