public class Menu {
    Validation v = new Validation();
    ControllerTask co = new ControllerTask();
    
    public void menu() {
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Delete tasks");
            System.out.println("3. Display task");
            System.out.println("4. exit");
            int choice = v.inputInteger("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    co.addTask();
                    break;
                case 2:
                    co.deleteTask();
                    break;
                case 3:
                    co.displayTasks();
                    break;
                case 4:
                    return;
            }
        }
    }
}