public class Calculator {


    public static double calculate(int calcInput) {
        int year = calcInput;
        double annualWithdrawalPerCent = 0.5;
        double grade = 0.5;
        double deltaMoex;
        double deposit = 1;
        double withdrawal;
        double percentage = 0.01;
        double inflation;



        while (deposit > 0.0) {

            deposit = setDepositDefault();
            withdrawal = setWithDrawalLogic(deposit, annualWithdrawalPerCent);
            deposit = initializeDeposit(deposit, annualWithdrawalPerCent);

            for (int i = year + 1; i < 21; i++) {

                inflation = (1 + (Constants.INFLATION_RATE[i]*percentage));
                deltaMoex = (Constants.MOEX_RATE[i] / Constants.MOEX_RATE[i - 1]);

                withdrawal = applyInflation(withdrawal, inflation);
                deposit = applyAnnualWithdrawal(deposit, withdrawal);
                deposit = applyDeltaMoex(deposit, deltaMoex);
            }

            annualWithdrawalPerCent = adjustAnnualWithdrawalPerCent(annualWithdrawalPerCent,deposit, grade);

        }
        return annualWithdrawalPerCent;
    }

    private static double adjustAnnualWithdrawalPerCent(double annualWithdrawalPerCent, double deposit, double grade){
        if (deposit > 0.0) {
            annualWithdrawalPerCent += grade;
        } else {
            annualWithdrawalPerCent -= grade;
        }
        return annualWithdrawalPerCent;
    }

    private static double initializeDeposit(double deposit, double annualWithdrawalPerCent) {
        double withDrawal = annualWithdrawalPerCent * deposit;
        deposit = (withDrawal * 100) / annualWithdrawalPerCent;// См П.4 Задания

        return deposit;
    }

    private static double setDepositDefault() {
        double deposit = 1;
        return deposit;
    }

    private static double applyDeltaMoex (double deltaMoex, double deposit) {
        deposit *= deltaMoex;
        return deposit;
    }

    private static double applyAnnualWithdrawal(double deposit, double withdrawal) {
        deposit -= withdrawal;
        return deposit;
    }

    private static double applyInflation (double withdrawal, double inflation) {
        withdrawal *= inflation;
        return withdrawal;
    }

    private static double setWithDrawalLogic(double deposit, double annualWithdrawalPerCent) {
        double withdrawal = annualWithdrawalPerCent * deposit;
        return withdrawal;
    }
}
