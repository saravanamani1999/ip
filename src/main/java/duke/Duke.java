package duke;

import duke.command.TaskList;
import duke.exceptions.DukeException;
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
        Ui.welcomeMessage();
        try {
            storage.readFile(file, TaskList.tasks);
        } catch (FileNotFoundException e) {
            ui.fileNotFoundMessage();
        }
        ui.tasksQuantity(TaskList.tasks);
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        while (!hasUserExited) {
            String fullCommand = ui.readCommand(in);
            String userCommand = Parser.getCommandWord(fullCommand);
            try {
                taskList.executeCommand(fullCommand, userCommand);
            } catch (IndexOutOfBoundsException e) {
                if (userCommand.equals("done") || userCommand.equals("delete")) {
                    System.out.println(Ui.HORIZONTAL_LINE_TOP
                            + "\n ☹ OOPS!!! Please input a valid task number.\n"
                            + Ui.HORIZONTAL_LINE_BOTTOM);
                }
                else {
                    ui.indexOutOfBoundsMessage(userCommand);
                }

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



