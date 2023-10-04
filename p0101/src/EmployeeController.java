
import java.util.ArrayList;

public class EmployeeController {

    BOEmployee bo = new BOEmployee();
    Validation v = new Validation();

    public void generateEmployees() {
        bo.addEmployee(new Employee("1", "Tung", "Nguyen Thanh", "0384370666", "tungnthe173204@fpt.edu.vn", "Ha Noi", "08/09/2003", "MALE", 5000, "VNG"));
        bo.addEmployee(new Employee("2", "Van", "Tran Thi", "0355212455", "vanttihs132403@fpt.edu.vn", "HCM", "03/04/2002", "FEMALE", 1200, "FPT"));
        bo.addEmployee(new Employee("3", "An", "Pham Van", "0321456871", "anpvhs189234@fpt.edu.vn", "Da Nang", "11/12/2001", "MALE", 1100, "VNG"));
        bo.addEmployee(new Employee("4", "Mai", "Le Thi", "0361254782", "mailthe173405@fpt.edu.vn", "Ha Noi", "02/02/2000", "FEMALE", 1300, "VNPT"));
        bo.addEmployee(new Employee("5", "Hung", "Dinh Van", "0394024152", "hungdvhe193245@fpt.edu.vn", "HCM", "05/06/1999", "MALE", 1400, "VinGroup"));
        bo.addEmployee(new Employee("6", "Ha", "Phan Thi", "0334142354", "haptse161234@fpt.edu.vn", "Ha Noi", "09/10/1998", "FEMALE", 1500, "FPT"));
    }

    public void addEmployee() {
        String id = v.inputString("Enter ID: ", "^[0-9]+$");
        while (bo.checkDuplicateId(id)) {
            System.err.println("Duplicate ID");
            id = v.inputString("Enter ID: ", "^[0-9]+$");
        }
        String firstName = v.inputString("Enter First Name: ", "^(?=.*[A-Za-z])[A-Za-z\\s]+$");
        String lastName = v.inputString("Enter Last Name: ", "^(?=.*[A-Za-z])[A-Za-z\\s]+$");
        String phone = v.inputString("Enter Phone: ", "^0[0-9]{9,10}$");
        while (bo.checkDuplicatePhone(phone)) {
            System.err.println("Duplicate Phone");
            phone = v.inputString("Enter Phone: ", "^0[0-9]{9,10}$");
        }
        String email = v.inputString("Enter Email: ", "^[A-Za-z0-9]+@[A-Za-z]+(\\.[A-Za-z]+)+(\\.[A-Za-z]+)*$");
        while (bo.checkDuplicateEmail(email)) {
            System.err.println("Duplicate Email");
            email = v.inputString("Enter Email: ", "^[A-Za-z0-9]+@[A-Za-z]+(\\.[A-Za-z]+)+(\\.[A-Za-z]+)*$");
        }
        String address = v.inputString("Enter Address: ", "^[A-Za-z0-9\\s]+$");
        String dob = v.inputDate("Enter DOB: ");
        String sex = v.intputSex("Enter Sex: ");
        double salary = v.inputDouble("Enter Salary: ", 0, Double.MAX_VALUE);
        String agency = v.inputString("Enter Agency: ", "^(?=.*[A-Za-z])[A-Za-z0-9\\s]+$");

        Employee newEmployee = new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
        bo.addEmployee(newEmployee);
        System.out.println("Add employee success");
        displayList(bo.getListEmployee());
    }

