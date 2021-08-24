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
        String[] list = new String[100];
        int listCount = 0;
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

            } else if (userInput.equals("list")){
                System.out.println(horizontal);

                if(list[0] == null){
                    System.out.println("     No tasks added.");
                }
                for (int x = 0; x < list.length; x += 1){
                    if(list[x] != null){
                        System.out.println("     "+ (x+1) + ". " + list[x]);
                    }
                }
                System.out.println(horizontal);

            } else {
                System.out.println(horizontal);
                System.out.println("     added: " + userInput);
                list[listCount] = userInput;
                listCount += 1;
                System.out.println(horizontal);
            }
            
            
        }

        in.close();
   
    }
}
