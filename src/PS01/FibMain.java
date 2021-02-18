import java.math.BigInteger;
import java.util.Scanner;

public class FibMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (N==1){
            System.out.println(0);
            return;
        }
        if (N==2){
            System.out.println(1);
            return;
        }
        BigInteger fib1 = new BigInteger("0");
        BigInteger fib2 = new BigInteger("1");
        BigInteger temp;
        for (int i=2; i<N; i++){
            temp = fib2;
            fib2 = fib2.add(fib1);
            fib1 = temp;
        }
        System.out.println(fib2);
    }
}
