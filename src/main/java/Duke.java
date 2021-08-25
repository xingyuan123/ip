import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ToDoList l = new ToDoList();
        greeting();
        echo(l);
        bye();
    }

    public static void greeting(){
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

    public static void echo(ToDoList l){
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while(!line.equals("bye")){
            if(line.equals("list")){
                l.printList();
            } else{
                System.out.println("    _____________________________________________________________");
                System.out.println("     added:  "+line);
                l.addToList(line);
                System.out.println("    _____________________________________________________________");
            }
            in = new Scanner(System.in);
            line = in.nextLine();
        }
    }

    public static void bye(){
        System.out.println("    Bye.Hope to see you again soon!");
        System.out.println("    _____________________________________________________________");
    }
}
