
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        ControllerBank co = new ControllerBank();
        Validation v = new Validation();
        while (true) {
            System.out.println("-----------Login Program------------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            int choice = v.getChoice("Please choice one option: ", 1, 3);
            switch (choice) {
                case 1:
                    co.login(new Locale("vi"));
                    break;
                case 2:
                    co.login(new Locale("en"));
                    break;
                case 3:
                    return;
            }
        }
    }
}
