package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoinSumInfinite {

    public int coinchange2(int[] S, int N) {
        if (S.length == 0) {
            return 0;
        }
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        solve(S, N, set, list);
        return set.size();
    }

    private void solve(int[] S, int N, Set<List<Integer>> set, List<Integer> list) {
        if (N == 0) {
            List<Integer> copy = new ArrayList<>(list);
            Collections.sort(copy);
            set.add(copy);
        }
        if (N < S[0]) {
            return;
        }
        for (int i = 0; i < S.length; i++) {
            if (N < S[i]) {
                break;
            }
            list.add(S[i]);
            solve(S, N - S[i], set, list);
            list.remove(list.size() - 1);
        }
    }

    // Best
    public int coinchange22(int[] S, int N) {
        int[] cache = new int[N + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = 0;
        }
        cache[0] = 1;
        for (int i = 0; i < S.length; i++) {
            for (int j = S[i]; j <= N; j++) {
                cache[j] = (cache[j] + cache[j - S[i]]) % 1000007;
            }
        }
        return cache[N];
    }

    public int coinchange222(int[] S, int N) {
        Map<String, Integer> cache = new HashMap<>();
        return solve(S, N, cache, S.length - 1);
    }

    private int solve(int[] S, int N, Map<String, Integer> map, int coin) {
        if (N == 0) {
            return 1;
        }
        if (N < 0 || coin < 0) {
            return 0;
        }
        if (map.containsKey(N + "_" + coin)) {
            return map.get(N + "_" + coin);
        }
        int result = 0;
        result = (result + solve(S, N, map, coin - 1)) % 1000007;
        result = (result + solve(S, N - S[coin], map, coin )) % 1000007;
        map.put(N + "_" + coin, result);
        return result;
    }


    public static void main(String[] args) {
        CoinSumInfinite ins = new CoinSumInfinite();

        int t1 = ins.coinchange222(new int[]{1, 2, 3}, 4);
        System.out.println(t1);

        int t2 = ins.coinchange222(new int[]{18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8}, 458);
        System.out.println(t2);
    }
}
