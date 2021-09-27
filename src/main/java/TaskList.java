import java.util.ArrayList;

public class TaskList {

    private static int taskListCount = 0;
    private static ArrayList<Task> taskList = new ArrayList<>();

    public void addTaskList(Task listItem) {
        taskList.add(listItem);
        taskListCount += 1;
    }

    public void printTaskList() {
        Ui.printLineSeparator();
        for (int i = 1; i < taskListCount + 1; i++) {
            System.out.print("    " + i + ".");
            taskList.get(i - 1).printTask();
        }
        Ui.printLineSeparator();
    }

    public void markIsDone(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > taskListCount) {
            throw new NullPointerException();
        } else {
            taskList.get(taskNumber - 1).setDone();
            Ui.printLineSeparator();
            Ui.printMarkIsDone();
            taskList.get(taskNumber - 1).printTask();
            Ui.printLineSeparator();
        }
    }

    public void deleteTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > taskListCount) {
            throw new NullPointerException();
        } else {
            Ui.printLineSeparator();
            Ui.printDeleteTask();
            taskList.get(taskNumber - 1).printTask();
            taskList.remove(taskNumber - 1);
            taskListCount -= 1;
            System.out.println("    Now you have " + taskListCount + " tasks in the list.");
            Ui.printLineSeparator();
        }
    }

    public int getTaskListCount() {
        return taskListCount;
    }

    public String textString(int index) {
        return taskList.get(index).getTextString();
    }

}
