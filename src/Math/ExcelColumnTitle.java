package Math;

/**
 * Created by OlehKa on 21.06.2016.
 */
public class ExcelColumnTitle {

    //    1 -> A
    //    2 -> B
    //    3 -> C
    //    ...
    //    26 -> Z
    //    27 -> AA
    //    28 -> AB

    public String convertToTitle(int a) {
        String result = "";
        int base = 26;
        while (a > 0) {
            int value = a % base;
            if (value == 0) {
                value = base;
                a -= value;
            }
            result = (char) ('A' + value - 1) + result;
            a = a / base;
        }
        return result;
    }

    public String convertToTitle2(int a) {
        String result = "";
        while (a > 0) {
            result = (char) ((a - 1) % 26 + 'A') + result;
            a = (a - 1) / 26;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelColumnTitle instance = new ExcelColumnTitle();
        System.out.println(instance.convertToTitle(937361));
        System.out.println(instance.convertToTitle(676));
        System.out.println(instance.convertToTitle(731));
        System.out.println(instance.convertToTitle(53));
        System.out.println(instance.convertToTitle(52));
        System.out.println(instance.convertToTitle(26));
    }
}
