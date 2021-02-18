package PS01.add;

import java.math.BigInteger;
import java.util.Scanner;

public class AddMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BigInteger num1 = scanner.nextBigInteger();
        BigInteger num2 = scanner.nextBigInteger();
        System.out.println(num1.add(num2));
    }


}
