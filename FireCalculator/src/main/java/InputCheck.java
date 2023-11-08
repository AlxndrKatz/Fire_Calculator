public class InputCheck{
    public static boolean check(int calcInput) throws Exception {
        checkInput(calcInput);
        return true;
    }
    private static void checkInput (int calcInput) throws Exception{
        if (calcInput > 19 || calcInput < 0) {
            throw new Exception("Exception 'Input is beyond range'");
        }
    }
}
