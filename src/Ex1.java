
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        // add your code here
        if (!isNumber(num)) {
            return ans;
        }
        int currentSum = 0;
        String str = "ABCDEFG";
        int base1;
        char base = num.charAt(num.length() - 1);
        if (str.contains(String.valueOf(base))) {
            base1 = str.indexOf(base) + 10;
        } else {
            base1 = Character.getNumericValue(base);
        }
        for (int i = 0; i < num.length() - 2; i++) {
            char current = num.charAt(i);
            int currentNum = Character.getNumericValue(current);
            int pow = (int) Math.pow(base1, num.length() - 3 - i);
            int currentInd = currentNum * pow;
            currentSum = currentSum + currentInd;
        }
        ans = currentSum;
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        // add your code here
        String validChar = "0123456789ABCDEFG";
        String num = "0123456789";
        char lastChar = a.charAt(a.length() - 1);

        if (a.length() < 2 && num.contains(String.valueOf(lastChar))) {
            return true;
        } else if (a.length() < 2) {
            return false;
        }
        char secondToLest = a.charAt(a.length() - 2);
        if ((lastChar == '0' || lastChar == '1') && secondToLest == 'b') {
            return false;
        }
        char firstChar = a.charAt(0);
        if (firstChar == 'b' || firstChar == ' ') {
            return false;
        }
        if (!num.contains(String.valueOf(lastChar)) && secondToLest != 'b') {
            return false;
        }
        int index = -1;
        if (secondToLest == 'b') {
            index = validChar.indexOf(lastChar);
        } else {
            index = 11;
        }
        int indexOf2 = a.length() - 2;
        String currentString = validChar.substring(0, index);
        String currentString2 = a.substring(0, indexOf2);
        for (int j = 0; j < currentString2.length(); j++) {
            char currant = a.charAt(j);
            if (!currentString.contains(String.valueOf(currant))) {
                ans = false;
            }
        }
        ////////////////////
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        String numStr = String.valueOf(num);
        String abStr = "ABCDEFG";
        String big = "";
        if (isNumber(numStr) && 2 <= base && base <= 16) {
            int cNum = num;
            String currentString = "";
            while (cNum != 0) {
                int remainder = cNum % base;// חשב את השארית
                if (remainder > 9) {
                    int indBig = remainder - 10;
                    big = String.valueOf(abStr.charAt(indBig));
                } else {
                    big = String.valueOf(remainder);
                }

                currentString = big + currentString; //הוסף את הספרה המתאימה
                cNum /= base; // חלק את המספר בבסיס

            }
            char base2 = ' ';
            if (base >= 10) {
                int indB = base - 10;
                base2 = abStr.charAt(indB);
            } else {
                base2 = (char) ('0' + base);
            }
            ans = currentString + "b" + base2;
        }
        ////////////////////
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        int n1d = number2Int(n1);
        int n2d = number2Int(n2);
        String n1ds = String.valueOf(n1d);
        String n2ds = String.valueOf(n2d);
        for (int i = 0; i < n1ds.length() - 1; i++) {
            if (n1ds.charAt(i) != n2ds.charAt(i)) {
                ans = false;
            }
        }
        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here
        int maxInd = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int currentValue = Integer.parseInt(arr[i]);
            if (currentValue >= maxValue) {
                maxValue = currentValue;
                maxInd = i;
            }
        }
        ans = maxInd;
        ////////////////////
        return ans;
    }
}
/*
 String ans = "";
        // add your code here
        int cNum = num;
        int currentM;
        int sum = 0;
        int k = String.valueOf(num).length();
        while (cNum != 0) {
            for (int i = 0; i <= k; i++) {
                currentM = cNum % 10;
                sum = sum + (int) Math.pow(currentM, i);
            }
        }
         String validChar = "123456789";
        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);
            if (!validChar.contains(String.valueOf(current))) {
                ans = -1;
            } else
                ans = Integer.parseInt(num);
        }
 */
