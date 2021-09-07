package exceptions;

import exceptions.DukeException;

public class InvalidTaskNumberException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + "  ☹ OOPS!!! Please input a valid task number to mark it as done.\n"
                + HORIZONTAL_LINE_BOTTOM);
    }
}
