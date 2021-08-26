import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        greeting();
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")) {
            if (line.equals("list")) {
                list.printTaskList();
            } else if(line.startsWith("done")) {
                list.markIsDone(Integer.parseInt(line.substring(5)));
            } else {
                echo(line);
                Task task = new Task(line);
                list.addTaskList(task);
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
        System.out.println("    What can I do for you?");
        System.out.println("    _____________________________________________________________");

    }

    public static void echo(String line) {
        System.out.println("    _____________________________________________________________");
        System.out.println("     added:  "+line);
        System.out.println("    _____________________________________________________________");
    }

    public static void bye() {
        System.out.println("    Bye.Hope to see you again soon!");
        System.out.println("    _____________________________________________________________");
    }
}
