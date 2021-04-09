class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> que = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        que.add(beginWord);
        int level = 0;
        while(que.isEmpty()==false){
            int size = que.size();
            level++;
            for(int i = 0 ; i < size ; i++){
                String currentWord = que.poll();
                if(currentWord.equals(endWord))
                    return level;
                List<String> neighbors = neighbors(currentWord);
                for(String neigh : neighbors){
                    if(words.contains(neigh)){
                        words.remove(neigh);
                        que.add(neigh);
                    }
                }
            }
        }
        return 0;
        
    }
    public List<String> neighbors(String str){
        char [] m = str.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < m.length ; i++){
            char temp = m[i];
            for(char c = 'a' ; c<='z' ; c++){
                m[i] = c;
                String neighbor = new String(m);
                result.add(neighbor);
                
            }
            m[i] = temp;
         }
        return result;
    }
    
    
}