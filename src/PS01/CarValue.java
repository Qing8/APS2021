package PS01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int duration = scanner.nextInt();
        double downPayment = scanner.nextDouble();
        double amountOfloan = scanner.nextDouble();
        int numDepre = scanner.nextInt();
        List<Double> deprecates = new ArrayList<>();

        CollectInfo(scanner, deprecates, numDepre, duration);
//        System.out.println(deprecates);

        int res = CalculateMonth(amountOfloan, duration, deprecates, downPayment);
        if (res == 1) {
            System.out.println("1 month");
        } else if (res == 0) {
            System.out.println("0 months");
        } else {
            System.out.println(res + " months");
        }

    }

    public static int CalculateMonth(double amountOfloan, int duration, List<Double> deprecates, double downPayment) {
        double paymentPerMonth;
        if (duration == 0){
            paymentPerMonth = amountOfloan;
        }else {
            paymentPerMonth = amountOfloan / duration;
        }
        double totalpayment = 0;
        double carValue = (amountOfloan + downPayment) * (1 - deprecates.get(0));
        int Month = 0;
        boolean first = true;
        double middleRes;
        if (amountOfloan - totalpayment < carValue) {
            return 0;
        }
        while (first || (middleRes = amountOfloan - totalpayment) >= carValue) {
            Month++;
            if (Month == 100){
                break;
            }
            totalpayment += paymentPerMonth;
            carValue = carValue * (1 - deprecates.get(Month));

            first = false;
        }
        return Month;
    }

    public static void CollectInfo(Scanner scanner, List<Double> deprecates, int numDepre, int duration) {
        for (int i = 0; i < numDepre; i++) {
            int IndexMonth = scanner.nextInt();
            while (IndexMonth > deprecates.size()) {
                deprecates.add(deprecates.get(deprecates.size() - 1));
            }
            deprecates.add(scanner.nextDouble());
        }
        double lastRate = deprecates.get(deprecates.size() - 1);
        while (deprecates.size() < duration) {
            deprecates.add(lastRate);
        }
    }
}
