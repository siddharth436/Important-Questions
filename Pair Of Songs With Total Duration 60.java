class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int remainder[] = new int[60];
        for(int i : time){
             if(i%60 == 0)
                count+=remainder[0];
            else{
                count+=remainder[60-i%60];
            }
            remainder[i%60]++;
            
        }
        return count;
           
            
        
        
}
}