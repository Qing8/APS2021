package PS02;

import java.util.Scanner;

public class NegaBinaryMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long mask = 0xAAAAAAAA;
        System.out.print(Integer.toBinaryString((int)((number+mask)^mask)));
    }
}
