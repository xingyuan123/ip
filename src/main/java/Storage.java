import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Storage {
    public static void SetupFile(TaskList list) {
        File dukeTextFile = new File("Duke.txt");
        if (!dukeTextFile.exists()) {
            try {
                dukeTextFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            loadDukeTextFile(dukeTextFile, list);
        }
    }

    public static void loadDukeTextFile(File dukeTextFile, TaskList list) {
        try {
            Scanner dukeTextScanner = new Scanner(dukeTextFile);
            while (dukeTextScanner.hasNextLine()) {
                String dukeTextLine = dukeTextScanner.nextLine();
                String taskLetter = dukeTextLine.substring(0, 1);
                if (taskLetter.equals("T")) {
                    String[] dukeLineSplit = dukeTextLine.split("\\|", 3);
                    String todoDescription = dukeLineSplit[2];
                    Task task = new ToDo(todoDescription);
                    list.addTaskList(task);
                } else if (taskLetter.equals("D")) {//Deadline
                    String[] dukeLineSplit = dukeTextLine.split("\\|", 4);
                    String deadlineDescription = dukeLineSplit[2].trim();
                    String deadlineBy = dukeLineSplit[3].trim();
                    Task task = new Deadline(deadlineDescription, deadlineBy);
                    list.addTaskList(task);
                } else {
                    String[] dukeLineSplit = dukeTextLine.split("\\|", 4);
                    String eventDescription = dukeLineSplit[2].trim();
                    String eventAt = dukeLineSplit[3].trim();
                    Task task = new Event(eventDescription, eventAt);
                    list.addTaskList(task);
                }
            }
            writeDukeTextFile(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeDukeTextFile(TaskList list) {
        File dukeTextFile = new File("Duke.txt");
        try {
            FileWriter dukeTextWriter = new FileWriter(dukeTextFile);
            int lineNumber = list.getTaskListCount();
            for (int i = 0; i < lineNumber; i++) {
                dukeTextWriter.write(list.textString(i));
            }
            dukeTextWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}