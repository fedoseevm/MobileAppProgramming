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

    public List<Task> getDescSortedTasks() {
        List<Task> DescSortedTasks = Tasks; // 5 7 2 1 4
        for (int i = TasksNumber - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (DescSortedTasks.get(j).getPriority() < DescSortedTasks.get(j + 1).getPriority()) {
                    Task temp = DescSortedTasks.get(j);
                    DescSortedTasks.set(j, DescSortedTasks.get(j + 1));
                    DescSortedTasks.set(j + 1, temp);
                }
            }
        }
        return DescSortedTasks;
    }
}
