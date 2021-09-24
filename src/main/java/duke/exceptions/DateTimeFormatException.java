package duke.exceptions;

import duke.ui.Ui;

/** Custom exception to catch formatting errors in regard to the deadline and event timings. */
public class DateTimeFormatException extends DukeException {

    @Override
    public void sendErrorMessage() {
        System.out.println(Ui.HORIZONTAL_LINE_TOP
                + "\n ☹ OOPS!!! The date and timing format is wrong.\n "
                + "Please represent date and time as: dd-mm-yyyy hh:mm\n"
                + Ui.HORIZONTAL_LINE_BOTTOM);
    }

}
