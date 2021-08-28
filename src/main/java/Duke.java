import java.util.Scanner;

public class Duke {
    private static final Task[] tasks = new Task[100];
    private static final String horizontalLine = "    ____________________________________________________________";
    private static int taskCount = 0;
    private static boolean hasUserExited = false;
    private static final String indent = "     ";

    public static void addTask(Task t) {
        tasks[taskCount] = t;
        System.out.println(t.toPrint());
        taskCount++;
    }

    public static void listOfTasks() {
        System.out.println(horizontalLine);
        if(taskCount == 0) {
            System.out.println("     You have no tasks!");
        }
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
            getUserInput = in.nextLine();
            if (getUserInput.equals("bye")) {
                exit();
            } else if (getUserInput.isEmpty()) {
                System.out.println(horizontalLine + indent + "\n Please input a task!\n" + horizontalLine);
            } else if (getUserInput.contains("done")) {
                int taskNumber = Integer.parseInt(getUserInput.substring(4).trim()) - 1;
                tasks[taskNumber].markAsDone();
                System.out.println(tasks[taskNumber].printDone());
            } else if (getUserInput.equals("list")) {
                listOfTasks();
            } else if (getUserInput.contains("todo")) {
                addTask(new ToDo(getUserInput.substring(4).trim(), taskCount));
            } else if(getUserInput.contains("deadline")) {
                int by = getUserInput.indexOf("/");
                addTask(new Deadline(getUserInput.substring(9, by - 1), getUserInput.substring(by + 4).trim(), taskCount));

            } else if(getUserInput.contains("event")) {
                int at = getUserInput.indexOf("/");
                addTask(new Event(getUserInput.substring(6, at - 1), getUserInput.substring(at + 4).trim(), taskCount));
            }
            else {
                addTask(new Task(getUserInput, taskCount));
            }
        }
    }
}



