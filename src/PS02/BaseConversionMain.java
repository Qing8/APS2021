package PS02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BaseConversionMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        HashMap<Character, Integer> letter2Int = new HashMap<>();
        letter2Int.put('A', 10);
        letter2Int.put('B', 11);
        letter2Int.put('C', 12);
        letter2Int.put('D', 13);
        letter2Int.put('E', 14);
        letter2Int.put('F', 15);

        int oldBase = Integer.valueOf(inputs[0]);
        int newBase = Integer.valueOf(inputs[1]);
        String oldStr = inputs[2];
        int normalValue=0;
        long value = 0;
        for (int i=oldStr.length()-1; i>=0; i--) {
            if (Character.isLetter(oldStr.charAt(i))) {
                if (letter2Int.containsKey(oldStr.charAt(i))) {
                    normalValue = letter2Int.get(oldStr.charAt(i));
                } else {
                    System.out.print(oldStr + " is an illegal base " + oldBase + " number");
                    return;
                }
            } else {
                normalValue = Integer.valueOf(Character.toString(oldStr.charAt(i)));
            }

            if (normalValue >= oldBase) {
                System.out.print(oldStr + " is an illegal base " + oldBase + " number");
                return;
            }

            long temp = (long) Math.pow(oldBase, (-i + oldStr.length() - 1));
            value += temp * normalValue;

        }

        System.out.print(oldStr + " " + "base " + oldBase + " = " + toNewBase(value, newBase) + " base " + newBase);



//            if (letter2Int.containsKey(oldStr.charAt(i))){
//                normalValue = letter2Int.get(oldStr.charAt(i));
//            }else if(oldStr.charAt(i) == '-'){
//                System.out.print(oldStr + " is an illegal base " + oldBase + " number");
//                return;
//            }
//            else{
//                normalValue = Integer.valueOf(Character.toString(oldStr.charAt(i)));
//            }
//            if (normalValue>=oldBase){
//                // 126 is an illegal base 5 number
//                System.out.print(oldStr + " is an illegal base " + oldBase + " number");
//                return;
//            }
//            value += Math.pow(oldBase,(-i+oldStr.length()-1))*normalValue;
//
//        }
//
//        // A4C base 15 = 1821 base 11
//        System.out.print(oldStr + " " + "base " + oldBase + " = " + toNewBase(value, newBase) + " base " + newBase);


    }

    public static String toNewBase(long value, int newBase){
        HashMap<Integer, Character> int2Letter = new HashMap<>();
        int2Letter.put(10, 'A');
        int2Letter.put(11, 'B');
        int2Letter.put(12, 'C');
        int2Letter.put(13, 'D');
        int2Letter.put(14, 'E');
        int2Letter.put(15, 'F');

        String valueStr = "";
        while (value != 0){
            int remainder = (int) (value % newBase);
            if (remainder >= 10){
                valueStr = Character.toString(int2Letter.get(remainder)) + valueStr;
            }else{
                valueStr = String.valueOf(remainder) + valueStr;
            }
            value = value / newBase;
        }
        if (valueStr.isEmpty()){
            return "0";
        }
        return valueStr;
    }


}
