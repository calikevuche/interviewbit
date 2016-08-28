package Math;

/**
 * Created by OlehKa on 12.06.2016.
 */
public class BinaryRepresentation {

    public String findDigitsInBinary(int a) {
        if (a == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (a > 0) {
            int reminder = a % 2;
            result.append(reminder);
            a /= 2;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        BinaryRepresentation instance = new BinaryRepresentation();
        System.out.println(instance.findDigitsInBinary(6));
    }
}
