package duke.exceptions;

import duke.ui.Ui;

/**
 * Super class exception which contains the method {@code sendMessage()} which is then
 * overridden by its subclasses to send custom message for each custom exception.
 */
public class DukeException extends Exception {

    public void sendErrorMessage() {
        System.out.println(Ui.HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! ...Error message...\n"
                + Ui.HORIZONTAL_LINE_BOTTOM);
    }

}
