package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by OlehKa on 11.06.2016.
 */
public class MergeOverlappingIntervals {

    class MyComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }

     public static class Interval {
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
     }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new MyComparator());
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval currentI = intervals.get(i);
            Interval nextI = intervals.get(i+1);
            if (currentI.end >= nextI.start) {
                currentI.end = Math.max(currentI.end, nextI.end);
                intervals.remove(i+1);
                i--;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        MergeOverlappingIntervals instance = new MergeOverlappingIntervals();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(10,10));
        intervals.add(new Interval(1,10));
        intervals.add(new Interval(3,8));
        intervals.add(new Interval(6,6));
        instance.merge(intervals);
    }
}
