package Recitation01;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SplitBinaryMain {
    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()){

            int number = scanner.nextInt();
            if (number == 0){
                break;
            }
            String binaryStr = Decimal2BinaryStr(number);

            String[] twoStr = Split2String(binaryStr);
            int[] integers = new int[twoStr.length];
            for (int i=0; i<twoStr.length; i++){
                integers[i] = Binary2Int(twoStr[i]);
            }
            System.out.println(integers[0] + " " + integers[1]);
        }



    }

    public static int Binary2Int(String binaryStr){
        int binaryNum = Integer.valueOf(binaryStr);
        int decimalNum = 0;
        int exp = 0;
        while (binaryNum != 0){
            int on = binaryNum%10;
            decimalNum += Math.pow(2, exp) * on;
            binaryNum /= 10;
            exp++;
        }
        return decimalNum;
    }

    public static String[] Split2String(String binaryStr){
        int counter = 0;
        String strA = "";
        String strB = "";
        for (int i=binaryStr.length()-1; i>=0; i--) {
            if (binaryStr.charAt(i) == '1') {
                counter++;
                if (counter % 2 == 1) {
                    strA = "1" + strA;
                    strB = "0" + strB;
                } else {
                    strB = "1" + strB;
                    strA = "0" + strA;
                }
            }else{
                strA = "0" + strA;
                strB = "0" + strB;
            }
        }
        return new String[]{strA, strB};
    }

    public static String Decimal2BinaryStr(int number){
        String binaryNum = "";
        while (number != 0) {
            int remainder = number % 2;
            binaryNum = String.valueOf(remainder) + binaryNum;
            number = number / 2;
        }
        return binaryNum;
    }
}
