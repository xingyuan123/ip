public class TaskList {
    private int taskListCount = 0;
    private Task[] taskList = new Task[100];


    public void addTaskList(Task listItem){
        taskList[taskListCount] = listItem;
        taskListCount += 1;
    }

    public void printTaskList(){
            System.out.println("    _____________________________________________________________");
            for(int i = 1 ; i < taskListCount+1 ; i++){
                System.out.println(i+"."+taskList[i-1].getStatusIcon() +taskList[i-1].getDescription());
            }
            System.out.println("    _____________________________________________________________");
    }

    public void markIsDone(int taskNumber){
        taskList[taskNumber-1].setIsDone();
        System.out.println("    _____________________________________________________________");
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("    [X] " + taskList[taskNumber-1].getDescription());
        System.out.println("    _____________________________________________________________");
    }
}
