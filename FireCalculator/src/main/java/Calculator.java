public class Calculator {
    public static double calculate(int calcInput) {
        int year = calcInput;
        double annualWithdrawalPerCent = 0.5;
        double grade = 0.5;
        double deltaMoex;
        double deposit = 1;
        double withDrawal;

        while (deposit > 0.0) {

            deposit = 1;
            withDrawal = annualWithdrawalPerCent * deposit;
            deposit = (withDrawal * 100) / annualWithdrawalPerCent;// См П.4 Задания

            for (int i = year + 1; i < 21; i++) {
                double inflation = (1 + Constants.INFLATION_RATE[i] / 100);

                withDrawal *= inflation;
                deposit -= withDrawal;
                deltaMoex = (Constants.MOEX_RATE[i] / Constants.MOEX_RATE[i - 1]);
                deposit *= deltaMoex;
            }
            if (deposit > 0.0) {
                annualWithdrawalPerCent += grade;
            } else {
                annualWithdrawalPerCent -= grade;
            }
        }
        return annualWithdrawalPerCent;
    }
}
