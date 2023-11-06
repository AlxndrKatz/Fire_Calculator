public class InputCheck{
    public static boolean check(int calcInput) throws Exception {
        checkInput(calcInput);
        return true;
    }
    private static void checkInput (int calcInput) throws Exception{
        if (calcInput > 2021 || calcInput < 2002) {
            throw new Exception("Exception 'Input is beyond range'");
        }
    }
}
