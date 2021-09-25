package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    protected String filePath;
    protected static String[] description;
    protected static String[] separate;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public static void checkDone(ArrayList<String> fileContents, ArrayList<Task> tasks, int taskId) {
        if (fileContents.get(taskId).contains("[X]")) {
            tasks.get(taskId).markAsDone();
        }
    }

    public static void updateTasks(ArrayList<Task> tasks, ArrayList<String> fileContents) {
        for (int i = 0; i < fileContents.size(); i++) {
            if (fileContents.get(i).startsWith("T")) {
                description = fileContents.get(i).split("]");
                tasks.add(new ToDo(description[1].trim()));
                checkDone(fileContents, tasks, i);
            } else if (fileContents.get(i).startsWith("D")) {
                separate = fileContents.get(i).split("by:");
                description = separate[0].trim().split("]");
                LocalDateTime dueDate = LocalDateTime.parse(separate[1].trim());
                tasks.add(new Deadline(description[1].trim(), dueDate));
                checkDone(fileContents, tasks, i);
            } else if (fileContents.get(i).startsWith("E")) {
                separate = fileContents.get(i).split("at:");
                description = separate[0].trim().split("]");
                LocalDateTime eventTiming = LocalDateTime.parse(separate[1].trim());
                tasks.add(new Event(description[1].trim(), eventTiming));
                checkDone(fileContents, tasks, i);
            }
        }
    }

    public void readFile(String filePath, ArrayList<Task> tasks) throws FileNotFoundException {
        ArrayList<String> fileContents = new ArrayList<>();
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            fileContents.add(s.nextLine());
        }
        updateTasks(tasks, fileContents);
    }

    public static void writeToFile(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Task task : Duke.taskList.tasks) {
                String formattedTask = null;
                formattedTask = task.fileContent();
                fw.write(formattedTask + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            Ui.ioExceptionMessage();
        }
    }

    public static void createFilePath(String filePath) {
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.getParentFile().mkdirs();
        }
    }

    public static void saveToFile(String filePath) {
        createFilePath(filePath);
        writeToFile(filePath);
    }

}
