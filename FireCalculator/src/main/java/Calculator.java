public class Calculator {
    public static double calculate(int calcInput) {
        int startWithdrawal = calcInput + 1;
        double annualWithdrawalPerCent = 0.5;
        double deposit = 1;
        double withdrawal;
        
        while (deposit > 0.0) {

            withdrawal = setWithdrawalLogic(deposit, annualWithdrawalPerCent);
            deposit = initializeDeposit(deposit, annualWithdrawalPerCent);

            for (int year = startWithdrawal; year < Constants.MOEX_RATE.length; year++) {

                withdrawal = yearSequenceWithdrawal(year, withdrawal);
                deposit = yearSequenceDeposit(year, deposit, withdrawal);

            }
            annualWithdrawalPerCent = adjustAnnualWithdrawalPerCent(annualWithdrawalPerCent, deposit);
        }
        return annualWithdrawalPerCent;
    }

    private static double adjustAnnualWithdrawalPerCent(double annualWithdrawalPerCent, double deposit) {

        double grade = 0.5;

        if (deposit > 0.0) {
            annualWithdrawalPerCent += grade;
        } else {
            annualWithdrawalPerCent -= grade;
        }
        return annualWithdrawalPerCent;
    }

    private static double initializeDeposit(double deposit, double annualWithdrawalPerCent) {

        double withdrawal = annualWithdrawalPerCent * deposit;
        deposit = (withdrawal * 100) / annualWithdrawalPerCent;// См П.4 Задания

        return deposit;
    }

    private static double setWithdrawalLogic(double deposit, double annualWithdrawalPerCent) {

        double withdrawal = annualWithdrawalPerCent * deposit;

        return withdrawal;
    }

    private static double yearSequenceDeposit(int year, double deposit, double withdrawal) {

        double deltaMoex = (Constants.MOEX_RATE[year] / Constants.MOEX_RATE[year - 1]);

        deposit -= withdrawal;
        deposit *= deltaMoex;

        return deposit;
    }

    private static double yearSequenceWithdrawal(int year, double withdrawal) {
        
        double percentage = 0.01;
        double inflation = (1 + (Constants.INFLATION_RATE[year] * percentage));
        withdrawal *= inflation;

        return withdrawal;
    }
}
