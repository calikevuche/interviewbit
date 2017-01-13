package Hashing;

import java.util.*;

/**
 * Created by OlehKa on 27.12.2016.
 */
public class WindowString {

    public String minWindow101(String S, String T) {
        if (S.isEmpty() || T.isEmpty()) return "";
        boolean search = false;
        int start = 0, end = 0;
        int minS = -1, minE = -1;
        HashMap<Character, Integer> original = new HashMap<>();
        char[] charsS = S.toCharArray();
        char[] charsT = T.toCharArray();
        int val;
        for (char c: charsT) {
            if (original.containsKey(c)) {
                val = original.get(c);
            } else {
                val = 0;
            }
            original.put(c, val+1);
        }
        HashMap<Character, Integer> copy = new HashMap<>(original);
        while (start <= charsS.length - charsT.length) {
            if (!search) {
                if (copy.containsKey(charsS[start])) {
                    search = true;
                    val = copy.get(charsS[start]);
                    if (val <= 1) copy.remove(charsS[start]);
                    else copy.put(charsS[start], val-1);
                    end = start+1;
                } else {
                    start++;
                }
            } else  {
                if (copy.containsKey(charsS[end])) {
                    val = copy.get(charsS[end]);
                    if (val <= 1) copy.remove(charsS[end]);
                    else copy.put(charsS[end], val-1);
                }
                end++;
            }
            if (copy.isEmpty()) {
                if ((minS == -1 && minE == -1) || (end - start < minE - minS)){
                    minS = start;
                    minE = end;
                }
            }
            if (copy.isEmpty() || end == charsS.length || (minS != -1 && minE != -1 && end - start > minE - minS)) {
                copy.clear();
                copy.putAll(original);
                start++;
                search = false;
            }
        }
        return (minS != -1 && minE != -1) ? S.substring(minS, minE) : "";
    }

    public String minWindow102(String S, String T) {
        List<Character> list1 = new ArrayList<>();
        for (char c: S.toCharArray()) {
            list1.add(c);
        }
        List<Character> list2 = new ArrayList<>();
        for (char c: T.toCharArray()) {
            list2.add(c);
        }
        int start = 0, end = start+1;
        int m1 = -1, m2 = -1;
        if (containsAll(list1.subList(start,end), list2)) {
            m1 = start;
            m2 = end;
        }

        while (start < list1.size() - list2.size() && end <= list1.size()) {
            if (end - start >= list2.size() && containsAll(list1.subList(start,end), list2)) {
                if ((m1 == -1 && m2 == -1) || (end - start < m2 - m1)) {
                    m1 = start;
                    m2 = end;
                }
                start++;
            } else {
                end++;
            }
        }

        return (m1 != -1 && m2 != -1) ? S.substring(m1, m2) : "";
    }

    public boolean containsAll(List<Character> li1, List<Character> li2) {
        List<Character> copy = new ArrayList<>(li1);
        for (Character c: li2) {
            if (copy.contains(c)){
                copy.remove(c);
            } else {
                return false;
            }
        }
        return true;
    }

    // ==== FINAL ====

    public String minWindow(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arrayS = S.toCharArray();
        char[] arrayT = T.toCharArray();

        for (Character c: arrayT) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0, right = 0;
        int minLeft = -1, minRight = -1;

        while (right < S.length()) {
            if (map.containsKey(arrayS[right])) {
                map.put(arrayS[right], map.get(arrayS[right]) - 1);
            }
            right++;
            if (isEmpty(map)) {
                while (right - left >= arrayT.length) {
                    if (minLeft == -1 || (right - left < minRight - minLeft)) {
                        minLeft = left;
                        minRight = right;
                    }
                    left++;
                    if (map.containsKey(arrayS[left-1])) {
                        int val = map.get(arrayS[left-1]) + 1;
                        map.put(arrayS[left-1], val);
                        if (val > 0) break;
                    }
                }
            }
        }

        return (minLeft == -1) ? "" : S.substring(minLeft,minRight);
    }

    public boolean isEmpty(HashMap<Character,Integer> map){
        for (Character c: map.keySet()) {
            if (map.get(c) > 0)  {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WindowString windowString = new WindowString();
//        String res = windowString.minWindow("xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh", "dO4BRDaT1wd0YBhH88");
        String res = windowString.minWindow("ADOBECODEBANC", "ABC");
//        String res = windowString.minWindow("aaaaaa", "aa");
//        String res = windowString.minWindow("a", "a");
        System.out.println(res);
    }
}
