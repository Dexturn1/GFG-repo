class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();

        if(maze[0][0] == 0){
            return ans;
        }
        backtrack(0,0,maze,ans, new StringBuilder());
        Collections.sort(ans);
        return ans;
    }
    
    
    public void backtrack(int row, int col,  int [][]maze, List<String> ans, StringBuilder sb){
        
        
        if(maze[row][col] == 0)
            return;
            
        
        if(row == maze.length- 1 && col == maze.length-1){
            ans.add(sb.toString());
            return;
        }
            
        
        
        maze[row][col] = 0;
        
        //  down
        if(row + 1 < maze.length){
            sb.append("D");
            backtrack(row+1, col, maze, ans, sb);
            sb.deleteCharAt(sb.length()-1 );
        }
            
        
        //  right 
        if(col + 1 < maze.length){
            sb.append("R");
            backtrack(row, col+1, maze, ans, sb);
            sb.deleteCharAt(sb.length()-1 );
        }
            
        // up
        if(row - 1 >= 0){
            sb.append("U");
            backtrack(row-1, col, maze, ans, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        // left
        if(col-1 >= 0){
            sb.append("L");
            backtrack(row, col-1, maze, ans, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        maze[row][col] = 1;
    }
}