import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class RotateRodMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.valueOf(scanner.nextLine());
        HashMap<String, HashMap<String, String>> rules = new HashMap<>();
        String op1 = "+x";
        String[] ops = scanner.nextLine().split(" ");

        for (String op2: ops){
            if (op2.equals("No")){
                continue;
            }
            String res = AddRules(op2, op1);
            op1 = res;
        }
        System.out.print(op1);
    }

    public static String AddRules(String ele1, String ele2) {
        if (ele1.equals("+y")) {
            switch (ele2) {
                case "+x":
                    return "+y";
                case "-x":
                    return "-y";
                case "+y":
                    return "-x";
                case "-y":
                    return "+x";
                default:
                    return ele2;
            }
        } else if (ele1.equals("-y")) {
            switch (ele2) {
                case "+x":
                    return "-y";
                case "-x":
                    return "+y";
                case "+y":
                    return "+x";
                case "-y":
                    return "-x";
                default:
                    return ele2;
            }
        } else if (ele1.equals("+z")) {
            switch (ele2) {
                case "+x":
                    return "+z";
                case "-x":
                    return "-z";
                case "+z":
                    return "-x";
                case "-z":
                    return "+x";
                default:
                    return ele2;
            }
        } else{ // "-z"
            switch (ele2) {
                case "+x":
                    return "-z";
                case "-x":
                    return "+z";
                case "+z":
                    return "+x";
                case "-z":
                    return "-x";
                default:
                    return ele2;
            }
        }
    }}

