package PS02;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.InflaterOutputStream;

public class EndianMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(bf.readLine());
        int last8BitMask = 0xff;

        short[] tempShort = new short[4];
        for (int b = 0; b < 4; b++) {
            tempShort[b] = (short)(inputNum>>(8*b) & last8BitMask);
        }
        int curVal = convToInt(tempShort);
        System.out.print(inputNum + " converts to " + curVal);
    }

    public static int convToInt(short[] sb){
        int answer = sb[3];
        answer += sb[2] << 8;
        answer += sb[1] << 16;
        answer += sb[0] << 24;
        return answer;
    }
}
