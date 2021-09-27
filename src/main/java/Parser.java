public class Parser {

    public static boolean parse(TaskList list, String line) {
        if (line.equals("list")) {
            Command.handleListCommand(list);
        } else if (line.startsWith("done")) {
            Command.handleDoneCommand(list, line);
        } else if (line.startsWith("todo ")) {
            Command.handleTodoCommand(list, line);
        } else if (line.startsWith("deadline ")) {
            Command.handleDeadlineCommand(list, line);
        } else if (line.startsWith("event")) {
            Command.handleEventCommand(list, line);
        } else if (line.startsWith("delete")) {
            Command.handleDeleteCommand(list, line);
        } else if (line.equals("bye")) {
            return false;
        } else {
            Command.handleInvalidCommand();
        }
        return true;
    }


}
