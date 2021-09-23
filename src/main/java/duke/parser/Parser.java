package duke.parser;

public class Parser {

    public static String getCommandWord(String fullCommand) {
        String[] separate;
        separate = fullCommand.split(" ");
        return separate[0];
    }

}
