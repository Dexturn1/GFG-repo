class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty())
            return;

            
        int top = st.pop();
        sortStack(st);
        sort(st, top);
    }
    
    
    public void sort(Stack<Integer> st, int element){
        
        if(st.isEmpty() || element > st.peek()){
            st.push(element);
            return;
        }
        
        int top = st.pop();
        sort(st, element);
        st.push(top);
    }
}