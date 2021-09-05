public class EventTimingException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + " ☹ OOPS!!! The event timing is missing\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

}
