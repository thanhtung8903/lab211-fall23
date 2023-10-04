
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOEmployee {

    private ArrayList<Employee> listEmployees = new ArrayList<>();

    public void addEmployee(Employee theEmployee) {
        listEmployees.add(theEmployee);
    }

    public void updateEmployee(Employee theEmployee, String id, String firstName, String lastName, String phone, String email, String address, String dob, String sex, double salary, String agency) {
        theEmployee.setId(id);
        theEmployee.setFirstName(firstName);
        theEmployee.setLastName(lastName);
        theEmployee.setPhone(phone);
        theEmployee.setEmail(email);
        theEmployee.setAddress(address);
        theEmployee.setDob(dob);
        theEmployee.setSex(sex);
        theEmployee.setSalary(salary);
        theEmployee.setAgency(agency);
    }

    public void removeEmployee(Employee theEmployee) {
        listEmployees.remove(theEmployee);
    }

    public Employee findEmployeeById(String id) {
        for (Employee tempEmployee : listEmployees) {
            if (tempEmployee.getId().equalsIgnoreCase(id)) {
                return tempEmployee;
            }
        }
        return null;
    }

    public ArrayList<Employee> searchEmployee(String name) {
        ArrayList<Employee> listSearch = new ArrayList<>();
        for (Employee tempEmployee : listEmployees) {
            String fullName = tempEmployee.getLastName() + " " + tempEmployee.getFirstName();
            if (fullName.toLowerCase().contains(name)) {
                listSearch.add(tempEmployee);
            }
        }
        return listSearch;
    }

    public ArrayList<Employee> sortEmployeesBySalary() {
        if (isEmplyListEmployees()) {
            return null;
        }
        ArrayList<Employee> listSort = getListEmployee();
        Collections.sort(listSort, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                double temp = o1.getSalary() - o2.getSalary();
                if (temp > 0) {
                    return 1;
                } else if (temp < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return listSort;
    }

    public boolean checkDuplicateId(String id) {
        for (Employee tempEmployee : listEmployees) {
            if (tempEmployee.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicateEmail(String email) {
        for (Employee tempEmployee : listEmployees) {
            if (tempEmployee.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicatePhone(String phone) {
        for (Employee tempEmployee : listEmployees) {
            if (tempEmployee.getPhone().equalsIgnoreCase(phone)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getListEmployee() {
        if (isEmplyListEmployees()) {
            return null;
        }
        return listEmployees;
    }

    public boolean isEmplyListEmployees() {
        return listEmployees.isEmpty();
    }

}
