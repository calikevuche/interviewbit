package Strings;

/**
 * Created by OlehKa on 01.08.2016.
 */
public class IntegerToRoman {

    public String intToRomanV1(int a) {
        StringBuilder result = new StringBuilder();
        while (a > 0) {
            if (a - 1000 >= 0) {
                result.append("M");
                a -= 1000;
            } else if (a - 900 >= 0) {
                result.append("CM");
                a -= 900;
            } else if (a - 500 >= 0) {
                result.append("D");
                a -= 500;
            } else if (a - 400 >= 0) {
                result.append("CD");
                a -= 400;
            } else if (a - 100 >= 0) {
                result.append("C");
                a -= 100;
            } else if (a - 90 >= 0) {
                result.append("XC");
                a -= 90;
            } else if (a - 50 >= 0) {
                result.append("L");
                a -= 50;
            } else if (a - 40 >= 0) {
                result.append("XL");
                a -= 40;
            } else if (a - 10 >= 0) {
                result.append("X");
                a -= 10;
            } else if (a - 9 >= 0) {
                result.append("IX");
                a -= 9;
            } else if (a - 5 >= 0) {
                result.append("V");
                a -= 5;
            } else if (a - 4 >= 0) {
                result.append("IV");
                a -= 4;
            } else if (a - 1 >= 0) {
                result.append("I");
                a -= 1;
            }
        }
        return result.toString();
    }

    public String intToRomanV2(int a) {
        int i = 0;
        int[] ar = new int[4];
        while (i < ar.length && a > 0) {
            ar[ar.length - 1 - i] = a % 10;
            a = a / 10;
            i++;
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < ar.length; j++) {
            int shift = ar.length - 1 - j;
            while (ar[j] > 0) {
                if (ar[j] == 4 || ar[j] == 9) {
                    result.append(getRoman(ar[j], shift));
                    ar[j] -= ar[j];
                } else if (ar[j] >= 5) {
                    result.append(getRoman(5, shift));
                    ar[j] -= 5;
                } else {
                    result.append(getRoman(1, shift));
                    ar[j] -= 1;
                }
            }
        }
        return result.toString();
    }

    private String getRoman(int i, int shift) {
        switch (i) {
            case 4:
                if (shift == 0) {
                    return "IV";
                } else if (shift == 1) {
                    return "XL";
                } else if (shift == 2) {
                    return "CD";
                } else {
                    return "";
                }
            case 9:
                if (shift == 0) {
                    return "IX";
                } else if (shift == 1) {
                    return "XC";
                } else if (shift == 2) {
                    return "CM";
                } else {
                    return "";
                }
            case 5:
                if (shift == 0) {
                    return "V";
                } else if (shift == 1) {
                    return "L";
                } else if (shift == 2) {
                    return "D";
                } else {
                    return "";
                }
            case 1:
                if (shift == 0) {
                    return "I";
                } else if (shift == 1) {
                    return "X";
                } else if (shift == 2) {
                    return "C";
                } else if (shift == 3) {
                    return "M";
                } else {
                    return "";
                }
        }
        return "";
    }

    public String intToRomanV3(int n) {
        if (n < 1 || n > 3999) {
            return "";
        }
        String[] a1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] a2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] a3 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] a4 = {"", "M", "MM", "MMM"};
        return a4[n / 1000] + a3[(n / 100) % 10] + a2[(n / 10) % 10] + a1[n % 10];
    }

    public String intToRomanV4(int n) {
        int []arr= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]s={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            while(n>=arr[i]){
                n=n-arr[i];
                ans.append(s[i]);
            }
            if(n==0)
                break;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman instance = new IntegerToRoman();
        System.out.println(instance.intToRomanV4(1444));
        System.out.println(instance.intToRomanV4(1789));
        System.out.println(instance.intToRomanV4(1555));
        System.out.println(instance.intToRomanV4(1553));
    }
}
