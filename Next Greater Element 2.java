class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int output[] = new int[nums.length];
        Arrays.fill(output,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < 2*nums.length ; i++){
            while(st.isEmpty()==false && nums[st.peek()]<nums[i%n])
                output[st.pop()] = nums[i%n];
            if(i<n)
                st.push(i);
        }
        return output;
        
    }
}