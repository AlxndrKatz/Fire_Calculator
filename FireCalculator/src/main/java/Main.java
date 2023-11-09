import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int calcInput = scanner.nextInt() - 2002;

        if (InputCheck.check(calcInput)) {
            double result = Calculator.calculate(calcInput);
            System.out.println(result);
        }
    }
}
