package duke.storage;

import duke.command.TaskList;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;
import duke.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Storage class contains the operations required to store
 * the tasks into a text file and update the task list each
 * time Duke is launched using the text file.
 */
public class Storage {

    protected String filePath;
    protected static String[] description;
    protected static String[] separate;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Checks if the tasks in the text file is marked as done,
     * and if it is, it marks that task as done in the Duke task list.
     *
     * @param fileContents Array list of the tasks found in the text file
     * @param tasks Array list of the tasks updated onto Duke when launched
     * @param taskId The task number of each task
     */
    public static void checkDone(ArrayList<String> fileContents, ArrayList<Task> tasks, int taskId) {
        if (fileContents.get(taskId).contains("[X]")) {
            tasks.get(taskId).markAsDone();
        }
    }

    /**
     * Loads the tasks based on what type of task it is from
     * the text file and updates it onto the Duke task list.
     *
     * @param tasks Array list of the tasks updated onto Duke when launched
     * @param fileContents Array list of the tasks found in the text file
     */
    public static void loadTasks(ArrayList<Task> tasks, ArrayList<String> fileContents) {
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

    /**
     * Reads the file when Duke is launched and loads the tasks onto Duke.
     *
     * @param filePath File path indicating the location of text file in the directory
     * @param tasks Array list of the tasks updated onto Duke when launched
     * @throws FileNotFoundException If the file is not found in the specified location
     */
    public void readFile(String filePath, ArrayList<Task> tasks) throws FileNotFoundException {
        ArrayList<String> fileContents = new ArrayList<>();
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            fileContents.add(s.nextLine());
        }
        loadTasks(tasks, fileContents);
    }

    /**
     * Writes to the text file the task which the user has input onto Duke.
     *
     * @param filePath File path indicating the location of text file in the directory
     */
    public static void writeToFile(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Task task : TaskList.tasks) {
                String formattedTask = null;
                formattedTask = task.fileContent();
                fw.write(formattedTask + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            Ui.ioExceptionMessage();
        }
    }

    /**
     * Creates the text file in the specified path in the directory.
     *
     * @param filePath File path indicating the location of text file in the directory
     */
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
