public class Calculate {
    private String operation1;
    private String[] newInput;
    private NumberSystem numberSystem = NumberSystem.ARABIC;

    //.............check how more operation in String input and return a symbol of operation......//
    public int checkOperation1(String input) throws Exception{
        final String[] valueOperations = {"+", "-", "*", "/"};
        int count = 0;
        for (String operation : valueOperations){
            for (String charInput : input.split("")){
                if (operation.equals(charInput)){
                    count++;
                    if (count==1) this.operation1 = operation;
                    else throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
            }
        }
        return 0;
    }
//............................................................................................//

    //..............split the String input-line on two line. Return Str[] array...................//
    public void splitInput(String input) throws Exception {
        String [] splitInput = input.split("\\%s".formatted(operation1));
        for (String split : splitInput){
            try {
                if (Integer.parseInt(split) == 0 || Integer.parseInt(split) > 10) {
                    throw new Exception("т.к. число равно нулю или более 10");
                }
            } catch (NumberFormatException ignored){

            }
        }
        this.newInput = splitInput;
    }
//...........................................................................................//

    //....................Check the Input[] array. Is it Arabic or Roman numeral? and get sum....//
    public int checkNumberSystem(String [] arrayInput) throws Exception {
        int[] numbers = new int[arrayInput.length];
        for (int i = 0; i<arrayInput.length; i++){
            RomanToArabic translate = RomanToArabic.I;
            numbers[i] = translate.toArabic(arrayInput[i]);
        }
        //....check system....
        if (numbers[0]!=0 && numbers[1]!=0){
            this.numberSystem = NumberSystem.ROMAN;
            for (int number : numbers)
                if (number > 10 || number < 1) throw new Exception("т.к. нарушено условие: от 1 до 10.");
        }
        //..........................................
        else if (numbers[0]==0 && numbers[1]==0){
            //.........т.к. проверка в Enum вернула 0 в массивы, проходимся и возврщааем значения введеные изначально....
            for (int i = 0; i< arrayInput.length; i++) {
                try {
                    numbers[i] = Integer.parseInt(arrayInput[i]);
                    this.numberSystem = NumberSystem.ARABIC;
                }catch (NumberFormatException e){
                    throw new Exception("т.к. не сходится с условиями задачи.");
                }
            }
        }
        else throw new Exception("т.к используют одновременно разные системы счисления.");
        for (int number : numbers) {
            try {
                if (number == 0 || number > 10) throw new Exception("т.к. число равно нулю или более 10");
            } catch (Exception ignored){}
        }
        //....get sum of numbers.length....
        return switch (operation1) {
            case "+" -> numbers[0] + numbers[1];
            case "-" -> numbers[0] - numbers[1];
            case "*" -> numbers[0] * numbers[1];
            case "/" -> numbers[0] / numbers[1];
            default -> throw new IllegalStateException("Unexpected value: " + operation1);
        };

    }
    //...........................................................................................//
    public StringBuilder split(int arabicSum) {
        StringBuilder translated = new StringBuilder();
        RomanToArabic arabToRom = RomanToArabic.I;
        //.....................деление по цифрам и округление их для поиска в ENUM, после - добвление в строку...
        if (arabicSum%10 != 0 || arabicSum>10){
            int a = 10;
            while (arabicSum >= a){
                a *=10;
            }
            a = a/10;
            int remain = arabicSum%a;
            arabicSum -= remain;

            translated.append(arabToRom.toRoman(arabicSum));
            if (remain == 0) return translated;

            return translated.append(split(remain));
        }
        else return translated.append(arabToRom.toRoman(arabicSum));

    }


    //...getter's
    public String[] getNewInput(){
        return this.newInput;
    }
    public NumberSystem getNumberSystem(){
        return numberSystem;
    }
}
