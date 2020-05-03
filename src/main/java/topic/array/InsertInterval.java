package topic.array;

import org.junit.jupiter.api.Test;
import struct.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        intervals.add(newInterval);

        if (intervals.size() == 1)
            return result;

        int[] begins = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            begins[i] = interval.start;
            ends[i] = interval.end;
        }

        Arrays.sort(begins);
        Arrays.sort(ends);

        for (int i = 0, j = 0; i < begins.length; i++) {
            if (i == begins.length - 1 || begins[i + 1] > ends[i]) {
                result.add(new Interval(begins[j], ends[i]));
                j = i + 1;
            }
        }
        return result;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};
        int[] begins = new int[intervals.length + 1];
        int[] ends = new int[intervals.length + 1];

        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        begins[intervals.length]=newInterval[0];
        ends[intervals.length]=newInterval[1];

        Arrays.sort(begins);
        Arrays.sort(ends);
        List<int[]> result = new LinkedList<>();
        for (int i = 0, j = 0; i < begins.length; i++) {
            if (i == begins.length - 1 || begins[i + 1] > ends[i]) {
                result.add(new int[]{begins[j], ends[i]});
                j = i + 1;
            }
        }


        int[][] arr=new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arr[i]=result.get(i);
        }
        return arr;
    }

    @Test
    public void test() {
        List<Interval> list = new ArrayList() {{
            add(new Interval(1, 2));
            add(new Interval(3, 5));
            add(new Interval(6, 7));
            add(new Interval(8, 10));
            add(new Interval(12, 16));
        }};
        Interval newInterval = new Interval(4, 8);
        List<Interval> intervalList = insert(list, newInterval);
        System.out.println(intervalList);
    }
}
