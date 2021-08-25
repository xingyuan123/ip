import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greeting();
        echo();
        bye();

    }

    public static void greeting(){
        System.out.println("    _____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    _____________________________________________________________");

    }

    public static void echo(){
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while(line.equals("bye") == false){
            System.out.println("    _____________________________________________________________");
            System.out.println("    "+line);
            System.out.println("    _____________________________________________________________");
            in = new Scanner(System.in);
            line = in.nextLine();
        }
    }

    public static void bye(){
        System.out.println("    Bye.Hope to see you again soon!");
        System.out.println("    _____________________________________________________________");
    }


}
