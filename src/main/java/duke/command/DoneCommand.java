package main.java.duke.command;


import main.java.duke.exceptions.InvalidTaskNumberException;
import main.java.duke.storage.Storage;
import main.java.duke.ui.Ui;
import main.java.duke.Duke;


/** Includes the operations needed to execute {@code done} user command while managing any input errors. */
public class DoneCommand extends TaskList {

    /**
     * Executes the command {@code done} on the task list and marks the specified task based
     * on the user input as done with the use of "X" based on the task number provided from the task list.
     *
     * @param getUserInput The input given by the user to carry out on tasks list
     * @param taskNumber The Task ID which needs ot be deleted from the task list
     * @throws InvalidTaskNumberException 1. If the task ID is larger or lower than the
     * range of the size of the task list. 2. If the task ID is missing from the user input
     */
    public static void executeUserCommand(String getUserInput, int taskNumber) throws InvalidTaskNumberException {
        description = getUserInput.split("done ");
        if (description.length < 2 || Integer.parseInt(description[1]) == 0) {
            throw new InvalidTaskNumberException();
        }
        taskNumber = Integer.parseInt(description[1]) - 1;
        if (tasks.get(taskNumber) == null) {
            throw new InvalidTaskNumberException();
        }
        if (tasks.get(taskNumber).getStatusIcon().equals("X")) {
            Ui.markedAsDone();
        } else {
            tasks.get(taskNumber).markAsDone();
            Storage.saveToFile(Duke.file);
            System.out.println(tasks.get(taskNumber).printDone());
        }
    }

}
