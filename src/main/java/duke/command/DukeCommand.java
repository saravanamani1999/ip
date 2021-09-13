package duke.command;

import duke.task.Deadline;
import duke.task.Task;
import duke.exceptions.DukeException;
import duke.task.ToDo;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class DukeCommand extends Duke {

    protected static int taskCount = 0;
    protected static String[] description;
    protected static String[] separate;
    public static boolean isPlural = false;

    public static void readFile(String filePath, ArrayList<Task> tasks) throws FileNotFoundException {
        ArrayList<String> fileContents = new ArrayList<>();
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            fileContents.add(s.nextLine());
        }
        for (int i = 0; i < fileContents.size(); i++) {
            if (fileContents.get(i).startsWith("T")) {
                description = fileContents.get(i).split("]");
                tasks.add(new ToDo(description[1].trim()));
                if (fileContents.get(i).contains("[X]")) {
                    tasks.get(i).markAsDone();
                }
            } else if (fileContents.get(i).startsWith("D")) {
                int by = fileContents.get(i).indexOf("by:");
                separate = fileContents.get(i).split("by:");
                description = separate[0].trim().split("]");
                String dueDate = separate[1].trim();
                tasks.add(new Deadline(description[1].trim(), dueDate));
                if (fileContents.get(i).contains("[X]")) {
                    tasks.get(i).markAsDone();
                }
            } else if (fileContents.get(i).startsWith("E")) {
                int at = fileContents.get(i).indexOf("at:");
                separate = fileContents.get(i).split("at:");
                description = separate[0].trim().split("]");
                String eventTiming = separate[1].trim();
                tasks.add(new Deadline(description[1].trim(), eventTiming));
                if (fileContents.get(i).contains("[X]")) {
                    tasks.get(i).markAsDone();
                }
            }
        }
    }

    public static void writeToFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task task : tasks) {
            String formattedTask = null;
            formattedTask = task.fileContent();
            fw.write(formattedTask + System.lineSeparator());
        }
        fw.close();
    }

    public static void addTask(Task newTask) throws IOException {
        tasks.add(newTask);
        taskCount = tasks.size();
        if (taskCount > 1) {
            isPlural = true;
        }
        System.out.println(newTask.printOk() + taskCount + (isPlural ? " tasks" : " task")
                + " in the list.\n" + HORIZONTAL_LINE_BOTTOM);
    }

    public static void listTasks() {
        System.out.print(HORIZONTAL_LINE_TOP + " Here are the tasks in your list:\n");
        if(tasks.size() == 0) {
            System.out.println(" You have no tasks!");
        }
        int taskNumber;
        for (int i = 0; i < tasks.size(); i++) {
            taskNumber = i + 1;
            System.out.println(" " + taskNumber + tasks.get(i).printTask());
        }
        System.out.println(HORIZONTAL_LINE_BOTTOM);
    }

    public static void deleteTask(int taskNumber) {
        taskCount = tasks.size() - 1;
        isPlural = tasks.size() != 2;
        System.out.println(" " + tasks.get(taskNumber).printDelete() + "\nNow you have "
                + taskCount + (isPlural ? " tasks" : " task")
                + " in the list.\n" + HORIZONTAL_LINE_BOTTOM);
        tasks.remove(taskNumber);
    }

    public static void getCommand(String getUserInput) throws DukeException, IOException {
        String userCommand = (getUserInput.split(" "))[0];
        if (userCommand.equals("list")) {
            listTasks();
        } else {
            GetTasks.followCommand(getUserInput);
        }
    }

}


