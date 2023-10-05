
import java.util.ArrayList;

public class ControllerTask {

    BOTask bo = new BOTask();
    Validation v = new Validation();

//    public ControllerTask() {
//        bo.addTask(new Task(1, "Dev Program", "updated code", "13-07-2024", 8, 15, "dev", "Junior"));
//        bo.addTask(new Task(2, "Design", "updated design", "28-09-2022", 8, 17.5, "design", "PM"));
//        bo.addTask(new Task(3, "Dev Program", "updated code", "01-11-2030", 9, 16, "dev", "Senior"));
//        bo.addTask(new Task(4, "Dev Program", "updated code", "19-05-2028", 10, 17.5, "dev", "Lead"));
//        bo.addTask(new Task(5, "Dev Program", "updated code", "05-12-2027", 8, 15.5, "dev", "Lead"));
//        bo.addTask(new Task(6, "Dev Program", "updated code", "22-03-2030", 12, 14, "dev", "Lead"));
//        bo.addTask(new Task(7, "Dev Program", "updated code", "17-09-2029", 13, 17, "dev", "Junior"));
//    }

    public void addTask() {
        int id;
        if (bo.isEmptyTask()) {
            id = 1;
        } else {
            id = bo.getLastId() + 1;
        }
        System.out.println("---------------Add task-----------------");
        String requirementName = v.inputString("Requirement name: ", "[A-Za-z\\s]+");
        String taskTypeID = v.inputTaskTypeId("Task type: ");
        String date = v.inputDate("Date: ");
        double planFrom = v.inputDouble("From: ", 8, 17);
        double planTo = v.inputDouble("To: ", 8.5, 17.5);
        while (!bo.checkTime(planFrom, planTo)) {
            System.err.println("Plan From must be less than Plan To");
            planFrom = v.inputDouble("From: ", 8, 17);
            planTo = v.inputDouble("To: ", 8.5, 17.5);
        }
        String assignee = v.inputString("Assignee: ", "[A-Za-z\\s]+");
        String reviewer = v.inputString("Reviewer: ", "[A-Za-z\\s]+");

        while (bo.checkAssigneeReviewer(assignee, reviewer)) {
            System.err.println("Assignee not same reviewer");
            assignee = v.inputString("Assignee: ", "[A-Za-z\\s]+");
            reviewer = v.inputString("Reviewer: ", "[A-Za-z\\s]+");
        }
        
        Task newTask = new Task(id, taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        
        if (bo.checkDuplicateTask(newTask)) {
            System.err.println("Duplicate Task");
            return;
        }
        bo.addTask(newTask);
    }

    public void deleteTask() {
        System.out.println("---------------Delete Task-----------------");
        int idFind = v.inputInteger("ID: ", 1, Integer.MAX_VALUE);
        Task taskDelete = bo.getTaskById(idFind);
        if (taskDelete == null) {
            System.out.println("NOT FOUND");
            return;
        }
        bo.removeTask(taskDelete);
        System.out.println("DELETE SUCCESFULLY");
    }

    public void displayTasks() {
        if (bo.isEmptyTask()) {
            System.out.println("List task is empty");
            return;
        }

        ArrayList<Task> listTasks = bo.getDataTasks();
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task tempTask : listTasks) {
            double time = tempTask.getPlanTo() - tempTask.getPlanFrom();
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n", tempTask.getId(), tempTask.getRequirementName(), tempTask.getTaskTypeId(),
                    tempTask.getDate(), time, tempTask.getAssignee(), tempTask.getReviewer());
        }
    }
}
