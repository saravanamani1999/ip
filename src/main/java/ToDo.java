public class ToDo extends Task{
    public ToDo(String description, int taskCount) {
        super(description, taskCount);
    }

    public String getTaskType(){
        return "T";
    }

    public String toPrint() {
        return super.toStringStart() + "  [T][" + getStatusIcon() + "] " + description + "\n" + super.toStringEnd();
    }
}
