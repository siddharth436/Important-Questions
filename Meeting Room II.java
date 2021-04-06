class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return 0;
        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int meeting_rooms=0;
        while(i<n){
            if(start[i]<end[j]){
                meeting_rooms++;
            }
            else
                j++;
            i++;
        }
        return meeting_rooms;
}
}