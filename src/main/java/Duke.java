import java.util.Scanner;


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
        
        while (!userExit){

            System.out.println("");
            userInput = in.nextLine();

            if (userInput.equals("bye")){
                System.out.println(horizontal);
                System.out.println("     Bye. Hope to see you again soon!");  
                System.out.println(horizontal);
                userExit = true;  

            } else {
                System.out.println(horizontal);
                System.out.println("     " + userInput);
                System.out.println(horizontal);
            }
            
            
        }
        in.close();
   
    }
}
