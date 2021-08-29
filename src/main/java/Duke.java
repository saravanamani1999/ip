import java.util.Scanner;

public class Duke {

    private static final Task[] tasks = new Task[100];
    private static final String horizontalLineTop = "\n____________________________________________________________\n";
    private static final String horizontalLineBottom = "____________________________________________________________\n";
    private static int taskCount = 0;
    private static boolean hasUserExited = false;

    public static void addTask(Task newTask) {
        tasks[taskCount] = newTask;
        System.out.println(newTask.printOk());
        taskCount++;
    }

    public static void listTasks() {
        System.out.print(horizontalLineTop + " Here are the tasks in your list:\n");
        if(taskCount == 0) {
            System.out.println(" You have no tasks!");
        }
        int count = 0;
        while (tasks[count] != null) {
            System.out.println(" " + tasks[count].printTask());
            count++;
        }
        System.out.println(horizontalLineBottom);
    }

    public static void exit() {
        System.out.println(horizontalLineTop + " Bye. Hope to see you again soon!\n" + horizontalLineBottom);
        hasUserExited = true;
    }

    public static void main(String[] args) {
        String logo = " DDDDD           kk\n"
                + " DD  DD  uu   uu kk  kk   eee\n"
                + " DD   DD uu   uu kkkkk  ee   e\n"
                + " DD   DD uu   uu kk kk  eeeee\n"
                + " DDDDDD   uuuu u kk  kk  eeeee\n";
        System.out.println(" Hello from\n\n" + logo);
        System.out.println(horizontalLineTop + " Hello! I'm Duke, your friendly neighbourhood task manager!\n"
                + " How can I help you?\n" + horizontalLineBottom);
        String getUserInput;
        String description;
        int inputSize;
        Scanner in = new Scanner(System.in);

        while (!hasUserExited) {
            getUserInput = in.nextLine();
            if (getUserInput.equals("bye")) {
                exit();
            } else if (getUserInput.isEmpty()) {
                System.out.println(horizontalLineTop + " Please input a task!\n" + horizontalLineBottom);
            } else if (getUserInput.equals("list")) {
                listTasks();
            } else if (getUserInput.startsWith("done")) {
                inputSize = "done".length();
                description = getUserInput.substring(inputSize).trim();
                int taskNumber = Integer.parseInt(description) - 1;
                tasks[taskNumber].markAsDone();
                System.out.println(tasks[taskNumber].printDone());
            } else if (getUserInput.startsWith("todo")) {
                inputSize = "todo".length();
                description = getUserInput.substring(inputSize).trim();
                addTask(new ToDo(description, taskCount));
            } else if(getUserInput.startsWith("deadline")) {
                int by = getUserInput.indexOf("/");
                inputSize = "deadline".length();
                description = getUserInput.substring(inputSize + 1, by - 1);
                String eventTiming = getUserInput.substring(by + 4).trim();
                addTask(new Deadline(description, eventTiming, taskCount));
            } else if(getUserInput.startsWith("event")) {
                int at = getUserInput.indexOf("/");
                inputSize = "event".length();
                description = getUserInput.substring(inputSize + 1, at - 1);
                String eventTiming = getUserInput.substring(at + 4).trim();
                addTask(new Event(description, eventTiming, taskCount));
            } else {
                addTask(new Task(getUserInput, taskCount));
            }
        }
    }
}



