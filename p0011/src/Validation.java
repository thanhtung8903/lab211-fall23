import java.util.Scanner;

public class Validation {
    private static final Scanner sc = new Scanner(System.in);
    
    public static int intputInteger(String msg, int min, int max) {
        int n;
        while (true) {
            System.out.print(msg);
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, try again");
            }
        }
    }
    
    public static String inputBinary() {
        String binary;
        while (true) {
            System.out.print("Enter Binary: ");
            binary = sc.nextLine().trim();
            if (binary.matches("[0-1]*")) {
                return binary;
            }
            System.err.println("Invalid, try again");
        }
    }
    
    public static String inputDecimal() {
        String decimal;
        while (true) {
            System.out.print("Enter Decimal: ");
            decimal = sc.nextLine().trim();
            if (decimal.matches("[0-9]*")) {
                return decimal;
            }
            System.err.println("Invalid, try again");
        }
    }
    
     public static String inputHexa() {
        String hexa;
        while (true) {
            System.out.print("Enter Hexadecimal: ");
            hexa = sc.nextLine().trim();
            if (hexa.matches("[0-9A-Fa-f]*")) {
                return hexa.toUpperCase();
            }
            System.err.println("Invalid, try again");
        }
    }
    
}