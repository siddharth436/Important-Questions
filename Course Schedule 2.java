class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer,List<Integer>> adj = new HashMap<Integer,List<Integer>>();
        int [] indegree = new int[numCourses];
        int [] topologicalOrder = new int[numCourses];
        for(int i = 0 ; i < prerequisites.length ; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> val = adj.getOrDefault(src,new ArrayList<Integer>());
            val.add(dest);
            adj.put(src,val);
            indegree[dest]+=1;
        }
        System.out.print(adj);
        System.out.println(Arrays.toString(indegree));
     Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < numCourses ; i++){
             if(indegree[i]==0)
                q.add(i);
    }
        int i = 0;
        while(q.isEmpty()==false){
            int node = q.remove();
            topologicalOrder[i++]=node;
            if(adj.containsKey(node)){
                for(Integer neighbor:adj.get(node)){
                    indegree[neighbor]--;
                    if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
                
                }
            }
           
        }
        if(i==numCourses)
            return topologicalOrder;
        return new int[0];
       
}
}