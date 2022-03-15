import  java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int num1, num2, rez;
        boolean isRoman = true;
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] arrayStrings = toInputArray(input);
        num1 = romanToNumber(arrayStrings[0]);
        String operator = arrayStrings[1];
        num2 = romanToNumber(arrayStrings[2]);

        if((num1 == -1 && num2 != -1) || (num2 == -1 && num1 != -1)) {
            throw new Exception("Вы допустили ошибку, повторите ввод.");
        }

        if(num1 == -1 && num2 == -1) {
            try {
                isRoman = false;
                num1 = Integer.parseInt(arrayStrings[0]);
                num2 = Integer.parseInt(arrayStrings[2]);
            } catch (Exception e) {
                throw new Exception("Вы допустили ошибку, повторите ввод.");
            }
        }

        scanner.close();
        switch (operator) {
            case "\\+":
                rez = num1 + num2;
                convertResult(rez, isRoman);
                break;
            case "-":
                rez = num1 - num2;
                convertResult(rez, isRoman);
                break;
            case "\\*":
                rez = num1 * num2;
                convertResult(rez, isRoman);
                break;

            case "\\/":
                if (num2 != 0) {
                    rez = num1 / num2;
                    convertResult(rez, isRoman);
                } else
                    System.out.println("Деление на ноль невозможно.");
                break;
            default:
                System.out.printf("Вы допустили ошибку, повторите ввод.");

        }
    }

    private static void convertResult(int rez, boolean isRoman) {
        if(isRoman) {
            System.out.println(convertNumToRoman(rez));
        } else {
            System.out.println(rez);
        }
    }

    private static String[] toInputArray(String string) throws Exception {
        if(string.contains("+")) {
            return getArray(string, "\\+");
        } else if(string.contains("-")) {
            return getArray(string, "-");
        } else if(string.contains("*")) {
            return getArray(string, "\\*");
        } else if(string.contains("/")) {
            return getArray(string, "\\/");
        } else {
            throw new Exception("Неверный ввод данных.");
        }

    }

    private static String[] getArray(String string, String znak) throws Exception {
        String[] array = string.split(znak);
        if(array.length != 2) {
            throw new Exception("Неверный ввод данных.");
        }
        return new String[] {array[0].trim(), znak, array[1].trim()};
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат ввода данных.");
        }
        return -1;
    }

}
