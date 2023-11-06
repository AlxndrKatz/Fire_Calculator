public class Calculator {
    public static double calculate(int calcInput) {
        int year = calcInput - 2002;
        double annualWithdrawalPerCent = 0.5;
        double deltaMoex;
        double deposit = 1;
        double withDrawal;

        while (deposit > 0.0) {

            deposit = 100;
            withDrawal = annualWithdrawalPerCent * deposit;
            deposit = (withDrawal * 100) / annualWithdrawalPerCent;// См П.4 Задания
            deposit = deposit - withDrawal;

            for (int i = year + 1; i < 21; i++) {

                if (annualWithdrawalPerCent * deposit / 100 * (1 + (Constants.INFLATION_RATE[i] / 100)) >
                        (withDrawal * (1 + Constants.INFLATION_RATE[i] / 100))) {
                    withDrawal = annualWithdrawalPerCent * deposit/ 100  * (1 + Constants.INFLATION_RATE[i] / 100);
                } else {
                    withDrawal = withDrawal * (1 + Constants.INFLATION_RATE[i] / 100);
                }

                deposit = deposit - withDrawal;
                deltaMoex = (Constants.MOEX_RATE[i] / Constants.MOEX_RATE[i - 1]);
                deposit = deposit * deltaMoex;

            }
            if (deposit > 0.0) {
                annualWithdrawalPerCent += 0.5;
            } else {
                annualWithdrawalPerCent -= 0.5;
            }
        }
        return annualWithdrawalPerCent;
    }
}

