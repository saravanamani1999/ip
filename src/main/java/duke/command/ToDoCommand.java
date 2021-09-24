package duke.command;

import duke.exceptions.DateTimeFormatException;
import duke.exceptions.DeadlineTimingException;
import duke.task.ToDo;

public class ToDoCommand extends TaskList {

    /**
     * Executes the command {@code todo} which adds todo tasks to the task list
     * where "description" is the description of the task
     *
     * @param getUserInput The input given by the user to carry out on tasks list
     */
    public static void executeUserCommand(String getUserInput) {
        description = getUserInput.split("todo ");
        if (description[1].trim().isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        addTask(new ToDo(description[1]));
    }

}
