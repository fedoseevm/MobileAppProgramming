import java.util.Random;

public class Task {
    private String Desc;
    private final int Priority; // final - deklarowanie zmiennej stalej

    public Task() {
        Random random = new Random();
        Priority = random.nextInt(9) + 1;
        Desc = "Priority " + Priority;
    }

    public int getPriority() {
        return Priority;
    }

    public String getDesc() {
        return Desc;
    }
}

