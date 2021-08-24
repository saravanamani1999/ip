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
        String line;
        Scanner in = new Scanner(System.in);
        String[] list = new String[100];
        int listCount = 0;
        while (true){
            System.out.println("");
            line = in.nextLine();
            if (line.equals("bye")){
                System.out.println(horizontal);
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println(horizontal);
                break;  
            }
            else if (line.equals("list")){
                System.out.println(horizontal);
                for (int x = 0; x < list.length; x += 1){
                    if(list[x] != null){
                        System.out.println("     " +(x+1)+ ". " + list[x]);
                    }
                }
                System.out.println(horizontal);

            }
            else {
                System.out.println(horizontal);
                System.out.println("     added: "+line);
                list[listCount] = line;
                listCount += 1;
                System.out.println(horizontal);
            }
            
            
        }
   
    }
}
