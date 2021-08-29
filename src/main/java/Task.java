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
        return "     Here are the tasks in your list:\n" + "     " + taskCount + "." + "[" + getTaskType() + "]" + "[" + getStatusIcon() + "] " + description;
    }

    public String printOk() {
        return horizontalLine + indent + "added: " + description + System.lineSeparator() + horizontalLine;
    }

    public String printOkStart() {
        return horizontalLine +  indent + "Got it. I've added this task:\n" + indent;
    }

    public String printOkEnd() {
        return indent + "Now you have " + taskCount + " tasks in the list.\n" + horizontalLine;
    }

    public String printDone() {
        return horizontalLine + indent + "Nice! I've marked this task as done:\n     [" + getTaskType() + "][" + getStatusIcon() + "] " + description + System.lineSeparator() + horizontalLine;
    }
}
