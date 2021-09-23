package duke.exceptions;

import duke.ui.Ui;

public class InvalidCommandException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(Ui.HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                + Ui.HORIZONTAL_LINE_BOTTOM);
    }

}
