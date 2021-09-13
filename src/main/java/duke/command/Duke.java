package duke.command;

import duke.exceptions.DukeException;
import duke.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static final String HORIZONTAL_LINE_TOP = "\n______________________________" +
            "______________________________\n";
    public static final String HORIZONTAL_LINE_BOTTOM = "_______________________________" +
            "_____________________________\n";
    private static boolean hasUserExited = false;
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static String file = "data/duke.txt";

    public static void checkFilePath(String filePath) {
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.getParentFile().mkdirs();
        }
    }

    public static void saveToFile(String filePath) {
        checkFilePath(filePath);
        try {
            DukeCommand.writeToFile(filePath);
        } catch (IOException e) {
            System.out.println(HORIZONTAL_LINE_TOP + " ☹ OOPS!!! Something went wrong!.\n" + HORIZONTAL_LINE_BOTTOM);
        }
    }

    public static void exitMessage() {
        System.out.println(HORIZONTAL_LINE_TOP + " Bye. Hope to see you again soon!\n" + HORIZONTAL_LINE_BOTTOM);
    }

    public static void main(String[] args) throws IOException {
        String logo = " DDDDD           kk\n"
                + " DD  DD  uu   uu kk  kk   eee\n"
                + " DD   DD uu   uu kkkkk  ee   e\n"
                + " DD   DD uu   uu kk kk  eeeee\n"
                + " DDDDDD   uuuu u kk  kk  eeeee\n";
        System.out.println(" Hello from\n\n" + logo);
        System.out.print(HORIZONTAL_LINE_TOP + " Hello! I'm duke.command.Duke, your friendly neighbourhood task manager!\n"
                + " How can I help you?\n" + HORIZONTAL_LINE_BOTTOM);
        try {
            DukeCommand.readFile(file, tasks);
        } catch (FileNotFoundException e) {
            System.out.print(" File not found\n" + HORIZONTAL_LINE_BOTTOM);
        }
        if (tasks.size() == 0) {
            System.out.println(" Tasks file empty\n" + HORIZONTAL_LINE_BOTTOM);
        } else {
            System.out.println(" Tasks loaded from file\n There are " + tasks.size() +  " tasks.\n" + HORIZONTAL_LINE_BOTTOM);

        }

        String getUserInput;
        Scanner in = new Scanner(System.in);

        while (!hasUserExited) {
            getUserInput = in.nextLine();
            String[] separate;
            separate = getUserInput.split(" ");
            String command;
            command = separate[0];
            if (getUserInput.equals("bye")) {
                hasUserExited = true;
            } else {
                try {
                    DukeCommand.getCommand(getUserInput);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(HORIZONTAL_LINE_TOP
                            + " ☹ OOPS!!! The description of a " + command + " cannot be empty.\n"
                            + HORIZONTAL_LINE_BOTTOM);
                } catch (NumberFormatException e) {
                    System.out.println(HORIZONTAL_LINE_TOP
                            + " ☹ OOPS!!! Please input a valid task number to mark it as done.\n"
                            + HORIZONTAL_LINE_BOTTOM);
                } catch (DukeException e) {
                    e.sendMessage();
                } catch (IOException e) {
                    System.out.println(HORIZONTAL_LINE_TOP
                            + " ☹ OOPS!!! Something went wrong!." + "\n"
                            + HORIZONTAL_LINE_BOTTOM);
                }
            }
        }
        saveToFile(file);
        exitMessage();
    }
}



