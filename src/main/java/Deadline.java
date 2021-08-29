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
        return super.toStringStart() + "  [D][] " + description + " (by: " + by + ")\n"  + super.toStringEnd();
    }
}
