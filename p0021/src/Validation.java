
import java.util.Scanner;

public class Validation {

    final static Scanner sc = new Scanner(System.in);

//    check input int in range
    public static int inputChoice(String msg, int min, int max) {
        int choice;
        while (true) {
            System.out.print(msg);
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, please input again!");
            }
        }
    }

//   check input Yes/No
    public static boolean inputYesNO(String msg) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                if (input.equalsIgnoreCase("Y")) {
                    return true;
                } else if (input.equalsIgnoreCase("N")) {
                    return false;
                }
                System.err.println("You need input Y/y or N/n");
            } else {
                System.err.println("You need input Y/y or N/n, cannot empty");
            }
        }
    }
    
    public static boolean inputUD(String msg) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Cannot empty");
            } else {
                if (input.equalsIgnoreCase("U")) {
                    return true;
                } else if (input.equalsIgnoreCase("D")) {
                    return false;
                } else {
                    System.err.println("Invalid, please input again!");
                }
            }
        }
    }

//    check input string
    public static String inputString(String msg, String regex) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.matches(regex)) {
                return input;
            }
            System.err.println("Invalid, please input again!");
        }
    }
    
//    check input and normalize name
    public static String inputNameNormalize(String msg, String regex) {
        String name = inputString(msg, regex).trim().toLowerCase();
        String[] normalizeName = name.split("\\s+");
        name = "";
        for (String temp: normalizeName) {
            StringBuilder sb = new StringBuilder(temp);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            name += sb.toString() + " ";
        }
        return name.trim();
    }
    
//    check input course name(only 3 course java, .net, c/c++)
    public static String inputCourseName(String msg) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("Java")) {
                return input.substring(0, 1).toUpperCase() + input.substring(1, input.length());
            } else if (input.equalsIgnoreCase(".Net")) {
                return input.substring(0, 1) + input.substring(1, 2).toUpperCase() + input.substring(2, input.length());
            } else if (input.equalsIgnoreCase("C/C++")) {
                return input.substring(0, 1).toUpperCase() + input.substring(1, 2) + input.substring(2, 3).toUpperCase() + input.substring(3, input.length());
            } else {
                System.err.println("Invalid, please input again!");
            }
        }
    }

}
