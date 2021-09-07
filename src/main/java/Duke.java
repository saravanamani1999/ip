import duke.exceptions.DukeException;
import duke.command.DukeCommand;
import java.util.Scanner;

public class Duke {

    private static final String HORIZONTAL_LINE_TOP = "\n______________________________" +
            "______________________________\n";
    private static final String HORIZONTAL_LINE_BOTTOM = "_______________________________" +
            "_____________________________\n";
    private static boolean hasUserExited = false;

    public static void exit() {
        System.out.println(HORIZONTAL_LINE_TOP + " Bye. Hope to see you again soon!\n" + HORIZONTAL_LINE_BOTTOM);
        hasUserExited = true;
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
            if (getUserInput.equals("bye")) {
                exit();
            } else {
                try {
                    DukeCommand.getCommand(getUserInput);
                } catch (IndexOutOfBoundsException e) {
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

}



