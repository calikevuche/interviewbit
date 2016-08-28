package BinarySearch;

/**
 * Created by OlehKa on 27.06.2016.
 */
public class SquareRootInteger {

    public int sqrt0(int a) {
        if (a < 0) return -1;
        int low = 0;
        int high = 46340; // sqrt of Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == a) {
                return mid;
            }
            else if (high - low == 0) {
                return low;
            }
            else if (mid * mid < a) {
                low = mid + 1;
                if (low * low > a) {
                    return mid;
                }
            } else {
                high = mid - 1;
                if (high * high < a) {
                    return mid - 1;
                }
            }
        }
        return -1;
    }

    public int sqrt(int a) {
        if (a < 0) return -1;
        if (a == 0) return 0;
        int ans = 0;
        int start = 0;
        int end = a;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid <= a / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SquareRootInteger instance = new SquareRootInteger();
        System.out.println(instance.sqrt(9));
        System.out.println(instance.sqrt(81));
        System.out.println(instance.sqrt(144));
        System.out.println(instance.sqrt(1936));
        System.out.println(instance.sqrt(308025));
        System.out.println(instance.sqrt(78996544));
        System.out.println(instance.sqrt(152_399_025));
        System.out.println(instance.sqrt(2_147_395_600));
        System.out.println(instance.sqrt(2_147_483_647));
        System.out.println(instance.sqrt(11));
        System.out.println(instance.sqrt(17));
        System.out.println(instance.sqrt(2));
        System.out.println(instance.sqrt(0));
        System.out.println(instance.sqrt(-1));
        System.out.println(instance.sqrt(740819855));
    }
}
