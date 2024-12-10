
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit", base = "";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                // add your code here

                System.out.println("num1=" + num1 + " is number:" + Ex1.isNumber(num1) + ",value:" + Ex1.number2Int(num1));
                if (!Ex1.isNumber(num1)) {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                    continue;
                }
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                if (!num1.equals("quit")) {
                    System.out.println("num2=" + num2 + " is number:" + Ex1.isNumber(num2) + ",value:" + Ex1.number2Int(num2));
                    if (!Ex1.isNumber(num2)) {
                        System.out.println("ERR: num1 is in the wrong format! (" + num2 + ")");
                        continue;
                    }
                    System.out.println("Enter a base for output: (a number [2,16] ");
                    base = sc.next();
                    int num1I = Ex1.number2Int(num1);
                    int num2I = Ex1.number2Int(num2);
                    int baseI = Integer.parseInt(base);
                    int sum = num1I + num2I;
                    int mul = num1I * num2I;
                    String mulStr = Ex1.int2Number(mul, baseI);
                    String sumStr = Ex1.int2Number(sum, baseI);
                    System.out.println(num1 + "+" + num2 + "=" + sumStr);
                    System.out.println(num1 + "*" + num2 + "=" + mulStr);
                    String[] arr = {num1, num2, sumStr, mulStr};
                    int maxInd = Ex1.maxIndex(arr);
                    System.out.println("Max number over [" + num1 + ", " + num2 + ", " + sumStr + ", " + mulStr + "] is:" + arr[maxInd]);
                    continue;
                }


                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}
