class Solution {
    static int solve(int bt[]) {
        // code here
        
        
        Arrays.sort(bt);
        
        
        int totalWaiting = 0;
        int elapsed = 0;
        
        
        for(int time: bt){
            totalWaiting += elapsed;
            elapsed += time;
        }
        
        return totalWaiting/bt.length;
        
    }
}
