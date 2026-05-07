class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i<asteroids.length; i++) {
            int nums=asteroids[i];
            boolean d = false;
            while (!st.isEmpty() && st.peek() > 0 && nums < 0) {

                if (st.peek() < -nums) {
                    st.pop();
                }

                else if (st.peek() == -nums) {
                    st.pop();
                    d = true;
                    break;
                }
                else {
                    d = true;
                    break;
                }
            }

            if (!d) {
                st.push(nums);
            }
        }
        int[] ans = new int[st.size()];
        for (int j = st.size() - 1; j >= 0; j--) {
            ans[j] = st.pop();
        }

        return ans;
    }
}