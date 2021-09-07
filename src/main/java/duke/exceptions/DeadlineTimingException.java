package duke.exceptions;

public class DeadlineTimingException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(DukeException.HORIZONTAL_LINE_TOP
                + " ☹ OOPS!!! The deadline timing is missing.\n"
                + DukeException.HORIZONTAL_LINE_BOTTOM);
    }

}
