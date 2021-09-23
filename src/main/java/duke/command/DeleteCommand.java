package duke.command;

import duke.exceptions.InvalidTaskNumberException;

public class DeleteCommand extends TaskList{

    public static void execute(String getUserInput, int taskNumber) throws InvalidTaskNumberException {
        description = getUserInput.split(" ");
        if (description.length < 2 || Integer.parseInt(description[1]) == 0) {
            throw new InvalidTaskNumberException();
        }
        taskNumber = Integer.parseInt(description[1]) - 1;
        if (tasks.get(taskNumber) == null) {
            throw new InvalidTaskNumberException();
        } else {
            deleteTask(taskNumber);
        }
    }

}
