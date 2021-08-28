public class Task {
    protected String description;
    protected boolean isDone;
    protected String horizontalLine = "    ____________________________________________________________\n";
    protected int taskCount;
    protected String indent = "     ";

    public Task(String description, int taskCount) {
        this.description = description;
        this.taskCount = taskCount + 1;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }
    
    public boolean isDone() {
        return isDone;
    }

    public String getTaskType(){
        return " ";
    }

    public String list() {
        return "     " + taskCount + "." + "[" + getTaskType() + "]" + "[" + getStatusIcon() + "] " + description;
    }

    public String toPrint() {
        return horizontalLine + indent + "added: " + description + System.lineSeparator() + horizontalLine;
    }

    public String printDone() {
        return horizontalLine + indent + "Nice! I've marked this task as done:\n" + "       [" + getStatusIcon() + "] " + description + System.lineSeparator() + horizontalLine;
    }
}
