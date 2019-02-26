package DynamicProgramming;

public class WaysToDecode {

    public int numDecodings(String input) {
        if (input.length() == 0 || input.length() == 1 && input.charAt(0) == '0') {
            return 0;
        }
        if (input.length() == 1) {
            return 1;
        }

        int[] cache = new int[input.length()];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = 0;
        }
        return numDecodings(input, cache, 0);
    }

    private int numDecodings(String input, int[] cache, int startIndex) {
        if (startIndex == input.length()) {
            return 1;
        }

        if (cache[startIndex] != 0) {
            return cache[startIndex];
        }
        int result = 0;
        int cur = input.charAt(startIndex);
        int next = startIndex < input.length() - 1 ? input.charAt(startIndex + 1) : -1;
        if (cur != '0') {
            result += numDecodings(input, cache, startIndex + 1);
        }
        if ((cur == '1' && next != -1) || (cur == '2' && next >= '0' && next <= '6')) {
            result += numDecodings(input, cache, startIndex + 2);
        }
        cache[startIndex] = result;
        return result;
    }

    public static void main(String[] args) {
        WaysToDecode ins = new WaysToDecode();
//        int res = ins.numDecodings("1123");
        int res = ins.numDecodings("875361268549483279131");
        System.out.println(res);
    }
}
