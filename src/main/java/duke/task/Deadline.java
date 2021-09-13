package duke.task;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getTaskType() {
        return "D";
    }

    public String printOk() {
        return super.printOkStart() + "  [D][" + getStatusIcon() + "] "
                + description + " (by: " + by + ")\n"  + super.printOkEnd();
    }

    public String printTask() {
        return taskCount + "." + "[" + getTaskType() + "]" + "["
                + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }

    public String printDone() {
        return horizontalLine + " Nice! I've marked this task as done:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + " (by: " + by + ")" + horizontalLine;
    }

}
