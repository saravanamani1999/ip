package duke.exceptions;

public class DateTimeFormatException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(DukeException.HORIZONTAL_LINE_TOP
                + " ☹ OOPS!!! The date and timing format is wrong.\n Please represent date and time as: dd-mm-yyyy hh:mm\n"
                + DukeException.HORIZONTAL_LINE_BOTTOM);
    }

}
