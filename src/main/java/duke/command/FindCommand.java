package duke.command;

import duke.ui.Ui;

public class FindCommand extends TaskList{

    public static void execute(String getUserInput) {
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
