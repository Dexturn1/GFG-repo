class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans =  new ArrayList<Integer>();
        
        int maxValue = Integer.MIN_VALUE;
        
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] >= maxValue){
                maxValue = arr[i];
                ans.add(arr[i]);
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}
