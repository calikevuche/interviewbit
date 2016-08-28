package Math;

/**
 * Created by OlehKa on 18.06.2016.
 */
public class ExcelColumnNumber {

    public int titleToNumber(String a) {
        int result = 0;
        int base = 26;
        char[] array = a.toUpperCase().toCharArray();

        for (int i = 0; i < array.length; i++) {
//            char c = array[array.length-1-i];
//            int koef = (c % 'A')+1;
//            result += koef * Math.pow(base, i);
            result = result * base + (array[i] - 'A' + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        ExcelColumnNumber instance = new ExcelColumnNumber();
        System.out.println(instance.titleToNumber("BAHPI"));
    }
}
