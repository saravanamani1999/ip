public class ToDo extends Task{
    public ToDo(String description, int taskCount) {
        super(description, taskCount);
    }

    public String getTaskType(){
        return "T";
    }

    public String toPrint() {
        return super.horizontalLine +  super.indent + "Got it. I've added this task:\n" + super.indent + "  [T][" + getStatusIcon() + "] " + description + super.horizontalLine;
    }
}
