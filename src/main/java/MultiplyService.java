import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;

public class MultiplyService {

    public static String multiplyBigInteger(String val1, String val2) {
        BigInteger intVal1;
        BigInteger intVal2;

        try {
            intVal1 = new BigInteger(val1);
            intVal2 = new BigInteger(val2);
        } catch (NumberFormatException e) {
            return "Wrong input values";
        }

        return intVal1.multiply(intVal2).toString();
    }

    public static String trimMinus(String input) {
        if (input.charAt(0) == '-') {
            return input.substring(1);
        }

        return input;
    }

    public static boolean isResultPositive(String val1, String val2) {

        if (val1.charAt(0) == '-' && val2.charAt(0) == '-') {
            return true;
        }

        if (val1.charAt(0) != '-' && val2.charAt(0) != '-') {
            return true;
        }

        return false;
    }

    public static int[] getArrayFromString(String str) {
        int a[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            a[i] = str.charAt(i) - '0';
        }
        return a;
    }

    public static String multiplyNative(String val1, String val2) {

        if (!StringUtils.isNumeric(trimMinus(val1)) || !StringUtils.isNumeric(trimMinus(val2))) {
            return "Wrong input values";
        }

        if (val1.equals("0") || val2.equals("0")) {
            return "0";
        }

        boolean negative = false;

        if (!isResultPositive(val1, val2)) {
            negative = true;
        }

        val1 = trimMinus(val1);
        val2 = trimMinus(val2);

        int a[] = getArrayFromString(val1);
        int b[] = getArrayFromString(val2);
        int c[] = new int[a.length + b.length];

        for (int i = b.length - 1; i >= 0; i--) {
            for (int j = a.length - 1; j >= 0; j--) {
                c[i + j + 1] = c[i + j + 1] + a[j] * b[i];
            }
        }

        for (int i = c.length - 1; i > 0; i--) {
            c[i - 1] = c[i - 1] + c[i] / 10;
            c[i] = c[i] % 10;
        }

        String res = "";

        for (int i = 0; i < c.length; i++) {
            res = res + c[i];
        }

        res = res.charAt(0) == '0'
                ? res.substring(1)
                : res;

        return negative
                ? '-' + res
                : res;
    }

    public static void main(String[] args) {
        String inputAlgName = args[0];
        String str1 = args[1];
        String str2 = args[2];

        switch (inputAlgName) {
            case "alg1":
                System.out.println(multiplyNative(str1, str2));
                break;

            case "alg2":
                System.out.println(multiplyBigInteger(str1, str2));
                break;

            default:
                System.out.println("Unsupported value for algorithm name");

        }
    }

}

