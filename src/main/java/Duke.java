import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static Task[] tasks = new Task[100];
    private static String horizontalLine = "    ____________________________________________________________";
    private static int taskCount = 0;
    private static boolean hasUserExited = false;

    public static void addTask(Task t) {
        tasks[taskCount] = t;
        System.out.println(t.toPrint());
        taskCount++;
    }

    public static void listOfTasks() {
        System.out.println(horizontalLine);
        for (Task t : tasks) {
            if (t != null) {
                System.out.println(t.list());
            }
        }
        System.out.println(horizontalLine);
    }

    public static void exit() {
        System.out.println(horizontalLine + "\n     Bye. Hope to see you again soon!\n" + horizontalLine);
        hasUserExited = true;
    }

    public static void main(String[] args) {
        String logo = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("     Hello from\n" + logo);
        System.out.println(horizontalLine + "\n" + "     Hello! I'm Duke\n"
                + "     What can I do for you?\n" + horizontalLine);
        String getUserInput;
        Scanner in = new Scanner(System.in);

        while (!hasUserExited) {
            System.out.println("");
            getUserInput = in.nextLine();
            if (getUserInput.equals("bye")) {
                exit();
            } else if (getUserInput.length() > 3 && getUserInput.substring(0, 4).equals("done")) {
                int taskNumber = Integer.parseInt(getUserInput.substring(4, getUserInput.length()).trim()) - 1;
                tasks[taskNumber].markAsDone();
                System.out.println(tasks[taskNumber].printDone());
            } else if (getUserInput.equals("list")) {
                    listOfTasks();
            } else {
                addTask(new Task(getUserInput, taskCount));
            }
        }
    }
}



