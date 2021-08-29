public class Event extends Task {
    protected String at;

    public Event(String description, String at, int taskCount) {
        super(description, taskCount);
        this.at = at;
    }
    public String getTaskType() {
        return "E";
    }

    public String printOk() {
         return super.printOkStart() + "  [E][" + getStatusIcon() + "] " + description + " (at: " + at + ")\n" + super.printOkEnd();
    }

    public String list() {
        return "     " + taskCount + "." + "[" + getTaskType() + "]" + "[" + getStatusIcon() + "] " + description + " (at: " + at + ")";
    }

    public String printDone() {
        return horizontalLine + indent + "Nice! I've marked this task as done:\n     [" + getTaskType() + "][" + getStatusIcon() + "] " + description + " (at: " + at + ")" + "\n" + horizontalLine;
    }
}
