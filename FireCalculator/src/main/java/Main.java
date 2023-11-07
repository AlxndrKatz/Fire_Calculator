import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int calcInput = scanner.nextInt();

        if (InputCheck.check(calcInput)) {
            double result = Calculator.calculate(calcInput-2002);
            System.out.println(result);
        }
    }
}
