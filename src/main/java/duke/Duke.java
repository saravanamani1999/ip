package duke;

import duke.command.TaskList;
import duke.exceptions.DukeException;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class Duke {

    public static boolean hasUserExited = false;
    public static String file = "data/duke.txt";
    private static Ui ui;
    public static TaskList taskList;

    public Duke(String filePath) {
        ui = new Ui();
        Storage storage = new Storage(filePath);
        taskList = new TaskList();
        Ui.welcomeMessage();
        try {
            storage.readFile(file, taskList.tasks);
        } catch (FileNotFoundException e) {
            ui.fileNotFoundMessage();
        }
        ui.tasksQuantity(taskList.tasks);
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (!hasUserExited) {
            String fullCommand = ui.readCommand(in);
            String userCommand = Parser.getCommandWord(fullCommand);
            try {
                taskList.executeCommand(fullCommand, userCommand);
            } catch (IndexOutOfBoundsException e) {
                ui.indexOutOfBoundsMessage(userCommand);
            } catch (NumberFormatException e) {
                ui.numberFormatMessage();
            } catch (DukeException e) {
                e.sendMessage();
            } catch (IOException e) {
                Ui.ioExceptionMessage();
            }
        }
        ui.exitMessage();
    }

    public static void main(String[] args) {
        new Duke(file).run();
    }

}



