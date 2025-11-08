// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        backtrack(arr, 0, 0);
        return result;
    }
    public void backtrack(int []arr, int sum, int index){
        
        if(index == arr.length){
            result.add(sum);
            return;
        }
        
        // we decide not to choose 
        backtrack(arr, sum, index+1);
        
        // we decide to add 
        backtrack(arr, sum+arr[index], index+1);
            
        }
}