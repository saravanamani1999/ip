package duke.command;

import duke.exceptions.DateTimeFormatException;
import duke.exceptions.DeadlineTimingException;
import duke.task.Deadline;

import java.time.LocalDateTime;

public class DeadLineCommand extends TaskList {

    public static void execute(String getUserInput) throws DeadlineTimingException, DateTimeFormatException {
        int by = getUserInput.indexOf("/");
        separate = getUserInput.split("/by");
        description = separate[0].trim().split("deadline ");
        if ((by == -1 && (description[1] != null))
                || (separate.length == 1)
                || (separate[1].trim().isEmpty())) {
            throw new DeadlineTimingException();
        } else if (!isValidDateTime(separate[1].trim())) {
            throw new DateTimeFormatException();
        } else {
            LocalDateTime dueDate = LocalDateTime.parse(separate[1].trim(), formatter);
            addTask(new Deadline(description[1], dueDate));
        }
    }

}
