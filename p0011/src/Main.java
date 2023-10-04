
import java.math.BigInteger;

public class Main {

//    2 -> 10
    public String binaryToDecimal(String binary) {
        return anyToDecimal(binary, 2);
    }

//    2 -> 16
    public String binaryToHexa(String binary) {
        String hexa = anyToDecimal(binary, 2);
        return decimalToAny(hexa, 16);
    }

//    10 -> 2
    public String decimalToBinary(String decimal) {
        return decimalToAny(decimal, 2);
    }

//    10 -> 16
    public String decimalToHexa(String decimal) {
        return decimalToAny(decimal, 16);
    }

//    16 -> 2
    public String hexaToBinary(String hexa) {
        String binary = anyToDecimal(hexa, 16);
        return decimalToAny(binary, 2);
    }

//    16 -> 10
    public String hexaToDecimal(String hexa) {
        return anyToDecimal(hexa, 16);
    }

//    any base to 10
    public String anyToDecimal(String value, int base) {
        BigInteger decimal = BigInteger.ZERO;
        BigInteger power = BigInteger.ONE;

        for (int i = value.length() - 1; i >= 0; i--) {
            int digit = Character.digit(value.charAt(i), base);
            decimal = decimal.add(BigInteger.valueOf(digit).multiply(power));
            power = power.multiply(BigInteger.valueOf(base));
        }
        return decimal.toString();
    }

//    10 to any base
    public String decimalToAny(String value, int base) {
        if (equalZero(value)) {
            return "0";
        }
        BigInteger decimal = new BigInteger(value);
        StringBuilder result = new StringBuilder();

        while (decimal.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = decimal.mod(BigInteger.valueOf(base));
            result.append(Character.forDigit(remainder.intValue(), base));
            decimal = decimal.divide(BigInteger.valueOf(base));
        }

        return result.reverse().toString().toUpperCase();
    }

    public boolean equalZero(String value) {
        if (value.equals("0")) {
            return true;
        }
        return false;
    }

//    display menu for convert from binary
    public void displayConvertBinary() {
        System.out.println("Choose the base number out: \t1.Decimal\t2.Hexadecimal");
        int choice = Validation.intputInteger("Enter your choice: ", 1, 2);
        String binary = Validation.inputBinary();
        switch (choice) {
            case 1:
                System.out.println("Result Decimal: " + binaryToDecimal(binary));
                break;
            case 2:
                System.out.println("Result Hexadecimal: " + binaryToHexa(binary));
                break;
        }
    }

    //    display menu for convert from decimal
    public void displayConvertDecimal() {
        System.out.println("Choose the base number out: \t1.Binary\t2.Hexadecimal");
        int choice = Validation.intputInteger("Enter your choice: ", 1, 2);
        String decimal = Validation.inputDecimal();
        switch (choice) {
            case 1:
                System.out.println("Result Binary: " + decimalToBinary(decimal));
                break;
            case 2:
                System.out.println("Result Hexadecimal: " + decimalToHexa(decimal));
                break;
        }
    }

//    display menu for convert from hexadecimal
    public void displayConvertHexa() {
        System.out.println("Choose the base number out: \t1.Binary\t2.Decimal");
        int choice = Validation.intputInteger("Enter your choice: ", 1, 2);
        String hexa = Validation.inputHexa();
        switch (choice) {
            case 1:
                System.out.println("Result Binary: " + hexaToBinary(hexa));
                break;
            case 2:
                System.out.println("Result Decimal: " + hexaToDecimal(hexa));
                break;
        }
    }

    public void menu() {
        int choice;
        while (true) {
            System.out.println("Change base number system");
            System.out.println("1. Convert Binary");
            System.out.println("2. Convert Decimal");
            System.out.println("3. Convert Hexadecimal");
            System.out.println("4. Exit");
            choice = Validation.intputInteger("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    displayConvertBinary();
                    break;
                case 2:
                    displayConvertDecimal();
                    break;
                case 3:
                    displayConvertHexa();
                    break;
                case 4:
                    System.out.println("Exit program");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }
}
