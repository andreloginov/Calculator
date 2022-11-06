import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scanner.nextLine();
        calc(input);
    }
    public static void calc(String input) throws Exception {
        System.out.println("Input:");
        Calculate newCalc = new Calculate();
        System.out.println(newCalc.checkOperation1(input));
        newCalc.splitInput(input);

        int romanSum = newCalc.checkNumberSystem(newCalc.getNewInput());
        if (romanSum < 1) throw new Exception("т.к. в римской системе нет отрицательных чисел");
        try {
            if (newCalc.getNumberSystem().getName().equals("ROMAN")){
                StringBuilder translated = newCalc.split(romanSum);
                    System.out.println("Output:");
                    System.out.println(translated);
            }
            else{
                System.out.println("Output: ");
                System.out.println(romanSum);
            }
        }catch (NullPointerException e){
            throw new Exception("т.к используют одновременно разные системы счисления.");
        }
    }
}