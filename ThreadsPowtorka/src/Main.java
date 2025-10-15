import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Scheduler scheduler = new Scheduler(n); // change 5 with n
        List<Task> Tasks = scheduler.getDescSortedTasks();

        for (Task task : Tasks) {
            Thread t = new Thread(() -> {
                System.out.println(
                        Thread.currentThread().getName() + " " +
                                task.getDesc() + " " +
                                Thread.currentThread().getPriority()
                );
            });
            t.setPriority(task.getPriority());
            t.start();
            t.join();
        }
    }
}