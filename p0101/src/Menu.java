public class Menu {
    public void menu() {
        Validation v = new Validation();
        EmployeeController co = new EmployeeController();
        co.generateEmployees();
        while (true) {
            System.out.println("==========EMPLOYEE MANAGEMENT=========");
            System.out.println("1. Add Employees");
            System.out.println("2. Update Employees");
            System.out.println("3. Remove Employees");
            System.out.println("4. Search Employees");
            System.out.println("5. Sort Employees by salary");
            System.out.println("6. Exit");
            int choice = v.inputInteger("Enter your choice: ", 1, 6);
            switch (choice) {
                case 1:
                    co.addEmployee();
                    break;
                case 2:
                    co.updateEmployee();
                    break;
                case 3:
                    co.removeEmployee();
                    break;
                case 4:
                    co.searchEmployee();
                    break;
                case 5:
                    co.sortEmployee();
                    break;
                case 6:
                    return;
            }
        }
    }
}