package BinarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OlehKa on 27.06.2016.
 */
public class RotatedArray {

    // DO NOT MODIFY THE LIST
    public int findMin0(final List<Integer> a) {
        if (a.get(0) < a.get(a.size()-1)) {
            return a.get(0);
        }
        int min = a.get(0);
        int start = 0, end = a.size()-1;
        while (start <= end) {
            if (a.get(start) < a.get(end)) {
                if (a.get(start) < min) {
                    min = a.get(start);
                }
            } else {
                if (a.get(end) < min) {
                    min = a.get(end);
                }
            }
            int mid = start + (end - start) / 2;
            if (a.get(mid) < min) {
                min = a.get(mid);
            }
            if (a.get(mid) > a.get(start)) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }

        return min;
    }

    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
        int low = 0, high = a.size()-1;
        while (low <= high) {
            if (a.get(low) <= a.get(high)) {
                return a.get(low);  // Case 1
            }
            int mid = (low + high) / 2;
            int next = (mid+1) % a.size();
            int prev = (mid-1+a.size()) % a.size();
            if (a.get(mid) <= a.get(prev) && a.get(mid) <= a.get(next)) {
                return a.get(mid);  // Case 2
            }
            else if (a.get(mid) <= a.get(high)) {
                high = mid - 1;     // Case 3
            }
            else if (a.get(mid) >= a.get(low)) {
                low = mid + 1;      // Case 4
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RotatedArray instance = new RotatedArray();
        System.out.println(instance.findMin(Arrays.asList(1,2,3)));
        System.out.println(instance.findMin(Arrays.asList(2,3,1)));
        System.out.println(instance.findMin(Arrays.asList(4,5,6,7,0,1,2)));
        System.out.println(instance.findMin(Arrays.asList( 40342, 40766, 41307, 42639, 42777, 46079, 47038, 47923, 48064, 48083, 49760, 49871, 51000, 51035, 53186, 53499, 53895, 59118, 60467, 60498, 60764, 65158, 65838, 65885, 65919, 66638, 66807, 66989, 67114, 68119, 68146, 68584, 69494, 70914, 72312, 72432, 74536, 77038, 77720, 78590, 78769, 78894, 80169, 81717, 81760, 82124, 82583, 82620, 82877, 83131, 84932, 85050, 85358, 89896, 90991, 91348, 91376, 92786, 93626, 93688, 94972, 95064, 96240, 96308, 96755, 97197, 97243, 98049, 98407, 98998, 99785, 350, 2563, 3075, 3161, 3519, 4176, 4371, 5885, 6054, 6495, 7218, 7734, 9235, 11899, 13070, 14002, 16258, 16309, 16461, 17338, 19141, 19526, 21256, 21507, 21945, 22753, 25029, 25524, 27311, 27609, 28217, 30854, 32721, 33184, 34190, 35040, 35753, 36144, 37342)));
        System.out.println(instance.findMin(Arrays.asList(76961, 77242, 78246, 79428, 80505, 80843, 80894, 81082, 81351, 81591, 81990, 82503, 82983, 83668, 84048, 86502, 87162, 87479, 88720, 90773, 91077, 91095, 91204, 91554, 92323, 93043, 93240, 93357, 93745, 94622, 94742, 96173, 97712, 98000, 98616, 99102, 1396, 1577, 2682, 3644, 4749, 5623, 6522, 7245, 8564, 8675, 9671, 10500, 11276, 12033, 12682, 13977, 14324, 14626, 14804, 15036, 15070, 15656, 15660, 16227, 16436, 17591, 18442, 18674, 18770, 19825, 19904, 20836, 21503, 21666, 21755, 22345, 22580, 24128, 24640, 25200, 25610, 25852, 26424, 26675, 28115, 28433, 29053, 29957, 29975, 30020, 30396, 30567, 31821, 33292, 33319, 34040, 34696, 34781, 35770, 36239, 37460, 37507, 38910, 39310, 39947, 40097, 40170, 40354, 40436, 40670, 44373, 44461, 44790, 45024, 45154, 45526, 45758, 46648, 48852, 51549, 54652, 55102, 55455, 55501, 55690, 56135, 56161, 56509, 56674, 57017, 57571, 57821, 58353, 58904, 58906, 59057, 59119, 59443, 60226, 60687, 60973, 61863, 62346, 62475, 63106, 63254, 65085, 65251, 65472, 65529, 66723, 67327, 68770, 69656, 69867, 70632, 71155, 72148, 72185, 72277, 72440, 73058, 73223, 74078, 75208, 76131, 76214, 76776)));
    }
}
