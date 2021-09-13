package duke.command;

import duke.task.Task;
import duke.exceptions.DukeException;

import java.util.ArrayList;

public class DukeCommand {
    public static ArrayList<Task> tasks = new ArrayList<>();
    protected static final String HORIZONTAL_LINE_TOP = "\n______________________________" +
            "______________________________\n";
    protected static final String HORIZONTAL_LINE_BOTTOM = "_______________________________" +
            "_____________________________\n";
    protected static int taskCount = 0;
    protected static String[] description;
    protected static String[] separate;
    protected static boolean isPlural = false;

    public static void addTask(Task newTask) {
        tasks.add(newTask);
        taskCount = tasks.size();
        System.out.println(newTask.printOk());
    }

    public static void listTasks() {
        System.out.print(HORIZONTAL_LINE_TOP + " Here are the tasks in your list:\n");
        if(tasks.size() == 0) {
            System.out.println(" You have no tasks!");
        }
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + tasks.get(count).printTask());
            count++;
        }
        System.out.println(HORIZONTAL_LINE_BOTTOM);
    }

    public static void deleteTask(int taskNumber) {
        taskCount = tasks.size() - 1;
        if (taskCount != 1) {
            isPlural = true;
        }
        System.out.print(" " + tasks.get(taskNumber).printDelete() + "\nNow you have "
                + taskCount + (isPlural ? " tasks" : " task")
                + " in the list.\n" + HORIZONTAL_LINE_BOTTOM);
        tasks.remove(taskNumber);
    }

    public static void getCommand(String getUserInput) throws DukeException {
        String userCommand = (getUserInput.split(" "))[0];
        if (userCommand.equals("list")) {
            listTasks();
        } else {
            GetTasks.followCommand(getUserInput);
        }
    }

}


