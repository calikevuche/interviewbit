package HeapsAndMaps;

import java.util.*;

public class MagicianAndChocolates {

    public int nchoc(int A, ArrayList<Integer> B) {
        int result = 0;
        int mod = (int) (Math.pow(10, 9) + 7);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(B);
        int temp = 0;
        for (int i = 0; i < A; i++) {
            temp = priorityQueue.poll();
            priorityQueue.add(temp / 2);
            result += temp % mod;
            result %= mod;
        }
        return result % mod;
    }

    public static void main(String[] args) {
        MagicianAndChocolates obj = new MagicianAndChocolates();
//        obj.nchoc(3, new ArrayList<>(Arrays.asList(6, 5)));
        obj.nchoc(10, new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647)));
    }
}
