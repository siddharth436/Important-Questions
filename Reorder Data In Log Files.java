class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(log1,log2)->{
         
            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0,index1);
            String remaining_letter_log = log1.substring(index1+1);
             
            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0,index2);
            String remaining_digit_log = log2.substring(index2+1);
            
            boolean isDigit1 = Character.isDigit(remaining_letter_log.charAt(0));
            boolean isDigit2 = Character.isDigit(remaining_digit_log.charAt(0));
            
            if(isDigit1==false && isDigit2==false){
                int val = remaining_letter_log.compareTo(remaining_digit_log);
                if(val==0)
                    return id1.compareTo(id2);
                return val;
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
            return logs;
    }
}