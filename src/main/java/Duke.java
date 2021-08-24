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
        String horizontal = "    ____________________________________________________________";
        System.out.println(horizontal);
        System.out.println("     Hello! I'm Duke\n" + "     What can I do for you?");
        System.out.println(horizontal);
        String userInput;
        Scanner in = new Scanner(System.in);
        boolean userExit = false;
        ArrayList<Task> list = new ArrayList<>();
        
        while (!userExit){

            System.out.println("");
            userInput = in.nextLine();

            if (userInput.equals("bye")){
                System.out.println(horizontal);
                System.out.println("     Bye. Hope to see you again soon!");  
                System.out.println(horizontal);
                userExit = true;  

            } else if (userInput.equals("list")){
                System.out.println(horizontal);

                if(list.size() == 0){
                    System.out.println("     No tasks added.");
                }
                for (int x = 0; x < list.size(); x += 1){
                    System.out.println("     "+ (x+1) + "." + "[" 
                                        + list.get(x).getStatusIcon() + "] " 
                                        + list.get(x).description);
                    
                }
                System.out.println(horizontal);
            }

            else if (userInput.length() > 3 && userInput.substring(0, 4).equals("done")){

                String digit = userInput.substring(4, userInput.length()).trim();
                int taskNumber = Integer.parseInt(digit) - 1;
                System.out.println(horizontal);
                if (list.get(taskNumber).isDone){
                    System.out.println("     Task is already marked as done.");
                } else{
                    list.get(taskNumber).markAsDone();
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       [" + list.get(taskNumber).getStatusIcon() + "] " 
                                        + list.get(taskNumber).description);
                }

                System.out.println(horizontal);


            } else {
                System.out.println(horizontal);
                System.out.println("     added: " + userInput);
                list.add(new Task(userInput));
                System.out.println(horizontal);
            }    
        }

        in.close();
    }
}

