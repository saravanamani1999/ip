package duke.command;

import duke.Duke;
import duke.Ui;
import duke.exceptions.*;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.Storage;
import duke.task.ToDo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> tasks = new ArrayList<>();
    protected static int taskCount = 0;
    protected static String[] description;
    protected static String[] separate;
    public static boolean isPlural = false;
    public static final String LIST = "list";
    public static final String EXIT = "bye";
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DONE = "done";
    public static final String DELETE = "delete";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public void addTask(Task newTask) {
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

    public void deleteTask(int taskNumber) {
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
            LocalDateTime.parse(dateTime,formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public void executeCommand(String getUserInput, String userCommand) throws DukeException, IOException {
        int taskNumber;
        switch (userCommand) {
        case EXIT:
            Duke.hasUserExited = true;
            break;
        case LIST:
            listTasks();
            break;
        case DONE:
            description = getUserInput.split("done ");
            if (description.length < 2 || Integer.parseInt(description[1]) == 0) {
                throw new InvalidTaskNumberException();
            }
            taskNumber = Integer.parseInt(description[1]) - 1;
            if (tasks.get(taskNumber) == null) {
                throw new InvalidTaskNumberException();
            }
            if (tasks.get(taskNumber).getStatusIcon().equals("X")) {
                Ui.markedAsDone();
            } else {
                tasks.get(taskNumber).markAsDone();
                Storage.saveToFile(Duke.file);
                System.out.println(tasks.get(taskNumber).printDone());
            }
            break;
        case TODO:
            description = getUserInput.split("todo ");
            if (description[1].trim().isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            addTask(new ToDo(description[1]));

            break;
        case DEADLINE:
            int by = getUserInput.indexOf("/");
            separate = getUserInput.split("/by");
            description = separate[0].trim().split("deadline ");
            if ((by == -1 && (description[1] != null))
                    || (separate.length == 1)
                    || (separate[1].trim().isEmpty())) {
                throw new DeadlineTimingException();
            }
            if (!isValidDateTime(separate[1].trim())) {
                throw new DateTimeFormatException();
            } else {
                LocalDateTime dueDate = LocalDateTime.parse(separate[1].trim(), formatter);
                addTask(new Deadline(description[1], dueDate));
            }
            break;
        case EVENT:
            int at = getUserInput.indexOf("/");
            separate = getUserInput.split("/at");
            description = separate[0].trim().split("event ");
            if ((at == -1 && (description[1] != null))
                    || (separate.length == 1)
                    || (separate[1].trim().isEmpty())) {
                throw new EventTimingException();
            }
            if (!isValidDateTime(separate[1].trim())) {
                throw new DateTimeFormatException();
            } else {
                LocalDateTime eventTiming = LocalDateTime.parse(separate[1].trim(), formatter);
                addTask(new Event(description[1], eventTiming));
            }
            break;
        case DELETE:
            description = getUserInput.split(" ");
            if (description.length < 2 || Integer.parseInt(description[1]) == 0) {
                throw new InvalidTaskNumberException();
            }
            taskNumber = Integer.parseInt(description[1]) - 1;
            if (tasks.get(taskNumber) == null) {
                throw new InvalidTaskNumberException();
            } else {
                deleteTask(taskNumber);
            }
            break;
        default:
            throw new InvalidCommandException();
        }
    }

}


