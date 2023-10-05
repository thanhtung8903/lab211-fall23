
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int inputInteger(String msg, int min, int max) {
        int input;
        while (true) {
            System.out.print(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public double inputDouble(String msg, double min, double max) {
        double input;
        while (true) {
            System.out.print(msg);
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if (input % 0.5 != 0) {
                    throw new NumberFormatException();
                }
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public String inputString(String msg, String regex) {
        String input;
        while (true) {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (!input.matches(regex)) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public String inputDate(String msg) {
        String input;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            try {
                java.util.Date date = dateFormat.parse(input);
                return dateFormat.format(date);
            } catch (Exception e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public String inputTaskTypeId(String msg) {
        int choice = inputInteger(msg, 1, 4);
        String input = null;
        switch (choice) {
            case 1:
                input = "Code";
                break;
            case 2:
                input = "Test";
                break;
            case 3:
                input = "Design";
                break;
            case 4:
                input = "Review";
                break;
        }
        return input;
    }

}
