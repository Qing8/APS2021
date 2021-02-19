import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
//[1,-2,-3,1,3,-2,null,-1]
//        -1
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nodes = bf.readLine().split(" ");


    }

    public static boolean isNumeric(String inputString) {
        return inputString.matches("\\d+");
    }
}
