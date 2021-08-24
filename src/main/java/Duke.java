import java.util.Scanner;
public class Duke {
        public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String horizontal = "    ____________________________________________________________";
        System.out.println(horizontal);
        System.out.println("     Hello! I'm Duke\n" + "     What can I do for you?");
        System.out.println(horizontal);
        String line;
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("");
            line = in.nextLine();
            if (line.equals("bye")){
                System.out.println(horizontal);
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println(horizontal);
                break;  
            }
            else{
                System.out.println(horizontal);
                System.out.println("     "+line);
                System.out.println(horizontal);
            }
            
            
        }
   
    }
}
