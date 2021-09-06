public class DukeCommand {

    protected static Task[] tasks = new Task[100];
    protected static final String HORIZONTAL_LINE_TOP = "\n______________________________" +
            "______________________________\n";
    protected static final String HORIZONTAL_LINE_BOTTOM = "_______________________________" +
            "_____________________________\n";
    protected static int taskCount = 0;
    protected static String[] description;
    protected static String[] separate;

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

    public static void getCommand(String getUserInput) throws DukeException {
        String userCommand = (getUserInput.split(" "))[0];
        if (userCommand.equals("list")) {
            listTasks();
        } else {
            GetTasks.followCommand(getUserInput);
        }
    }

}


