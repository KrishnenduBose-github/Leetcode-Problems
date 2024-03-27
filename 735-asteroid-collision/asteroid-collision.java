class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);
        for(int i =1;i<asteroids.length;i++){
            if(st.isEmpty()) {st.push(asteroids[i]);

           } else if((asteroids[i] > 0 && st.peek() > 0) || (asteroids[i] < 0 && st.peek() < 0)
                               || (st.peek() < 0 && asteroids[i] > 0)){
                st.push(asteroids[i]);

             }else {
                while(st.size() > 0  && (Math.abs(asteroids[i]) > Math.abs(st.peek())) && st.peek() > 0 ) st.pop();
                    if(st.size() == 0 || st.peek() < 0){
                    st.push(asteroids[i]);
                   // if((Math.abs(asteroids[i]) == Math.abs(st.peek())) && (st.peek() > 0 && asteroids[i] < 0) ) st.pop();
                   // if(st.peek() < 0) st.push(asteroids[i])
                   }else if(st.peek() == Math.abs(asteroids[i])) st.pop();

             }
        }
        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while(st.size() > 0){
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}