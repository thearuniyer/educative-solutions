import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};
// [1, 4], [2, 5], [7, 9]
public class MergeIntervals {
    
    public static List<Interval> merge(List<Interval> intervals) {
        // Sort the list by ascending order of start times
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        // create resultant list
        List<Interval> mergeIntervals = new ArrayList<Interval>();
        Interval curInterval = intervals.get(0);
        // insert first interval from input into Result list
        mergeIntervals.add(curInterval);
        // loop through each interval
        for(Interval interval : intervals) {
            
            int cur_start = curInterval.start;
            int cur_end = curInterval.end;
            int next_start = interval.start;
            int next_end = interval.end;
            // if current end is greater than or equal to next begin then there is overlap
            if(cur_end >= next_start) {
                // take the value for the greater end between current and next and update current with it to absorb the interval 
                curInterval.end = Math.max(cur_end, next_end);
            }
            else {
                // if no overlap, make the new interval your current and add to list end
                curInterval = interval;
                mergeIntervals.add(curInterval);
            }
        }
        return mergeIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merge Intervals: ");
        for(Interval interval : MergeIntervals.merge(input)) {
            System.out.print("[" + interval.start + ", " + interval.end + "]");
        }
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merge Intervals: ");
        for(Interval interval : MergeIntervals.merge(input)) {
            System.out.print("[" + interval.start + ", " + interval.end + "]");
        }
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merge Intervals: ");
        for(Interval interval : MergeIntervals.merge(input)) {
            System.out.print("[" + interval.start + ", " + interval.end + "]");
        }
        System.out.println();
    }
}
