
import java.util.ArrayList;

public class BOTask {

    private ArrayList<Task> listTasks = new ArrayList<>();

    public boolean isEmptyTask() {
        return listTasks.isEmpty();
    }

    public int addTask(String taskTypeId, String requirementName, String date, double planFrom, double planTo, String assign, String reviewer) {
        int id;
        if (isEmptyTask()) {
            id = 1;
        } else {
            id = listTasks.get(listTasks.size() - 1).getId() + 1;
        }
        Task newTask = new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer);
        if (checkDuplicateTask(newTask)) {
            return -1;
        } else {
            listTasks.add(newTask);
        }
        return id;
    }

    public Task getTaskById(int id) {
        for (Task tempTask : listTasks) {
            if (tempTask.getId() == id) {
                return tempTask;
            }
        }
        return null;
    }

    public void removeTask(Task theTask) {
        listTasks.remove(theTask);
    }

    public int getLastId() {
        return listTasks.get(listTasks.size() - 1).getId();
    }

    public boolean checkTime(double from, double to) {
        if (from < to) {
            return true;
        }
        return false;
    }

    public boolean checkAssigneeReviewer(String assignee, String reviewer) {
        if (assignee.equalsIgnoreCase(reviewer)) {
            return true;
        }
        return false;
    }

    public boolean checkDuplicateTask(Task theTask) {
        for (Task tempTask : listTasks) {
            if (tempTask.getRequirementName().equalsIgnoreCase(theTask.getRequirementName())
                    && tempTask.getTaskTypeId().equalsIgnoreCase(theTask.getTaskTypeId())
                    && tempTask.getDate().equalsIgnoreCase(theTask.getDate())
                    && tempTask.getPlanFrom() == theTask.getPlanFrom()
                    && tempTask.getPlanTo() == theTask.getPlanTo()
                    && tempTask.getAssignee().equalsIgnoreCase(theTask.getAssignee())
                    && tempTask.getReviewer().equalsIgnoreCase(theTask.getReviewer())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Task> getDataTasks() {
        return listTasks;
    }

}
