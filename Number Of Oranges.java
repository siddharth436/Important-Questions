class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh_oranges=0;
        Queue<int[]> que = new LinkedList<>();
         for(int i = 0 ; i < m ; i++){
             for(int j = 0 ; j < n ; j++){
                 if(grid[i][j]==2)
                     que.add(new int[]{i,j});
                 else if(grid[i][j]==1)
                     fresh_oranges++;
                     
             }
         }
        if(fresh_oranges==0)
            return 0;
        int count = 0;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(que.isEmpty()==false){
            count++;
            int size = que.size();
            for(int i = 0 ; i < size ; i++){
                int temp[] = que.poll();
                for(int arr[] : directions){
                  int x = arr[0]+temp[0];
                    int y = arr[1]+temp[1];
                    if(x<0 || y < 0 || x>=m || y>=n ||  grid[x][y]==0 || grid[x][y]==2)
                        continue;
                    grid[x][y] = 2;
                    que.offer(new int[]{x,y});
                    fresh_oranges--;
                }
            }   
        }
        return fresh_oranges==0 ? count-1 : -1;
}
}