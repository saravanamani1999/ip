package duke.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public String getTaskType() {
        return "T";
    }

    public String printOk() {
        return super.printOkStart() + "  [T][" + getStatusIcon() + "] "
                + description + "\n" + super.printOkEnd();
    }

    public String printDone() {
        return horizontalLine + " Nice! I've marked this task as done:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + horizontalLine;
    }

}
