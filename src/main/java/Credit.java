import java.util.Scanner;

public class Credit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please type your number: ");
        String input = scan.nextLine();
        Object checkDigit = input.substring(input.length() - 1);
        if (checkNumeric(input) && isValidLength(input, 16) && positiveNumber(input)) {
            System.out.println("Input: " + input.substring(0, input.length() - 1) + " " + checkDigit);
            System.out.println("Provided: " + checkDigit);
            String digit = checkDigit(input.substring(0, input.length() - 1));
            System.out.println("Expected: " + digit);
            System.out.println();

            if (luhn(input) == true)
                System.out.println("Checksum: Valid");
            else
                System.out.println("Checksum: Invalid");

            if (input.length() == 16) {
                System.out.println("Digits: " + input.length() + " (credit card)");
            } else
                System.out.println("Digits: " + input.length() + " (not credit card)");

        }
    }

    public static boolean luhn(String checkCard) {
        if (checkCard == null)
            return true;
        char checkDigit = checkCard.charAt(checkCard.length() - 1);
        String digit = checkDigit(checkCard.substring(0, checkCard.length() - 1));
        return checkDigit == digit.charAt(0);
    }

    public static String checkDigit(String checkCard) {
        if (checkCard == null)
            return null;
        String number;
        int[] numbers = new int[checkCard.length()];
        for (int i = 0; i < checkCard.length(); i++) {
            numbers[i] = Character.getNumericValue(checkCard.charAt(i));
        }
        for (int i = numbers.length - 1; i >= 0; i -= 2) {
            numbers[i] += numbers[i];

            if (numbers[i] >= 10) {
                numbers[i] = numbers[i] - 9;
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        sum = sum * 9;
        number = sum + "";
        return number.substring(number.length() - 1);
    }

    public static boolean checkNumeric(String input) {
        for (char symbol : input.toCharArray()) {
            try {

                if (!Character.isDigit(symbol)) {
                    System.out.println("Invalid input");
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidLength(String input, int length) {
        return input.length() == length;
    }

    public static boolean positiveNumber(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        if (str.charAt(0) == '-') {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            boolean nr = (c >= '0' && c <= '9');
            if (!nr) {
                return false;
            }
        }
        return true;

    }
}