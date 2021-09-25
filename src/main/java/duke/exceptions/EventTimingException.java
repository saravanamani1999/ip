package duke.exceptions;

import duke.ui.Ui;

/** Custom exception to catch missing event timings in the user input. */
public class EventTimingException extends DukeException {

    @Override
    public void sendErrorMessage() {
        System.out.println(Ui.HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! The event timing is missing.\n"
                + Ui.HORIZONTAL_LINE_BOTTOM);
    }

}
