public class Event extends Task {
    protected String at;

    public Event(String description, String at, int taskCount) {
        super(description, taskCount);
        this.at = at;
    }

    public String getTaskType(){
        return "E";
    }

    public String toPrint() {
         return super.toStringStart() + "  [E][" + getStatusIcon() + "] " + description + " (at: " + at + ")\n" + super.toStringEnd();
    }

    public String list() {
        return "     " + taskCount + "." + "[" + getTaskType() + "]" + "[" + getStatusIcon() + "] " + description + " (at: " + at + ")";
    }
}
