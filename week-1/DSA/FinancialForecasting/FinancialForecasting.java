public class FinancialForecasting {
    public static double forecast(double currentValue, double growthRate, int steps) {
        if (steps == 0) {
            return currentValue;
        }
        return forecast(currentValue * (1 + growthRate), growthRate, steps - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int steps = 5;

        System.out.println("Forecasted value after " + steps + " steps: " + forecast(initialValue, growthRate, steps));
    }
}
