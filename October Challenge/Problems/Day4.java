package Problems;

import java.util.Arrays;

public class Day4 {
    public int removeCoveredIntervals1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // sort by start time ascending, if start times are same, sort by descending end time
        Arrays.sort(intervals, ((a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        
        int ans = intervals.length, end = Integer.MIN_VALUE;
        
        for (int i = 0; i < intervals.length; i++) {
			// If the current intervals end previously than the latest checkpoint
			// Then there is an overlap, so decrease answer.
            if(intervals[i][1] <= end) --ans; 
			
			// update current end
            else end = intervals[i][1];
        }
        
        return ans;
    }
    
    public int removeCoveredIntervals(int[][] A) {
        int res = 0, left = -1, right = -1;
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        for (int[] v : A) {
            // new uncovered interval : when both new left and new right are greater than prev left & right
            if (v[0] > left && v[1] > right) {
                // directly update left as it is guratnteed to be greater
                left = v[0];
                ++res;
            }
            // right was not sorted earlier, so take max
            right = Math.max(right, v[1]);
        }
        return res;
    }
}
