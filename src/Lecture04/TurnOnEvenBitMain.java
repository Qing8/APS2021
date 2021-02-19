package Lecture04;

public class TurnOnEvenBitMain {
    public static void main(String[] main){
        int deltaBit = 1;
        int evenBitNumber = 0;
        for(; deltaBit<32; deltaBit+=2){
            evenBitNumber = evenBitNumber | (1 << deltaBit);
            System.out.println("evenBitNumber: " + Integer.toBinaryString(evenBitNumber));
        }
    }
}
