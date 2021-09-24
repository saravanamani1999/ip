package duke;

import duke.command.TaskList;
import duke.exceptions.DukeException;
import duke.exceptions.InvalidTaskNumberException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.ui.Ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class Duke {

    public static boolean hasUserExited = false;
    public static String file = "data/duke.txt";
    private static TaskList taskList;
    private static Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        Storage storage = new Storage(filePath);
        taskList = new TaskList();
        Ui.sendWelcomeMessage();
        try {
            storage.readFile(file, TaskList.tasks);
        } catch (FileNotFoundException e) {
            ui.fileNotFoundMessage();
        }
        ui.tasksQuantity(TaskList.tasks);
    }

    /**
     * Method to run the full flow of Duke starting with the welcome message,
     * followed by running the execution of the user commands and sends the exit message
     * when the user inputs {@code bye}.
     */
    private void run() {
        Scanner in = new Scanner(System.in);
        while (!hasUserExited) {
            String fullCommand = ui.readCommand(in);
            String userCommand = Parser.getCommandWord(fullCommand);
            try {
                taskList.executeCommand(fullCommand, userCommand);
            } catch (IndexOutOfBoundsException e) {
                if (userCommand.equals("done") || userCommand.equals("delete")) {
                    InvalidTaskNumberException.sendErrorMessage();
                }
                else {
                    ui.indexOutOfBoundsMessage(userCommand);
                }
            } catch (NumberFormatException e) {
                InvalidTaskNumberException.sendErrorMessage();
            } catch (DukeException e) {
                e.sendErrorMessage();
            } catch (IOException e) {
                Ui.ioExceptionMessage();
            } catch (InvalidTaskNumberException e) {
                InvalidTaskNumberException.sendErrorMessage();
            }
        }
        ui.sendExitMessage();
    }

    public static void main(String[] args) {
        new Duke(file).run();
    }

}



