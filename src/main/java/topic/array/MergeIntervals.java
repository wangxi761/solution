package topic.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1)
            return intervals;
        intervals.sort((a,b)->a.start-b.start);

        List<Interval> list=new LinkedList<>();

        int start=intervals.get(0).start;
        int end=intervals.get(0).end;

        for (Interval i : intervals) {
            if(end>=i.start){
                end=Math.max(end,i.end);
            }else{
                list.add(new Interval(start,end));
                start=i.start;
                end=i.end;
            }
        }
        list.add(new Interval(start,end));
        return list;
    }


    @Test
    public void test(){
//        List<Interval> intervals= Arrays.asList(new Interval(1,3),new Interval(2,6),new Interval(8,10),new Interval(15,18));
        List<Interval> intervals= Arrays.asList(new Interval(1,4),new Interval(4,5));
        List<Interval> merge = merge(intervals);
        System.out.println(merge);
    }

}
