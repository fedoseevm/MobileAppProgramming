import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private int TasksNumber;
    private List<Task> Tasks;

    public Scheduler(int n) {
        TasksNumber = n;
        Tasks = new ArrayList<Task>();

        for (int i = 0; i < n; i++) {
            Tasks.add(new Task());
        }
    }

    public List<Task> getTasks() {
        return Tasks;
    }
}
