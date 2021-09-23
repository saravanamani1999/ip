package duke.command;

import duke.exceptions.DateTimeFormatException;
import duke.exceptions.EventTimingException;
import duke.task.Event;

import java.time.LocalDateTime;

public class EventCommand extends TaskList{

    public static void execute(String getUserInput) throws DateTimeFormatException, EventTimingException {
        int at = getUserInput.indexOf("/");
        separate = getUserInput.split("/at");
        description = separate[0].trim().split("event ");
        if ((at == -1 && (description[1] != null))
                || (separate.length == 1)
                || (separate[1].trim().isEmpty())) {
            throw new EventTimingException();
        } else if (!isValidDateTime(separate[1].trim())) {
            throw new DateTimeFormatException();
        } else {
            LocalDateTime eventTiming = LocalDateTime.parse(separate[1].trim(), formatter);
            addTask(new Event(description[1], eventTiming));
        }
    }

}
