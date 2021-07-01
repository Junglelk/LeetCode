package other;

import java.math.BigInteger;
import java.util.Scanner;

public class LongLongInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        BigInteger bnum1 = new BigInteger(num1);
        BigInteger bnum2 = new BigInteger(num2);
        System.out.println(bnum1.subtract(bnum2));
    }
}
