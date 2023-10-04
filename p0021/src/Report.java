public class Report {
    private String studentName;
    private String courseName;
    private int totalCourse;

    public Report() {
    }

    public Report(String studentName, String couseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = couseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCouseName() {
        return courseName;
    }

    public void setCouseName(String couseName) {
        this.courseName = couseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
    public String toString() {
        return String.format("%-20s%-15s%-15s", studentName, courseName, totalCourse);
    }
}