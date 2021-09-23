package duke.command;

import duke.Duke;
import duke.exceptions.InvalidTaskNumberException;
import duke.storage.Storage;
import duke.ui.Ui;

public class DoneCommand extends TaskList {

    public static void execute(String getUserInput, int taskNumber) throws InvalidTaskNumberException {
        description = getUserInput.split("done ");
        taskNumber = Integer.parseInt(description[1]) - 1;
        if (Integer.parseInt(description[1]) == 0) {
            throw new InvalidTaskNumberException();
        } else if (tasks.get(taskNumber).getStatusIcon().equals("X")) {
            Ui.markedAsDone();
        } else {
            tasks.get(taskNumber).markAsDone();
            Storage.saveToFile(Duke.file);
            System.out.println(tasks.get(taskNumber).printDone());
        }
    }
}
