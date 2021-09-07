package duke.exceptions;

public class InvalidCommandException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

}
