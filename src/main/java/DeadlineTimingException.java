public class DeadlineTimingException extends DukeException {

    @Override
    public void sendMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + " ☹ OOPS!!! The deadline timing is missing\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

}
