package main.java.duke.command;

import main.java.duke.exceptions.DateTimeFormatException;
import main.java.duke.exceptions.DeadlineTimingException;
import main.java.duke.exceptions.EventTimingException;
import main.java.duke.task.Event;

import java.time.LocalDateTime;

/** Includes the operations needed to execute {@code event} user command while managing any input errors. */
public class EventCommand extends TaskList {

    /**
     * Executes the command {@code event} on the task list and adds event tasks to task list.
     *
     * @param getUserInput The input given by the user to carry out on tasks list
     * @throws EventTimingException If the parameter of timing for event is missing
     * @throws DateTimeFormatException If the event timing does not meet the format: "dd-MM-yyyy HH:mm"
     */
    public static void executeUserCommand(String getUserInput)
            throws DateTimeFormatException, EventTimingException {
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
