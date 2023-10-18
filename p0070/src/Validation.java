import java.util.Scanner;

public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int getChoice(String msg, int min, int max) {
        int choice;
        while (true) {
            System.out.print(msg);
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, try again");
            }
        }
    }

    public String inputString() {
        String input = sc.nextLine();
        return input;
    }
}
