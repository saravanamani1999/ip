package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.ToDo;
import duke.exceptions.DukeException;
import duke.exceptions.InvalidCommandException;
import duke.exceptions.InvalidTaskNumberException;
import duke.exceptions.EventTimingException;
import duke.exceptions.DeadlineTimingException;

public class GetTasks extends DukeCommand {

    public static void followCommand(String getUserInput) throws DukeException {
        int taskNumber;
        String userCommand = (getUserInput.split(" "))[0];
        switch (userCommand) {
        case "done":
            description = getUserInput.split(" ");
            if (description.length < 2 || Integer.parseInt(description[1]) == 0) {
                throw new InvalidTaskNumberException();
            }
            taskNumber = Integer.parseInt(description[1]) - 1;
            if (tasks.get(taskNumber) == null) {
                throw new InvalidTaskNumberException();
            }
            if (tasks.get(taskNumber).getStatusIcon().equals("X")) {
                System.out.println(HORIZONTAL_LINE_TOP
                        + " I've already marked the task as done!\n"
                        + HORIZONTAL_LINE_BOTTOM);
            } else {
                tasks.get(taskNumber).markAsDone();
                System.out.println(tasks.get(taskNumber).printDone());
            }
            break;
        case "todo":
            description = getUserInput.split(" ");
            addTask(new ToDo(description[1], taskCount));
            break;
        case "deadline":
            int by = getUserInput.indexOf("/");
            separate = getUserInput.split("/by");
            description = separate[0].trim().split(" ");
            if ((by == -1 && (description[1] != null))
                    || (separate.length == 1)
                    || (separate[1].trim().isEmpty())) {
                throw new DeadlineTimingException();
            }
            String dueDate = separate[1].trim();
            addTask(new Deadline(description[1], dueDate, taskCount));
            break;
        case "event":
            int at = getUserInput.indexOf("/");
            separate = getUserInput.split("/at");
            description = separate[0].trim().split(" ");
            if ((at == -1 && (description[1] != null))
                    || (separate.length == 1)
                    || (separate[1].trim().isEmpty())) {
                throw new EventTimingException();
            }
            String eventTiming = separate[1].trim();
            addTask(new Event(description[1], eventTiming, taskCount));
            break;
        case "delete":
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
            break;
        default:
            throw new InvalidCommandException();
        }
    }

}

