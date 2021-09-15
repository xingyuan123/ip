import java.util.Scanner;

public class Duke {
    private static final String LINE_SEPARATOR = "    _____________________________________________________________";
    private static final int TODO_INDEX = 5;
    private static final int DEADLINE_INDEX = 9;
    private static final int EVENT_INDEX = 6;

    public static void main(String[] args) {
        TaskList list = new TaskList();
        char taskLetter = 0;
        printGreeting();
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")) {
            if (line.equals("list")) {
                list.printTaskList();
            } else if (line.startsWith("done")) {
                try {
                    list.markIsDone(Integer.parseInt(line.substring(5).trim()));
                } catch (NullPointerException e) {
                    System.out.println("    task number is out of bounds in list");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                } catch (NumberFormatException e){
                    System.out.println("    task number is wrong format");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                }
            } else if (line.startsWith("todo ")) {
                createToDoTask(line , taskLetter , list);
            } else if (line.startsWith("deadline ")) {
                try {
                    createDeadlineTask(line , taskLetter ,list);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("    please input /by date");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                } catch (DeadlineEmptyException e) {
                    System.out.println("    Deadline and by date cannot be whitespaces or empty");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                }
            } else if (line.startsWith("event")) {
                try {
                    createEventTask(line , taskLetter ,list);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("    please input /at date");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                } catch( EventEmptyException e) {
                    System.out.println("    Event and at date cannot be whitespaces or empty");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                }
            } else if (line.startsWith("delete")) {
                try {
                    list.deleteTask(Integer.parseInt(line.substring(7).trim()));
                } catch (NullPointerException e) {
                    System.out.println("    task number is out of bounds in list");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                } catch (NumberFormatException e){
                    System.out.println("    task number is wrong format");
                    System.out.println("    Please refer to the command guide");
                    printCommandGuide();
                }
            } else {
                System.out.println("    Invalid command");
                System.out.println("    Please refer to the command guide");
                printCommandGuide();
            }
            in = new Scanner(System.in);
            line = in.nextLine();
        }
        printBye();
    }



    public static void printGreeting() {
        String logo = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(LINE_SEPARATOR);
        System.out.println("    Hello! I'm Duke");
        printCommandGuide();
    }


    public static void printCommandGuide(){
        //prints list of commands
        System.out.println("    Command Guide");
        System.out.println("    use \"todo\" (with a space) to add a task without any date or time attached to it");
        System.out.println("    use \"deadline\" (with a space) and \"/by\" (with a space) to add a task to be done before a certain date");
        System.out.println("    use \"event\" (with a space) and \"/at\" (with a space) to add a task that start and ends at a specific time");
        System.out.println("    use \"list\" to show task list");
        System.out.println("    use \"done\" (with a space) followed by task number to mark a task as done");
        System.out.println("    use \"bye\" to exit the chat bot");
        System.out.println("    use \"delete\" followed by the taskNumber in the last to delete a task");
        System.out.println("    What can I do for you?");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     *Creates a new ToDo object of Task class
     *adds ToDo Object to list of tasks
     *prints a message to tell the user ToDo object has been added to TaskList
     *
     * @param line the input entered by user
     * @param taskLetter the letter denoting the type of object
     * @param list list of tasks
     * */
    public static void createToDoTask(String line , char taskLetter , TaskList list){
        if (line.substring(TODO_INDEX).trim().isEmpty()){
            System.out.println("    Todo task cannot be whitespaces or empty");
            printCommandGuide();
        } else {
            Task task = new ToDo(line.substring(TODO_INDEX));
            //taskLetter = Character.toUpperCase(line.charAt(0));
            list.addTaskList(task);
            printEcho(task ,list);
        }
    }

    /**
     *Creates a new Deadline object of Task class
     *adds Deadline Object to list of tasks
     *prints a message to tell the user Deadline object has been added to TaskList
     *
     * @param line the input entered by user
     * @param taskLetter the letter denoting the type of object
     * @param list list of tasks
     * */
    public static void createDeadlineTask(String line , char taskLetter , TaskList list) throws DeadlineEmptyException , ArrayIndexOutOfBoundsException {
        String[] deadline = line.split("/by ");
        if (deadline[1] == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else if ( deadline[0].substring(DEADLINE_INDEX).trim().isEmpty()) {
            throw new DeadlineEmptyException();
        } else if ( deadline[1].trim().isEmpty()) {
            throw new DeadlineEmptyException();
        } else {
            Task task = new Deadline(deadline[0].substring(DEADLINE_INDEX) , deadline[1]);
            taskLetter = Character.toUpperCase(line.charAt(0));
            list.addTaskList(task);
            printEcho(task ,list);
        }

    }

    /**
     *Creates a new Event object of Task class
     *adds Event Object to list of tasks
     *prints a message to tell the user Event object has been added to TaskList
     *
     * @param line the input entered by user
     * @param taskLetter the letter denoting the type of object
     * @param list list of tasks
     * */
    public static void createEventTask(String line , char taskLetter , TaskList list) throws EventEmptyException , ArrayIndexOutOfBoundsException {
        String[] event = line.split("/at ");
        if (event[1] == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (event[0].substring(EVENT_INDEX).trim().isEmpty()) {
            throw new EventEmptyException();
        } else if (event[1].trim().isEmpty()) {
            throw new EventEmptyException();
        } else {
            Task task = new Event(event[0].substring(EVENT_INDEX) , event[1]);
            taskLetter = Character.toUpperCase(line.charAt(0));
            list.addTaskList(task);
            printEcho(task ,list);
        }

    }

    public static void printEcho(Task task , TaskList list ) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("    Got it. I've added this task:");
        System.out.print("      ");
        task.printTask();
        System.out.println("    Now you have " + list.getTaskListCount() + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    public static void printBye() {
        System.out.println("    Bye.Hope to see you again soon!");
        System.out.println(LINE_SEPARATOR);
    }
}
