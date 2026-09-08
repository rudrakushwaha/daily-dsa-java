import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Step 2: Take first interval as current interval
        int[] current = intervals[0];

        // Step 3: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];

            // Overlap condition
            if (next[0] <= current[1]) {

                // Merge intervals
                current[1] = Math.max(current[1], next[1]);

            } else {

                // No overlap
                // Add current interval to result
                result.add(current);

                // Move current to next interval
                current = next;
            }
        }

        // Step 4: Add last interval
        result.add(current);

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}