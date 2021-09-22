package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDateTime dueTime;
    protected String by;

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.dueTime = by;
        this.by = by.format(DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a"));
    }

    public String getTaskType() {
        return "D";
    }

    public String printOk() {
        return super.printOkStart() + "  [D][" + getStatusIcon() + "] "
                + description + " (by: " + by + ")\n"  + super.printOkEnd();
    }

    public String printTask() {
        return "." + "[" + getTaskType() + "]" + "["
                + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }

    public String printDone() {
        return HORIZONTAL_LINE+ " Nice! I've marked this task as done:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + " (by: " + by + ")" + HORIZONTAL_LINE;
    }

    public String printDelete() {
        return HORIZONTAL_LINE+ " Noted. I've removed this task:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }

    public String fileContent() {
        return "D [" + getStatusIcon() + "] " + description + " by: " + dueTime;
    }

}
