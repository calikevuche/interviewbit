package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HotelBookingsPossible {


    class Interval {
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

    class EventPoint {
        int time;
        boolean open;

        EventPoint(int time, boolean open) {
            this.time = time;
            this.open = open;
        }
    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        ArrayList<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < arrive.size(); i++) {
            intervals.add(new Interval(arrive.get(i), depart.get(i)));
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        outer:
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(j).start >= intervals.get(i).end) {
                    if (j - i > K) {
                        return false;
                    }
                    continue outer;
                }
            }
            if (intervals.size() - i > K) {
                return false;
            }
        }
        return true;
    }

    public boolean hotel2(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        ArrayList<EventPoint> eventPoints = new ArrayList<>();
        for (int i = 0; i < arrive.size(); i++) {
            if (arrive.get(i).equals(depart.get(i))) {
                continue;
            }
            eventPoints.add(new EventPoint(arrive.get(i), true));
            eventPoints.add(new EventPoint(depart.get(i), false));
        }
        Collections.sort(eventPoints, new Comparator<EventPoint>() {
            @Override
            public int compare(EventPoint o1, EventPoint o2) {
                return o1.time == o2.time ? Boolean.compare(o1.open, o2.open) :
                        Integer.compare(o1.time, o2.time);
            }
        });
        int counter = 0;
        for (int i = 0; i < eventPoints.size(); i++) {
            if (eventPoints.get(i).open) {
                counter++;
            } else {
                counter--;
            }
            if (counter > K) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        HotelBookingsPossible ins = new HotelBookingsPossible();
        ArrayList<Integer> arrive = new ArrayList<Integer>(Arrays.asList(
                35, 8, 23, 22, 35, 6, 48, 45, 33, 43, 37, 12, 42, 3, 31, 38, 5, 33, 15
        ));
        ArrayList<Integer> depart = new ArrayList<Integer>(Arrays.asList(
                43, 32, 34, 46, 74, 50, 95, 62, 59, 79, 83, 19, 88, 34, 75, 42, 42, 50, 588
        ));
        boolean result = ins.hotel2(arrive, depart, 11);
        System.out.println(result);
    }
}
