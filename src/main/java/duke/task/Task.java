package duke.task;

public class Task {

    public String description;
    protected boolean isDone;
    protected String HORIZONTAL_LINE = "\n____________________________________________________________\n";

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
        return HORIZONTAL_LINE + " added: " + description + HORIZONTAL_LINE;
    }

    public String printOkStart() {
        return HORIZONTAL_LINE + " Got it. I've added this task:\n";
    }

    public String printOkEnd() {
        return " Now you have ";
    }

    public String printDone() {
        return HORIZONTAL_LINE + " Nice! I've marked this task as done:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + HORIZONTAL_LINE;
    }

    public String printDelete() {
        return HORIZONTAL_LINE + " Noted. I've removed this task:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description;
    }

    public String fileContent() {
        return " [" + getStatusIcon() + "] " + description;
    }

}
