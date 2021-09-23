package duke.command;

import duke.task.ToDo;

public class ToDoCommand extends TaskList {

    public static void execute(String getUserInput) {
        description = getUserInput.split("todo ");
        if (description[1].trim().isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        addTask(new ToDo(description[1]));
    }

}
