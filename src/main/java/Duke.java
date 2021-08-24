import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("     Hello from\n" + logo);
        String horizontalLine = "    ____________________________________________________________";
        System.out.println(horizontalLine + "\n" + "     Hello! I'm Duke\n" + "     What can I do for you?\n" + horizontalLine);
        String userInput;
        Scanner in = new Scanner(System.in);
        boolean userExited = false;
        ArrayList<Task> tasks = new ArrayList<>();
        
        while (!userExited){
            System.out.println("");
            userInput = in.nextLine();

            if (userInput.equals("bye")) {   

                System.out.println(horizontalLine);
                exit();
                System.out.println(horizontalLine);
                userExited = true; 

            } else if (userInput.equals("list")) {

                System.out.println(horizontalLine);
                listOfTasks(tasks);
                System.out.println(horizontalLine);

            } else if (userInput.length() > 3 && userInput.substring(0, 4).equals("done")) {

                System.out.println(horizontalLine);
                markedAsDone(tasks, userInput);
                System.out.println(horizontalLine);

            } else {

                System.out.println(horizontalLine);
                addToList(tasks, userInput);
                System.out.println(horizontalLine);

            }    
        }

    }

    public static void listOfTasks(ArrayList<Task> tasks) {
        if(tasks.size() == 0){
            System.out.println("     No tasks added.");
        }
        for (int x = 0; x < tasks.size(); x += 1) {
            System.out.println("     " + (x + 1) + "." + "[" + tasks.get(x).getStatusIcon() + "] " + tasks.get(x).description);  
        }

    }

    public static void exit() {
        System.out.println("     Bye. Hope to see you again soon!");  
    }

    public static void markedAsDone(ArrayList<Task> tasks, String userInput) {
        String digit = userInput.substring(4, userInput.length()).trim();
        int taskNumber = Integer.parseInt(digit) - 1;

        if (tasks.get(taskNumber).isDone){
            System.out.println("     Task is already marked as done.");
        } else {
            tasks.get(taskNumber).markAsDone();
            System.out.println("     Nice! I've marked this task as done:");
            System.out.println("       [" + tasks.get(taskNumber).getStatusIcon() + "] " + tasks.get(taskNumber).description);
        }
    }

    public static void addToList(ArrayList<Task> tasks, String userInput){
        if (userInput.length() > 0){  
            System.out.println("     added: " + userInput);
            tasks.add(new Task(userInput));
        } else {
            System.out.println("     Please type in a task.");
        }
    }
    
}

