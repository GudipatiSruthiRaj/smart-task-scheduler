import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable {
    private String title;
    private String description;
    private int priority;
    private LocalDate deadline;

    public Task(String title, String description, int priority, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public LocalDate getDeadline() { return deadline; }

    @Override
    public int compareTo(Task other) {
        if(this.priority != other.priority) return this.priority - other.priority;
        return this.deadline.compareTo(other.deadline);
    }

    @Override
    public String toString() {
        return title + " | " + description + " | Priority: " + priority + " | Deadline: " + deadline;
    }
}
