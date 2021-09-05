public class DukeException extends Exception {

    protected static final String HORIZONTAL_LINE_TOP = "\n______________________________" +
            "______________________________\n";
    protected static final String HORIZONTAL_LINE_BOTTOM = "_______________________________" +
            "_____________________________\n";

    public void sendMessage() {
        System.out.println(HORIZONTAL_LINE_TOP
                + " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                + HORIZONTAL_LINE_BOTTOM);
    }

}
