package question_0056.MergeIntervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,2},{3,4}};
        for (int[] ints:merge(intervals)) {
            System.out.print(Arrays.toString(ints)+" ");
        }

    }
    public static int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length==0) return null;
        for (int i = 0; i < intervals.length-1; i++) {
                if (intervals[i][0]>intervals[i][1]){
                    int temp = intervals[i][0];
                    intervals[i][0] = intervals[i][1];
                    intervals[i][1] = temp;
            }
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        int[][] ints = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
