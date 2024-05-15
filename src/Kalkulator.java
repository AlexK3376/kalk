import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();

        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            throw new IllegalArgumentException("Некорректное выражение: не найдена операция");

        }
        String[] data = exp.split(regexActions[actionIndex]);
        if (data.length != 2) {
            throw new IllegalArgumentException("Некорректное выражение: должна быть ровно одна операция");

        }

        if (converter.isRoman(data[0]) != converter.isRoman(data[1])) {
            System.out.println("Числа должны быть в одном формате");
            return;
        }

            int a, b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
if (a>9 || b>9){
    throw new IllegalArgumentException("Вводимые числа должны быть меньше 10");

}


            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman) {

                    String romanResult = converter.intToRoman(result);
                if (romanResult.equals(Converter.NEGATIVE_RESULT)) {
                    throw new IllegalArgumentException("В римской системе чисел нет отрицательных чисел");

                    }
                    System.out.println(romanResult);
                } else {
                    System.out.println(result);


                }
            }
        }



