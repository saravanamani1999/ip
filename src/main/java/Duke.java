import java.util.Scanner;

public class Duke {

    private static Task[] tasks = new Task[100];
    public static final String HORIZONTAL_LINE_TOP = "\n______________________________" +
            "______________________________\n";
    public static final String HORIZONTAL_LINE_BOTTOM = "_______________________________" +
            "_____________________________\n";
    private static int taskCount = 0;
    private static boolean hasUserExited = false;

    public static void addTask(Task newTask) {
        tasks[taskCount] = newTask;
        System.out.println(newTask.printOk());
        taskCount++;
    }

    public static void listTasks() {
        System.out.print(HORIZONTAL_LINE_TOP + " Here are the tasks in your list:\n");
        if(taskCount == 0) {
            System.out.println(" You have no tasks!");
        }
        int count = 0;
        while (tasks[count] != null) {
            System.out.println(" " + tasks[count].printTask());
            count++;
        }
        System.out.println(HORIZONTAL_LINE_BOTTOM);
    }

    public static void exit() {
        System.out.println(HORIZONTAL_LINE_TOP + " Bye. Hope to see you again soon!\n" + HORIZONTAL_LINE_BOTTOM);
        hasUserExited = true;
    }

    public static void getCommand(String getUserInput) throws DukeException {
        String[] description;
        String[] separate;
        int inputSize;
        if (getUserInput.equals("bye")) {
            exit();
        } else if (getUserInput.equals("list")) {
            listTasks();
        } else if (getUserInput.startsWith("done ")) {
            description = getUserInput.split(" ");
            if (description.length < 2 || Integer.parseInt(description[1]) == 0) {
                throw new InvalidTaskNumberException();
            }
            int taskNumber = Integer.parseInt(description[1]) - 1;
            if (tasks[taskNumber] == null) {
                throw new InvalidTaskNumberException();
            }
            if (tasks[taskNumber].getStatusIcon().equals("X")) {
                System.out.println(HORIZONTAL_LINE_TOP + " I've already marked the task as done!\n"
                        + HORIZONTAL_LINE_BOTTOM);
            }
            else {
                tasks[taskNumber].markAsDone();
                System.out.println(tasks[taskNumber].printDone());
            }
        } else if (getUserInput.startsWith("todo ")) {
            description = getUserInput.split(" ");
            addTask(new ToDo(description[1], taskCount));
        } else if (getUserInput.startsWith("deadline ")) {
            int by = getUserInput.indexOf("/");
            separate = getUserInput.split("/by");
            description = separate[0].trim().split(" ");
            if ((by == -1 && (description[1] != null)) || (separate.length == 1)) {
                throw new DeadlineTimingException();
            }
            String dueDate = separate[1].trim();
            addTask(new Deadline(description[1], dueDate, taskCount));
        } else if (getUserInput.startsWith("event")) {
            int at = getUserInput.indexOf("/");
            separate = getUserInput.split("/at");
            description = separate[0].trim().split(" ");
            if ((at == -1 && (description[1] != null)) || (separate.length == 1)) {
                throw new DeadlineTimingException();
            }
            String eventTiming = separate[1].trim();
            addTask(new Event(description[1], eventTiming, taskCount));
        } else {
            throw new InvalidCommandException();
        }
    }

    public static void main(String[] args) {
        String logo = " DDDDD           kk\n"
                + " DD  DD  uu   uu kk  kk   eee\n"
                + " DD   DD uu   uu kkkkk  ee   e\n"
                + " DD   DD uu   uu kk kk  eeeee\n"
                + " DDDDDD   uuuu u kk  kk  eeeee\n";
        System.out.println(" Hello from\n\n" + logo);
        System.out.println(HORIZONTAL_LINE_TOP + " Hello! I'm Duke, your friendly neighbourhood task manager!\n"
                + " How can I help you?\n" + HORIZONTAL_LINE_BOTTOM);
        String getUserInput;
        Scanner in = new Scanner(System.in);

        while (!hasUserExited) {
            getUserInput = in.nextLine();
            String[] separate;
            separate = getUserInput.split(" ");
            String command;

            command = separate[0];
            try {
                getCommand(getUserInput);
            } catch (IndexOutOfBoundsException e){
                System.out.println(HORIZONTAL_LINE_TOP
                        + " ☹ OOPS!!! The description of a " + command + " cannot be empty.\n"
                        + HORIZONTAL_LINE_BOTTOM);
            } catch (NumberFormatException e) {
                System.out.println(HORIZONTAL_LINE_TOP
                        + " ☹ OOPS!!! Please input a valid task number to mark it as done.\n"
                        + HORIZONTAL_LINE_BOTTOM);
            } catch (DukeException e) {
                    e.sendMessage();
            }
        }
    }
}



