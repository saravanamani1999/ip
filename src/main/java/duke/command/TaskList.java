package duke.command;

import duke.Duke;
import duke.ui.Ui;
import duke.exceptions.DukeException;
import duke.exceptions.InvalidCommandException;
import duke.task.Task;
import duke.storage.Storage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class TaskList {

    public static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<Task> matches = new ArrayList<>();
    protected static int taskCount = 0;
    protected static String[] description;
    protected static String[] separate;
    private static boolean isPlural = false;
    private static final String LIST = "list";
    private static final String EXIT = "bye";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String DONE = "done";
    private static final String DELETE = "delete";
    private static final String FIND = "find";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static void addTask(Task newTask) {
        tasks.add(newTask);
        Storage.saveToFile(Duke.file);
        taskCount = tasks.size();
        if (taskCount > 1) {
            isPlural = true;
        }
        System.out.println(newTask.printOk() + taskCount + (isPlural ? " tasks" : " task")
                + " in the list.");
        Ui.printLineBottom();
    }

    public void listTasks() {
        Ui.printLineTop();
        Ui.taskListHeader();
        if(tasks.size() == 0) {
            Ui.noTasks();
        }
        int taskNumber;
        for (int i = 0; i < tasks.size(); i++) {
            taskNumber = i + 1;
            System.out.println(" " + taskNumber + tasks.get(i).printTask());
        }
        Ui.printLineBottom();
    }

    public static void deleteTask(int taskNumber) {
        taskCount = tasks.size() - 1;
        isPlural = tasks.size() != 2;
        System.out.println(" " + tasks.get(taskNumber).printDelete() + "\nNow you have "
                + taskCount + (isPlural ? " tasks" : " task")
                + " in the list.");
        Ui.printLineBottom();
        tasks.remove(taskNumber);
        Storage.saveToFile(Duke.file);
    }

    public static boolean isValidDateTime(String dateTime) {
        try {
            LocalDateTime.parse(dateTime, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static void getMatches(String search, ArrayList<Task> list) {
        matches.clear();
        for(Task task: list) {
            if (task.description.contains(search)) {
                matches.add(task);
            }
        }
    }

    public void executeCommand(String getUserInput, String userCommand) throws DukeException, IOException {
        int taskNumber = 0;
        switch (userCommand) {
        case EXIT:
            Duke.hasUserExited = true;
            break;
        case LIST:
            listTasks();
            break;
        case DONE:
            DoneCommand.execute(getUserInput,taskNumber);
            break;
        case TODO:
             ToDoCommand.execute(getUserInput);
            break;
        case DEADLINE:
            DeadLineCommand.execute(getUserInput);
            break;
        case EVENT:
            EventCommand.execute(getUserInput);
            break;
        case DELETE:
            DeleteCommand.execute(getUserInput,taskNumber);
            break;
        case FIND:
            FindCommand.execute(getUserInput);
            break;
        default:
            throw new InvalidCommandException();
        }
    }

}


