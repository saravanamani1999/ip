public class Task {
    protected String description;
    protected boolean isDone;
    protected String horizontalLine = "    ____________________________________________________________";
    protected int taskCount;

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

    public String list() {
        return "     " + taskCount + "." + "[" + getStatusIcon() + "] " + description;
    }

    public String toPrint() {
        return horizontalLine + System.lineSeparator() + "     added: " + description + System.lineSeparator() + horizontalLine;
    }

    public String printDone() {
        return horizontalLine + System.lineSeparator() + "     Nice! I've marked this task as done:" + System.lineSeparator() + "       [" + getStatusIcon() + "] " + description + System.lineSeparator() + horizontalLine;
    }
}
