package duke.task;

public class Task {

    protected String description;
    protected boolean isDone;
    protected String horizontalLine = "\n____________________________________________________________\n";
    protected int taskCount;
    protected boolean isPlural = false;

    public Task(String description) {
        this.description = description;
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

    public String getTaskType() {
        return " ";
    }

    public String printTask() {
        return "." + "[" + getTaskType() + "]" + "["
                + getStatusIcon() + "] " + description;
    }

    public String printOk() {
        return horizontalLine + " added: " + description + horizontalLine;
    }

    public String printOkStart() {
        return horizontalLine + " Got it. I've added this task:\n";
    }

    public String printOkEnd() {
        return " Now you have ";
    }

    public String printDone() {
        return horizontalLine + " Nice! I've marked this task as done:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + horizontalLine;
    }

    public String printDelete() {
        return horizontalLine + " Noted. I've removed this task:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description;
    }

    public String fileContent() {
        return " [" + getStatusIcon() + "] " + description;
    }
}
