package duke.exceptions;

import duke.ui.Ui;

public class EventTimingException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(Ui.HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! The event timing is missing.\n"
                + Ui.HORIZONTAL_LINE_BOTTOM);
    }

}
