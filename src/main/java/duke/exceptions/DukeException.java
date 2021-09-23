package duke.exceptions;

import duke.ui.Ui;

public class DukeException extends Exception {

    public void sendMessage() {
        System.out.println(Ui.HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! ...Error message...\n"
                + Ui.HORIZONTAL_LINE_BOTTOM);
    }

}
