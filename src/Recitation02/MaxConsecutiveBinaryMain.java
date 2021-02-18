package Recitation02;

import java.util.Scanner;

public class MaxConsecutiveBinaryMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String numStr = Integer.toBinaryString(number);
        int curLen = 0;
        int maxLen = 0;

        while(number != 0){
            if((number & 1) == 1){
                curLen++;
            }else if ((number & 1) == 0){
                curLen = 0;
            }
            maxLen = Math.max(curLen, maxLen);
            number = number>>1;
        }
        System.out.print(maxLen);
    }
}
