class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ngt = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--){

            //check stack and remove elements smaller than and equal to it

            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ngt[i] = 0;
            } else{
                ngt[i] = st.peek() - i;
            }

            st.push(i);
        }
        return ngt;
    }
}