    public void updateEmployee() {
        String idFind = v.inputString("Enter ID employee to update: ", "^[0-9]+$");
        Employee employeeUpdate = bo.findEmployeeById(idFind);

        if (employeeUpdate == null) {
            System.out.println("NOT FOUND EMPLOYEE WITH ID: " + idFind);
            return;
        }

        String idUpdate = v.inputString("Enter ID Update: ", "(^[0-9]+$)|(^$)|(^[\\s]+$)");
        while (bo.checkDuplicateId(idUpdate)) {
            System.err.println("Duplicate Id");
            idUpdate = v.inputString("Enter ID Update: ", "(^[0-9]+$)|(^$)|(^[\\s]+$)");
        }
        if (idUpdate.trim().isEmpty()) {
            idUpdate = employeeUpdate.getId();
        }

        String firstNameUpdate = v.inputString("Enter FirstName Update: ", "(^[A-Za-z\\s]+$)|(^$)|(^[\\s]+$)");
        if (firstNameUpdate.trim().isEmpty()) {
            firstNameUpdate = employeeUpdate.getFirstName();
        }

        String lastNameUpdate = v.inputString("Enter LastName Update: ", "(^[A-Za-z\\s]+$)|(^$)|(^[\\s]+$)");
        if (lastNameUpdate.trim().isEmpty()) {
            lastNameUpdate = employeeUpdate.getLastName();
        }
        String phoneUpdate = v.inputString("Enter Phone Update: ", "(^0[0-9]{9,10}$)|(^$)|(^[\\s]+$)");
        while (bo.checkDuplicatePhone(phoneUpdate)) {
            System.err.println("Duplicate Phone");
            phoneUpdate = v.inputString("Enter Phone Update: ", "(^0[0-9]{9,10}$)|(^$)|(^[\\s]+$)");
        }
        if (phoneUpdate.trim().isEmpty()) {
            phoneUpdate = employeeUpdate.getPhone();
        }

        String emailUpdate = v.inputString("Enter Email Update: ", "(^[A-Za-z0-9]+@[A-Za-z]+(\\.[A-Za-z]+)+(\\.[A-Za-z]+)*$)|(^$)|(^[\\s]+$)");
        while (bo.checkDuplicateEmail(emailUpdate)) {
            System.err.println("Duplicate Email");
            emailUpdate = v.inputString("Enter Email Update: ", "(^[A-Za-z0-9]+@[A-Za-z]+(\\.[A-Za-z]+)+(\\.[A-Za-z]+)*$)|(^$)|(^[\\s]+$)");
        }
        if (emailUpdate.trim().isEmpty()) {
            emailUpdate = employeeUpdate.getEmail();
        }

        String addressUpdate = v.inputString("Enter Address Update: ", "(^[A-Za-z0-9\\s]+$)|(^$)|(^[\\s]+$)");
        if (addressUpdate.trim().isEmpty()) {
            addressUpdate = employeeUpdate.getAddress();
        }

        String dobUpdate = v.inputDateUpdate("Enter DOB Update: ");
        if (dobUpdate.isEmpty()) {
            dobUpdate = employeeUpdate.getDob();
        }

        String sexUpdate = v.intputSexUpdate("Enter Sex Update: ");
        if (sexUpdate.isEmpty()) {
            sexUpdate = employeeUpdate.getSex();
        }

        double salaryUpdate = v.inputDoubleUpdate("Enter Salary Update: ", 0, Double.MAX_VALUE);
        if (salaryUpdate == -1) {
            salaryUpdate = employeeUpdate.getSalary();
        }

        String agencyUpdate = v.inputString("Enter Agency Update: ", "(^[A-Za-z\\s]+$)|(^$)|(^[\\s]+$)");
        if (agencyUpdate.trim().isEmpty()) {
            agencyUpdate = employeeUpdate.getAgency();
        }

        bo.updateEmployee(employeeUpdate, idUpdate, firstNameUpdate, lastNameUpdate, phoneUpdate, emailUpdate, addressUpdate, dobUpdate, sexUpdate, salaryUpdate, agencyUpdate);
        System.out.println("Update success");

        displayList(bo.getListEmployee());
}

public void removeEmployee() {
        String idRemove = v.inputString("Enter ID employee to remove: ", "^[0-9]+$").trim();
        Employee employeeRemove = bo.findEmployeeById(idRemove);
        if (employeeRemove == null) {
            System.out.println("NOT FOUND EMPLOYEE WITH ID: " + idRemove);
            return;
        }
        bo.removeEmployee(employeeRemove);
        System.out.println("Remove employee with ID " + idRemove + " success");

        displayList(bo.getListEmployee());
    }

    public void searchEmployee() {
        String name = v.inputString("Enter name to search: ", "(^[A-Za-z\\s]+$)|(^$)|(^[\\s]+$)");
        ArrayList<Employee> employeeSearch = bo.searchEmployee(name.toLowerCase());
        if (employeeSearch.isEmpty()) {
            System.out.println("NOT FOUND EMPLOYEE WITH NAME: " + name);
            System.out.println("");
            return;
        }
        displayList(employeeSearch);
    }

    public void sortEmployee() {
        ArrayList<Employee> employeeSort = bo.sortEmployeesBySalary();
        displayList(employeeSort);
    }

    public void displayList(ArrayList<Employee> list) {
        if (list == null) {
            System.out.println("List Employee Empty");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-30s%-10s%-15s%-10s%-10s%-10s\n", "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (Employee tempEmployee : list) {
            System.out.println(tempEmployee);
        }
    }

}
