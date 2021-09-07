public class TaskList {
    private static final int MAX_TASK_NUMBER = 100;
    private static final String LINE_SEPARATOR = "    _____________________________________________________________";

    private int taskListCount = 0;
    private Task[] taskList = new Task[MAX_TASK_NUMBER];

    public void addTaskList(Task listItem) {
        taskList[taskListCount] = listItem;
        taskListCount += 1;
    }

    public void printTaskList() {
        System.out.println(LINE_SEPARATOR);
        for (int i = 1 ; i < taskListCount + 1 ; i++) {
            System.out.print("    " + i + ".");
            taskList[i-1].printTask();
        }
        System.out.println(LINE_SEPARATOR);
    }

    public void markIsDone(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > taskListCount){
            throw new NullPointerException();
        } else {
            taskList[taskNumber-1].setDone();
            System.out.println(LINE_SEPARATOR);
            System.out.println("    Nice! I've marked this task as done:");
            System.out.print("    ");
            taskList[taskNumber-1].printTask();
            System.out.println(LINE_SEPARATOR);
        }
    }

    public int getTaskListCount() {
        return taskListCount;
    }
}
