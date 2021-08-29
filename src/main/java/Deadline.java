public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by, int taskCount) {
        super(description, taskCount);
        this.by = by;
    }

    public String getTaskType(){
        return "D";
    }

    public String toPrint() {
        return super.toStringStart() + "  [D][" + getStatusIcon() + "] " + description + " (by: " + by + ")\n"  + super.toStringEnd();
    }

    public String list() {
        return "     " + taskCount + "." + "[" + getTaskType() + "]" + "[" + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }
}
