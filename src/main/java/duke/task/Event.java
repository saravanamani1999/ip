package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected String at;
    LocalDateTime dueTime;

    public Event(String description, LocalDateTime at) {
        super(description);
        this.dueTime = at;
        this.at = at.format(DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a"));
    }

    public String getTaskType() {
        return "E";
    }

    public String printOk() {
         return super.printOkStart() + "  [E][" + getStatusIcon() + "] "
                 + description + " (at: " + at + ")\n" + super.printOkEnd();
    }

    public String printTask() {
        return "." + "[" + getTaskType() + "]" + "["
                + getStatusIcon() + "] " + description + " (at: " + at + ")";
    }

    public String printDone() {
        return HORIZONTAL_LINE + " Nice! I've marked this task as done:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + " (at: " + at + ")" + HORIZONTAL_LINE;
    }

    public String printDelete() {
        return HORIZONTAL_LINE + " Noted. I've removed this task:\n   [" + getTaskType() + "]["
                + getStatusIcon() + "] " + description + " (at: " + at + ")";
    }

    public String fileContent() {
        return "E [" + getStatusIcon() + "] " + description + " at: " + dueTime;
    }

}
