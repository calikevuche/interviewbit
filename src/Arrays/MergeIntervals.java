package Arrays;

import java.util.ArrayList;

/**
 * Created by OlehKa on 31.05.2016.
 */
public class MergeIntervals {

    public static final int UNDEFINED = -1;


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

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        Interval firstInterval = intervals.get(0);
        Interval lastInterval = intervals.get(intervals.size()-1);
        if (firstInterval.start > end) {
            intervals.add(0, newInterval);
            return intervals;
        }
        if (lastInterval.end < start) {
            intervals.add(newInterval);
            return intervals;
        }
        int firstIndex = UNDEFINED, lastIndex = UNDEFINED;
        for (int i = 0; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            int start1 = currentInterval.start;
            int end1 = currentInterval.end;
            if (i+1 < intervals.size()) {
                Interval nextInterval = intervals.get(i+1);
                int start2 = nextInterval.start;
                int end2 = nextInterval.end;
                if (end1 < start && start2 > end) {
                    intervals.add(i+1, newInterval);
                    return intervals;
                }
            }
            if (Math.max(start, start1) < Math.min(end, end1)) {
                if (firstIndex == UNDEFINED) {
                    firstIndex = i;
                } else {
                    lastIndex = i;
                }
            }
        }
        Interval overlapInterval = new Interval();
        if (lastIndex == UNDEFINED) {
            lastIndex = firstIndex;
        }
        overlapInterval.start = Math.min(start, intervals.get(firstIndex).start);
        overlapInterval.end = Math.max(end, intervals.get(lastIndex).end);
        intervals.subList(firstIndex, lastIndex+1).clear();
        intervals.add(firstIndex, overlapInterval);
        return intervals;
    }

    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(7,9));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        instance.insert(intervals, new Interval(1,10));
    }

}
