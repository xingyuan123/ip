import java.util.ArrayList;
public class TaskList {
    private static final int MAX_TASK_NUMBER = 100;
    private static final String LINE_SEPARATOR = "    _____________________________________________________________";

    private int taskListCount = 0;
    //private Task[] taskList = new Task[MAX_TASK_NUMBER];
    private static ArrayList<Task> taskList = new ArrayList<>();

    public void addTaskList(Task listItem) {
        taskList.add(listItem);
        //taskList[taskListCount] = listItem;
        taskListCount += 1;
    }

    public void printTaskList() {
        System.out.println(LINE_SEPARATOR);
        for (int i = 1 ; i < taskListCount + 1 ; i++) {
            System.out.print("    " + i + ".");
            //taskList[i-1].printTask();
            taskList.get(i-1).printTask();

        }
        System.out.println(LINE_SEPARATOR);
    }

    public void markIsDone(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > taskListCount){
            throw new NullPointerException();
        } else {
            //taskList[taskNumber-1].setDone();
            taskList.get(taskNumber-1).setDone();
            System.out.println(LINE_SEPARATOR);
            System.out.println("    Nice! I've marked this task as done:");
            System.out.print("    ");
            //taskList[taskNumber-1].printTask();
            taskList.get(taskNumber-1).printTask();
            System.out.println(LINE_SEPARATOR);
        }
    }

    public void deleteTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > taskListCount){
            throw new NullPointerException();
        } else {

            System.out.println(LINE_SEPARATOR);
            System.out.println("    Noted. I've removed this task:");
            System.out.print("    ");
            taskList.get(taskNumber-1).printTask();

            taskList.remove(taskNumber - 1);
            taskListCount -= 1;
            System.out.println("    Now you have " + taskListCount + " tasks in the list.");
            System.out.println(LINE_SEPARATOR);
        }
    }


    public int getTaskListCount() {
        return taskListCount;
    }

    public String textString(int index) {
        String textLine = taskList.get(index).getTextString();
        return textLine;
    }

}
