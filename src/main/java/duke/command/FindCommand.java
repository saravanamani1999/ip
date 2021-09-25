package main.java.duke.command;

import main.java.duke.ui.Ui;

/** Includes the operations needed to execute {@code find} user command. */
public class FindCommand extends TaskList {

    /**
     * Executes the command {@code find} on the task list and finds matching tasks in the task list
     * based on the "description" which represents the user's query.
     *
     * @param getUserInput The input given by the user to carry out on tasks list
     * @throws IndexOutOfBoundsException If specified index is out of the range of the size of the tasks list
     */
    public static void executeUserCommand(String getUserInput) throws IndexOutOfBoundsException {
        description = getUserInput.split("find ");
        if (description[1].trim().isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        getMatches(description[1],tasks);
        int taskId = 0;
        Ui.printLineTop();
        Ui.matchesListHeader();
        if (matches.size() == 0) {
            Ui.noMatchesMessage();
        }
        for (int i = 0; i < matches.size(); i++) {
            taskId = i + 1;
            System.out.println(" " + taskId + matches.get(i).printTask());
        }
        Ui.printLineBottom();
    }

}
