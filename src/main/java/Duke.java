import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        char taskLetter;
        greeting();
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")) {
            if (line.equals("list")) {
                list.printTaskList();
            } else if(line.startsWith("done")) {
                list.markIsDone(Integer.parseInt(line.substring(5)));
            } else if(line.startsWith("todo")) {
                Task task = new ToDo(line.substring(5));
                taskLetter = Character.toUpperCase(line.charAt(0));
                list.addTaskList(task);
                echo(task ,list);
            } else if(line.startsWith("deadline")){
                String[] deadline = line.split("/by");
                Task task = new Deadline(deadline[0].substring(9) , deadline[1]);
                taskLetter = Character.toUpperCase(line.charAt(0));
                list.addTaskList(task);
                echo(task ,list);
            } else if(line.startsWith("event")) {
                String[] event = line.split("/at ");
                Task task = new Event(event[0].substring(6) , event[1]);
                taskLetter = Character.toUpperCase(line.charAt(0));
                list.addTaskList(task);
                echo(task ,list);
            } else {
                System.out.println("    Ps didn't understand command , please refer to the command guide");
                commandGuide();
            }
            in = new Scanner(System.in);
            line = in.nextLine();
        }
        bye();
    }

    public static void greeting() {
        String logo = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("    _____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        commandGuide();
    }

    public static void commandGuide(){
        System.out.println("    Command Guide");
        System.out.println("    use \"todo\" (with a space) to add a task without any date or time attached to it");
        System.out.println("    use \"deadline\" (with a space) and \"/by\" to add a task to be done before a certain date");
        System.out.println("    use \"event\" (with a space) and \"/at\" to add a task that start and ends at a specific time");
        System.out.println("    use \"list\" to show task list");
        System.out.println("    use \"done\" (with a space) followed by task number to mark a task as done");
        System.out.println("    use \"bye\" to exit the chat bot");
        System.out.println("    What can I do for you?");
        System.out.println("    _____________________________________________________________");
    }

    public static void echo(Task task , TaskList list ) {
        System.out.println("    _____________________________________________________________");
        System.out.println("    Got it. I've added this task:");
        System.out.print("      ");
        task.printTask();
        System.out.println("    Now you have " + list.getTaskListCount() + " tasks in the list.");
        System.out.println("    _____________________________________________________________");
    }

    public static void bye() {
        System.out.println("    Bye.Hope to see you again soon!");
        System.out.println("    _____________________________________________________________");
    }
}
