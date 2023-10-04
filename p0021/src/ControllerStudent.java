
import java.util.ArrayList;

public class ControllerStudent {

    BOStudent bo = new BOStudent();

    public void generateExampleStudent() {
        bo.addStudent(new Student("HE170815", "Vu Gia Khanh", "3", "Java"));
        bo.addStudent(new Student("HE170945", "Do Thuy Duong", "3", ".Net"));
        bo.addStudent(new Student("HE172592", "Duong Tuan Du", "3", "C/C++"));
        bo.addStudent(new Student("HE173204", "Nguyen Thanh Tung", "3", "Java"));
        bo.addStudent(new Student("HE173204", "Nguyen Thanh Tung", "3", ".Net"));
        bo.addStudent(new Student("HE173204", "Nguyen Thanh Tung", "4", ".Net"));
        bo.addStudent(new Student("HE173260", "Nguyen Tien Dat", "3", ".Net"));
        bo.addStudent(new Student("HE173571", "Bui Viet Khang", "3", "Java"));
        bo.addStudent(new Student("HE180018", "Phan Duc Huy", "3", "C/C++"));
        bo.addStudent(new Student("HE180047", "Vu Viet Anh", "3", "C/C++"));
        bo.addStudent(new Student("HE180047", "Vu Viet Anh", "4", "C/C++"));
        bo.addStudent(new Student("HE180047", "Vu Viet Anh", "5", "C/C++"));

    }

    public void createStudent() {
        String id, studentName = null, semester, courseName;
        System.out.println("CREATE STUDENT");
        while (true) {
//            check the number of students
            if (bo.getNumberStudent() >= 10) {
                if (!Validation.inputYesNO("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen: ")) {
                    return;
                }
            } else {
                System.err.println("Not enough 10 students. Please enter more");
            }

            id = Validation.inputString("Enter ID: ", "^[A-Za-z0-9]{8}+$");

            Student tempStudent = bo.getStudentById(id);

//            if student id existed
            while (tempStudent != null) {
                System.err.println("Id: " + id.toUpperCase() + " existed");

                if (Validation.inputYesNO("Do you want to use id existed? (Y/N): ")) {
                    studentName = tempStudent.getStudentName();
                    break;
                } else {
                    id = Validation.inputString("Enter ID: ", "^[A-Za-z0-9]{8}+$");
                    tempStudent = bo.getStudentById(id);
                }
            }

            if (tempStudent == null) {
                studentName = Validation.inputNameNormalize("Enter Name: ", "^[A-Za-z\\s]+$");
            }

            semester = Validation.inputString("Enter Semester: ", "[0-9]");
            courseName = Validation.inputCourseName("Enter Course Name: ");

            Student newStudent = new Student(id.toUpperCase(), studentName, semester, courseName);

            if (bo.isDuplicateStudent(newStudent)) {
                System.err.println("Duplicate");
            } else {
                bo.addStudent(newStudent);
                System.out.println("Create success");
            }
        }
    }

    public void findAndSort() {

        if (bo.isEmptyList()) {
            System.err.println("List students is empty, please enter more data");
            return;
        }
        System.out.println("FIND AND SORT");

        int countResult = 0;
        String nameToFind = Validation.inputString("Enter name to find: ", "^[A-Za-z\\s]+$").trim();

        ArrayList<Student> resultListFindByName = bo.findStudentByName(nameToFind);

//      if result list after find not empty, sort result list by name ascending
        if (!resultListFindByName.isEmpty()) {
            bo.sortStudentByNameAsc(resultListFindByName);
            System.out.println("Found " + resultListFindByName.size() + " Student");
            System.out.printf("%-30s%-15s%-15s\n", "Student Name", "Semester", "Course Name");
            for (Student tempStudent : resultListFindByName) {
                System.out.print(tempStudent);
            }
        } else {
            System.out.println("Not found student with name: " + nameToFind);
        }
    }

