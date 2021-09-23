package duke.ui;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public static final String HORIZONTAL_LINE_TOP = "\n______________________________" +
            "______________________________";
    public static final String HORIZONTAL_LINE_BOTTOM = "______________________________" +
            "______________________________\n";

    public String readCommand(Scanner in) {
        return in.nextLine();
    }

    public static void printLineTop() {
        System.out.println(HORIZONTAL_LINE_TOP);
    }

    public static void printLineBottom() {
        System.out.println(HORIZONTAL_LINE_BOTTOM);
    }

    public static void welcomeMessage() {
        String logo = " DDDDD           kk\n"
                + " DD  DD  uu   uu kk  kk   eee\n"
                + " DD   DD uu   uu kkkkk  ee   e\n"
                + " DD   DD uu   uu kk kk  eeeee\n"
                + " DDDDDD   uuuu u kk  kk  eeeee\n";
        System.out.print(" Hello from\n\n" + logo);
        System.out.println(HORIZONTAL_LINE_TOP
                + "\n Hello! I'm Duke, your friendly neighbourhood task manager!\n"
                + " How can I help you?\n" + HORIZONTAL_LINE_BOTTOM);
    }

    public void exitMessage() {
        System.out.println(HORIZONTAL_LINE_TOP + "\n Bye. Hope to see you again soon!\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

    public static void ioExceptionMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! Something went wrong!." + "\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

    public void indexOutOfBoundsMessage(String command) {
        System.out.println(HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! The description of a " + command + " cannot be empty.\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

    public void numberFormatMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! Please input a valid task number to mark it as done.\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

    public void fileNotFoundMessage() {
        System.out.print(" File not found\n" + HORIZONTAL_LINE_BOTTOM);
    }

    public void tasksQuantity(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println(" No tasks found in the task file\n" + HORIZONTAL_LINE_BOTTOM);
        } else {
            System.out.println(" You have " + tasks.size()
                    +  " tasks.\n" + HORIZONTAL_LINE_BOTTOM);
        }
    }

    public static void markedAsDone() {
        System.out.println(HORIZONTAL_LINE_TOP + "\n I've already marked the task as done!\n" + HORIZONTAL_LINE_BOTTOM);
    }

    public static void noTasks() {
        System.out.println(" You have no tasks!");
    }

    public static void taskListHeader() {
        System.out.println(" Here are the tasks in your list:");
    }

    public static void matchesListHeader() {
        System.out.println(" Here are the matching tasks in your list:");
    }

    public static void noMatchesMessage() {
        System.out.println("\n ☹ There are no matching tasks found!");
    }

}
