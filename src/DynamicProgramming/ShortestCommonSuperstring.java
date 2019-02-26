package DynamicProgramming;

import java.util.ArrayList;

public class ShortestCommonSuperstring {

    public int solve(String[] input) {
        int count = 0, currentCommon = 0, temp = 0;
        for (int i = 0; i < input.length; i++) {
            count += input[i].length();
        }
        System.out.println("sum = " + count);
        int[][] pairWords = new int[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                pairWords[i][j] = 0;
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i != j && input[j].contains(input[i])) {
                    pairWords[i][j] = -1;
                    pairWords[j][i] = -1;
                    count -= input[i].length();
                }
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i != j && pairWords[i][j] != -1 && pairWords[j][i] != -1) {
                    currentCommon = getCountSuffixAsPrefix(input[i], input[j]);
                    if (currentCommon > 0) {
                        System.out.println(input[i] + " " + input[j]);
                        if (pairWords[j][i] < currentCommon) {
                            pairWords[j][i] = 0;
                            pairWords[i][j] = currentCommon;
                        }
                        for (int k = 0; k < input.length; k++) {
                            temp = pairWords[i][k];
                            if (k != j && temp > 0) {
                                if (currentCommon > temp) {
                                    pairWords[i][k] = 0;
                                } else {
                                    pairWords[i][j] = 0;
                                }
                            }
                        }
                        for (int k = 0; k < input.length; k++) {
                            temp = pairWords[k][j];
                            if (k != i && temp > 0) {
                                if (currentCommon > temp) {
                                    pairWords[k][j] = 0;
                                } else {
                                    pairWords[i][j] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < pairWords.length; i++) {
            for (int j = 0; j < pairWords[i].length; j++) {
                if (pairWords[i][j] > 0) {
                    count -= pairWords[i][j];
                }
            }
        }
        return count;
    }

    private int getCountSuffixAsPrefix(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return 0;
        char firstChar = s2.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == firstChar && s1.length() - i <= s2.length()) {
                if (i == s1.length() - 1) {
                    return 1;
                }
                for (int j = i + 1; j < s1.length(); j++) {
                    if (s1.charAt(j) != s2.charAt(j - i)) {
                        break;
                    }
                    if (j == s1.length() - 1) {
                        return s1.length() - i;
                    }
                }
            }
        }
        return 0;
    }



    public int solve(ArrayList<String> listStr) {
        if (listStr == null) return 0;

        int n = listStr.size();
        if (n == 0) return 0;

        String[] arrStr = listStr.toArray(new String[n]);

        int len = n;
        while (len > 1) {
            int overlapMax = 0;
            int I = 0, J = 0;
            String resStr = "";
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    String curStr = findOverlap(arrStr[i], arrStr[j]);
                    int overlapCur = - curStr.length() + arrStr[i].length() + arrStr[j].length();
                    //System.out.println(i + " " + j + " " + curStr);
                    if (overlapMax < overlapCur) {
                        overlapMax = overlapCur;
                        resStr = curStr;
                        I = i;
                        J = j;
                    }
                }
            }
            --len;
            if (overlapMax == 0) {
                arrStr[0] += arrStr[len];
            } else {
                arrStr[I] = resStr;
                arrStr[J] = arrStr[len];
            }
        }
        return arrStr[0].length();
    }
    private String findOverlap(String a, String b) {
        int la = a.length();
        int lb = b.length();
        String res = a + b;
        for (int k = 1; k <= la; k++) {
            if (k > lb) break;
            if (b.endsWith(a.substring(0, k))) {
                res = b + a.substring(k);
            }
        }
        for (int k = 1; k <= lb; k++) {
            if (k > la) break;
            if (a.endsWith(b.substring(0, k))) {
                String tmpRes = a + b.substring(k);
                if (res.length() > tmpRes.length())
                    res = tmpRes;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ShortestCommonSuperstring ins = new ShortestCommonSuperstring();
//        int t1 = ins.solve(new String[]{"abcd", "cdef", "fgh", "de"});
//        int t2 = ins.solve(new String[]{"qwbgvmpef", "agqqcgovenfsv", "mmeck", "ebihjhtylca", "ksfnytlfjqa", "oosssfhwhr", "sybsl", "syonecma"});
//        int t3 = ins.solve(new String[]{"khtrvkmqdsxdaq", "srlnf", "ifevl", "koxebfas", "kguoyurb", "cvgpklfu", "lrhvevujwcjpi", "xfnwafx", "jwwyhkhee"});
//        int t3 = ins.solve(new String[]{"nejqokaplfbrqe", "cjqpuidbwnbaml", "naiwqahtpubspt", "jvidmdlrhjhkjt", "pjvyhpbqlsm", "lcgkneuqsydk", "mruvnqlapmjhp", "sioft", "nehtaxnb", "xlpsgn"});
        int t3 = ins.solve(new String[]{"fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb"});
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(t3);
        System.out.println(t3);
    }
}