    public void updateOrDeleteStudent() {
        if (bo.isEmptyList()) {
            System.err.println("List Students is empty");
            return;
        }

        System.out.println("UPDATE/DELETE STUDENT");

        bo.displayListStudent();

        String searchID = Validation.inputString("Enter ID to Update or Delete: ", "^[A-Za-z0-9]{8}+$");

        if (!bo.isExistedId(searchID)) {
            System.err.println("Not found ID, try again");
            return;
        }

        ArrayList<Student> resultListFindById = bo.findStudentById(searchID);

        System.out.println("Found " + resultListFindById.size() + " Student");
        displayResultListFindById(resultListFindById, searchID);

        int choiceIndexResultList;

        if (resultListFindById.size() == 1) {
            choiceIndexResultList = 1;
        } else {
            choiceIndexResultList = Validation.inputChoice("Enter Ordinal number to Update or Delete: ", 1, resultListFindById.size());
        }

        Student studentChange = resultListFindById.get(choiceIndexResultList - 1);

        if (Validation.inputUD("Do you want to update (U) or delete (D) student: ")) {
//            updateStudent(resultListFindById, choiceIndexResultList);
            System.out.println("UPDATE STUDENT");
            String updateId, updateName, updateSemester, updateCourseName;

            updateId = Validation.inputString("Enter ID to update: ", "^[A-Za-z0-9]{8}+$").toUpperCase();
            updateName = Validation.inputNameNormalize("Enter name to update: ", "^[A-Za-z\\s]+$");
            
            
            while (!bo.checkValid(new Student(updateId, updateName, null, null))) {
                System.err.println("1 id not have more than 1 name");
                updateId = Validation.inputString("Enter ID to update: ", "^[A-Za-z0-9]{8}+$").toUpperCase();
                updateName = Validation.inputNameNormalize("Enter name to update: ", "^[A-Za-z\\s]+$");
            }
            
            updateSemester = Validation.inputString("Enter Semester: ", "[0-9]");
            updateCourseName = Validation.inputCourseName("Enter course name to update: ");
            
            while (bo.isDuplicateStudent(new Student(updateId, updateName, updateSemester, updateCourseName))) {
                System.err.println("Duplicate student");
                updateId = Validation.inputString("Enter ID to update: ", "^[A-Za-z0-9]{8}+$").toUpperCase();
                updateName = Validation.inputNameNormalize("Enter name to update: ", "^[A-Za-z\\s]+$");
                updateSemester = Validation.inputString("Enter Semester: ", "[0-9]");
                updateCourseName = Validation.inputCourseName("Enter course name to update: ");
            }

            bo.updateStudent(studentChange, updateId, updateName, updateSemester, updateCourseName);

            System.out.println("Update succcess");
        } else {
//            deleteStudent(resultListFindById, choiceIndexResultList);
            System.out.println("DELETE STUDENT");
            bo.deleteStudent(studentChange);
            System.out.println("DELETE SUCCESS");
        }
    }

    public void report() {
        if (bo.isEmptyList()) {
            System.err.println("List is empty, please enter more Student");
            return;
        }
        System.out.println("REPORT");

        ArrayList<Report> listReports = bo.getReportList();
        System.out.printf("%-20s%-15s%-15s\n", "Student Name", "Course", "Total Course");
        displayReportList(listReports);

    }

    private void displayReportList(ArrayList<Report> list) {
        for (Report tempReport : list) {
            if (tempReport.getTotalCourse() != 0) {
                System.out.println(tempReport);
            }
        }
    }

    private void displayResultListFindById(ArrayList<Student> list, String searchID) {
        System.out.println("LIST STUDENT FIND BY ID: " + searchID);
        System.out.printf("%-20s%-15s%-25s%-15s%-15s\n", "Ordinal number", "ID", "Student Name", "Semester", "Course Name");

        for (int i = 0; i < list.size(); i++) {
            Student tempStudent = list.get(i);
            System.out.printf("%-20s%-15s%-25s%-15s%-15s\n", i + 1, tempStudent.getId(), tempStudent.getStudentName(), tempStudent.getSemester(), tempStudent.getCourseName());
        }
    }
}
