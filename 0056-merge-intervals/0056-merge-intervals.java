import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();

        // First interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Step 2: Check all intervals
        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            // No overlap
            else {
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}