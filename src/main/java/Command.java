public class Command {
    private static final int TODO_INDEX = 5;
    private static final int DEADLINE_INDEX = 9;
    private static final int EVENT_INDEX = 6;

    public static void handleListCommand(TaskList list) {
        list.printTaskList();
    }

    public static void handleDoneCommand(TaskList list, String line) {
        try {
            list.markIsDone(Integer.parseInt(line.substring(5).trim()));
            Storage.writeDukeTextFile(list);
        } catch (NullPointerException e) {
            Ui.printOutOfBounds();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        } catch (NumberFormatException e) {
            Ui.printWrongFormat();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        }
    }

    public static void handleTodoCommand(TaskList list, String line) {
        try {
            createToDoTask(line, list);
            Storage.writeDukeTextFile(list);
        } catch (TodoEmptyException e) {
            Ui.printTodoEmpty();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        }
    }

    public static void handleDeadlineCommand(TaskList list, String line) {
        try {
            createDeadlineTask(line, list);
            Storage.writeDukeTextFile(list);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printDeadlineNoDate();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        } catch (DeadlineEmptyException e) {
            Ui.printDeadlineEmpty();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        }
    }

    public static void handleEventCommand(TaskList list, String line) {
        try {
            createEventTask(line, list);
            Storage.writeDukeTextFile(list);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printEventNoDate();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        } catch (EventEmptyException e) {
            Ui.printEventEmpty();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        }
    }

    public static void handleDeleteCommand(TaskList list, String line) {
        try {
            list.deleteTask(Integer.parseInt(line.substring(7).trim()));
            Storage.writeDukeTextFile(list);
        } catch (NullPointerException e) {
            Ui.printOutOfBounds();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        } catch (NumberFormatException e) {
            Ui.printWrongFormat();
            Ui.printReferralMessage();
            Ui.printCommandGuide();
        }
    }

    public static void handleInvalidCommand() {
        Ui.printInvalidCommand();
        Ui.printReferralMessage();
        Ui.printCommandGuide();
    }

    public static void createToDoTask(String line, TaskList list) throws TodoEmptyException {
        if (line.substring(TODO_INDEX).trim().isEmpty()) {
            throw new TodoEmptyException();
        } else {
            Task task = new ToDo(line.substring(TODO_INDEX));
            list.addTaskList(task);
            Ui.printEcho(task, list);
        }
    }

    public static void createDeadlineTask(String line, TaskList list) throws DeadlineEmptyException, ArrayIndexOutOfBoundsException {
        String[] deadline = line.split("/by ");
        if (deadline[1] == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (deadline[0].substring(DEADLINE_INDEX).trim().isEmpty()) {
            throw new DeadlineEmptyException();
        } else if (deadline[1].trim().isEmpty()) {
            throw new DeadlineEmptyException();
        } else {
            Task task = new Deadline(deadline[0].substring(DEADLINE_INDEX), deadline[1]);
            list.addTaskList(task);
            Ui.printEcho(task, list);
        }
    }

    public static void createEventTask(String line, TaskList list) throws EventEmptyException, ArrayIndexOutOfBoundsException {
        String[] event = line.split("/at ");
        if (event[1] == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (event[0].substring(EVENT_INDEX).trim().isEmpty()) {
            throw new EventEmptyException();
        } else if (event[1].trim().isEmpty()) {
            throw new EventEmptyException();
        } else {
            Task task = new Event(event[0].substring(EVENT_INDEX), event[1]);
            list.addTaskList(task);
            Ui.printEcho(task, list);
        }
    }

}
