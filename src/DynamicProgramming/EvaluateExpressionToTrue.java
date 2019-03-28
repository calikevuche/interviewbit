package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrue {

    Map<String, Integer> cacheTrue = new HashMap<>();
    Map<String, Integer> cacheFalse = new HashMap<>();

    public int cnttrue(String A) {
        return waysTrue(A);
    }

    private int waysTrue(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == 'T' ? 1 : 0;
        }
        if (cacheTrue.containsKey(s)) {
            return cacheTrue.get(s);
        }
        int result = 0;
        String left, right;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                left = s.substring(0, i);
                right = s.substring(i + 1);
                result += waysTrue(left) * waysTrue(right) + waysFalse(left) * waysTrue(right) + waysTrue(left) * waysFalse(right);
            } else if (s.charAt(i) == '&') {
                left = s.substring(0, i);
                right = s.substring(i + 1);
                result += waysTrue(left) * waysTrue(right);
            } else if (s.charAt(i) == '^') {
                left = s.substring(0, i);
                right = s.substring(i + 1);
                result += waysFalse(left) * waysTrue(right) + waysTrue(left) * waysFalse(right);
            }
            result %= 1003;
        }
        cacheTrue.put(s, result);
        System.out.println("s = " + s + ", result = " + result);
        return result % 1003;
    }

    private int waysFalse(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == 'T' ? 0 : 1;
        }
        if (cacheFalse.containsKey(s)) {
            return cacheFalse.get(s);
        }
        int result = 0;
        String left, right;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                left = s.substring(0, i);
                right = s.substring(i + 1);
                result += waysFalse(left) * waysFalse(right);
            } else if (s.charAt(i) == '&') {
                left = s.substring(0, i);
                right = s.substring(i + 1);
                result += waysFalse(left) * waysFalse(right) + waysTrue(left) * waysFalse(right) + waysFalse(left) * waysTrue(right);
            } else if (s.charAt(i) == '^') {
                left = s.substring(0, i);
                right = s.substring(i + 1);
                result += waysTrue(left) * waysTrue(right) + waysFalse(left) * waysFalse(right);
            }
            result %= 1003;
        }
        cacheFalse.put(s, result);
        System.out.println("s = " + s + ", result = " + result);
        return result % 1003;
    }

    public static void main(String[] args) {
        EvaluateExpressionToTrue ins = new EvaluateExpressionToTrue();
        int t1 = ins.cnttrue("T|F&T^T");
        int t2 = ins.cnttrue("T^T^T^F|F&F^F|T^F^T");
        System.out.println(t1);
        System.out.println(t2);
    }
}
