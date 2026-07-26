class Solution {
    public List<String> powerSet(String s) {
        // Code here
        
        
        List<String> list = solve(s, new ArrayList<>(), new StringBuilder(), 0);    
        
        Collections.sort(list);
        return list;
        
    }
    
    public List<String>solve(String s,List<String> powerSet ,StringBuilder sb, int index){
        
        if(index == s.length()){
            powerSet.add(sb.toString());
            return powerSet;
        }
        
        
        solve(s, powerSet, sb, index + 1);

        // Include
        sb.append(s.charAt(index));
        solve(s, powerSet, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        
        
        return powerSet;
    }
}