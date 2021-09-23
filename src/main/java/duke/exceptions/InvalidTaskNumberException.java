package duke.exceptions;

import duke.ui.Ui;

public class InvalidTaskNumberException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(Ui.HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! Please input a valid task number.\n"
                + Ui.HORIZONTAL_LINE_BOTTOM);
    }

}
