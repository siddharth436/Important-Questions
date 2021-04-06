class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int output[] = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(nums.length-1);
        output[n-1] = nums.length;
        for(int i = nums.length - 2 ; i>=0 ; i--){
            while(st.size()>0 && nums[i]>=nums[st.peek()])
                st.pop();
        
        if(st.size()==0)
            output[i] = nums.length;
        else
            output[i] = st.peek();
        st.push(i);
        }
    
    int j = 0;
    ArrayList<Integer> al = new ArrayList<Integer>();
    for(int i = 0 ; i <=nums.length-k; i++){
        if(j<i)
            j=i;
        while(output[j]<i+k){
            j = output[j];
          }
        al.add(nums[j]);
        
        
       
        
        
    }
        int aj [] = new int[al.size()];
        for(int i = 0 ; i < al.size() ; i++)
            aj[i] = al.get(i);
        System.out.print(al);
        return aj;
}
}