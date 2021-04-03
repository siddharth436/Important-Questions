class Data implements Comparable<Data>{
    public String username;
    public int timestamp;
    public String website;
    
    public Data(String username, int timestamp, String website){
        this.username=username;
        this.timestamp=timestamp;
        this.website=website;
    }
    
    @Override
    public int compareTo(Data data){
        return this.timestamp-data.timestamp;
    }    
}

class Solution {
        
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        // Make the list of Data sorted by timestamp        
        PriorityQueue<Data> queue=buildListData(username, timestamp,website);        
        // build map of user and list of website visted
        Map<String, List<String>> userWebs= buildUserWebsMap(queue);                
        // build List of combination 3 websites from list of each user. Each user will have a Set of combination
        List<Set<String>> userCombines= builUserSetCombinationOfThreeWebs(userWebs);        
        // Count number of combination from the list of set
        Map<String, Integer> mapCombines= getMaxOfThreeCombinations(userCombines);        
        // get the max value and the first item of list after sorted
        return getResult(mapCombines);
    }
    
    PriorityQueue<Data> buildListData(String[] username, int[] timestamp, String[] website){
        PriorityQueue<Data> queue=new PriorityQueue<Data>();
        for (int i=0;i<username.length;i++){
            Data data=new Data(username[i], timestamp[i],website[i]);
            queue.add(data);
        }
        return queue;
    }    
    
    Map<String, List<String>> buildUserWebsMap(PriorityQueue<Data> queue){
        Map<String, List<String>> userWebs=new HashMap<>();        
        while(!queue.isEmpty()){
            Data data=queue.poll();
            userWebs.putIfAbsent(data.username,new ArrayList<String>());
            userWebs.get(data.username).add(data.website);
        }              
        return userWebs;
    }
    
    List<Set<String>> builUserSetCombinationOfThreeWebs(Map<String, List<String>> userWebs){
        List<Set<String>> userCombines=new ArrayList<>();   
        for(Map.Entry<String,List<String>> entry: userWebs.entrySet()){
            List<String> webList=entry.getValue();
            Set<String> setWeb=new HashSet<>();
            for(int i=0;i<webList.size()-2;i++){
                for(int j=i+1;j<webList.size()-1;j++){                
                    for(int k=j+1;k<webList.size();k++){
                        setWeb.add(webList.get(i)+" " + webList.get(j)+" " +webList.get(k));
                    }
                }    
            }
            userCombines.add(setWeb);
        }        
        return userCombines;
    }
    
    Map<String, Integer> getMaxOfThreeCombinations(List<Set<String>> userCombines){
        Map<String, Integer> mapCombine=new HashMap<>();        
        for(Set<String> userCombine: userCombines){            
            for(String combine:userCombine){
                mapCombine.put(combine, mapCombine.getOrDefault(combine,0) +1);    
            }            
        }        
        return mapCombine;
    }
    
    
    List<String> getResult(Map<String, Integer> mapCombine){
        int max=Collections.max(mapCombine.values());
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> entry: mapCombine.entrySet()){
            if(entry.getValue()==max){
                list.add(entry.getKey());
            }
        }        
        Collections.sort(list);        
        String[] res=list.get(0).split(" ");        
        return Arrays.asList(res);        
    }
}
