import static java.lang.Math.random;

public class Schedule {
    private Task[] tasks;

    public Schedule(int n) {
        tasks = new Task[n];
        tasks = sortTasksDesc(setTasks(n));
    }

    public Task[] setTasks(int n) {
        for (int i = 0; i < n; i++) {
            int prio = (int) (random() * 10);
            tasks[i] = new Task(prio, "Task " + i);
        }
        return tasks;
    }

    public Task[] sortTasksDesc(Task[] tasks) {
        int n = tasks.length;
        boolean sorted = false;
        while (!sorted) {
            for (int i = 0; i < n - 1; i++) {
                Task temp;
                if (tasks[i].getPriority() < tasks[i + 1].getPriority()) {
                    temp = tasks[i];
                    tasks[i] = tasks[i + 1];
                    tasks[i + 1] = temp;
                    break;
                }
                sorted = true;
            }
        }
        return tasks;

    }
}
