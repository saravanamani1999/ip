package duke.exceptions;

public class InvalidTaskNumberException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + "  ☹ OOPS!!! Please input a valid task number.\n"
                + HORIZONTAL_LINE_BOTTOM);
    }
}
