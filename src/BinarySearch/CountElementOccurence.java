package BinarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 27.06.2016.
 */
public class CountElementOccurence {

    // DO NOT MODIFY THE LIST
    public int findCount(final List<Integer> a, int b) {

        int start = 0, end = a.size()-1;
        int index1 = 0, index2 = -1;

        // find leftMost
        if (a.get(0) == b) {
            index1 = 0;
        } else {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (a.get(mid) == b && a.get(mid-1) != b) {
                    index1 = mid;
                    break;
                }
                else if (a.get(mid) < b) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }

            }
        }

        // find rightMost
        if (a.get(a.size()-1) == b) {
            index2 = a.size()-1;
        } else {
            start = 0; end = a.size()-1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (a.get(mid) == b && a.get(mid+1) != b) {
                    index2 = mid;
                    break;
                }
                else if (a.get(mid) <= b) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }

//        System.out.println(index1 +" "+ index2);

        return index2 - index1 + 1;
    }

    public static void main(String[] args) {
        CountElementOccurence instance = new CountElementOccurence();
        System.out.println(instance.findCount(Arrays.asList(1,2,2,3), 2));
        System.out.println(instance.findCount(Arrays.asList(1,2,2,3), 4));
        System.out.println(instance.findCount(Arrays.asList(2,2,2,3), 2));
        System.out.println(instance.findCount(Arrays.asList(1,1,2,2,2,2,2,3), 2));
        System.out.println(instance.findCount(Arrays.asList(1,3,3,5,5,5,5,5,9,9,11), 5));
    }
}
