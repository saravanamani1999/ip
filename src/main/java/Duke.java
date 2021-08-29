import java.util.Scanner;

public class Duke {
    private static final Task[] tasks = new Task[100];
    private static final String horizontalLine = "    ____________________________________________________________\n";
    private static int taskCount = 0;
    private static boolean hasUserExited = false;
    private static final String indent = "     ";

    public static void addTask(Task newTask) {
        tasks[taskCount] = newTask;
        System.out.println(newTask.printOk());
        taskCount++;
    }

    public static void listTasks() {
        System.out.print(horizontalLine);
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
        System.out.println(horizontalLine + "     Bye. Hope to see you again soon!\n" + horizontalLine);
        hasUserExited = true;
    }

    public static void main(String[] args) {
        String logo = "     DDDDD           kk\n"
                + "     DD  DD  uu   uu kk  kk   eee\n"
                + "     DD   DD uu   uu kkkkk  ee   e\n"
                + "     DD   DD uu   uu kk kk  eeeee\n"
                + "     DDDDDD   uuuu u kk  kk  eeeee\n";
        System.out.println("     Hello from\n\n" + logo);
        System.out.println(horizontalLine + "     Hello! I'm Duke, your friendly neighbourhood task manager!\n"
                + "     How can I help you?\n" + horizontalLine);
        String getUserInput;
        Scanner in = new Scanner(System.in);

        while (!hasUserExited) {
            getUserInput = in.nextLine();
            if (getUserInput.equals("bye")) {
                exit();
            } else if (getUserInput.isEmpty()) {
                System.out.println(horizontalLine + indent + " Please input a task!\n" + horizontalLine);
            } else if (getUserInput.contains("done")) {
                int taskNumber = Integer.parseInt(getUserInput.substring(4).trim()) - 1;
                tasks[taskNumber].markAsDone();
                System.out.println(tasks[taskNumber].printDone());
            } else if (getUserInput.equals("list")) {
                listTasks();
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



