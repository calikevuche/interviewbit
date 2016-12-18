package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 28.11.2016.
 */
public class GrayCode {

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<String> grayCode = grayCodeInternal(a);
        for (String s: grayCode) {
            res.add(Integer.parseInt(s, 2));
        }
        return res;
    }

    public ArrayList<String> grayCodeInternal(int a) {
        if (a == 1) {
            return new ArrayList<String>(Arrays.asList("0","1"));
        }
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> list = grayCodeInternal(a-1);
        for (String s: list) {
            res.add("0"+s);
        }
        Collections.reverse(list);
        for (String s: list) {
            res.add("1"+s);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1001",2));
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(4));
    }
}
