public class Task {
    private final int Priority;
    private final String Desc;
    private Thread thread;

    public Task(int prio, String desc) {
        Priority = prio;
        Desc = desc;
        thread = new Thread(() -> {
            System.out.println(Desc + ": " + Priority);
        });
        thread.setName(Desc);
    }

    public int getPriority() {
        return Priority;
    }

    public String getDesc() {
        return Desc;
    }
}
