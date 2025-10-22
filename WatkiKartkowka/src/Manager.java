import java.util.ArrayList;
import java.util.Random;

public class Manager {
    ArrayList<Runnable> RunnList;
    ArrayList<Thread> ThreadsList;

    public Manager(int n) {
        RunnList = new ArrayList<Runnable>();
        ThreadsList = new ArrayList<Thread>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            int finalI = i;
            RunnList.add(new Runnable() {
                @Override
                public void run() {
                    String number = "";
                    int prio = r.nextInt(4,9);
                    int pos = finalI;
                    int digit = r.nextInt(0, 9);
                    number += prio + "" + pos + "" + digit;
                    System.out.print(number);

                    if (ifPrime(Integer.parseInt(number)))
                        System.out.println("Yes");
                    else System.out.println("No");
                }
            });

            ThreadsList.add(new Thread(() -> {
                String number = "";
                int prio = r.nextInt(4,9);
                int pos = finalI;
                int digit = r.nextInt(0, 9);
                number += prio + "" + pos + "" + digit;
                System.out.print(number);

                if (ifPrime(Integer.parseInt(number)))
                    System.out.println("Yes");
                else System.out.println("No");
            }));
        }
    }
    public void start() {
        for (Runnable item: RunnList) {
            item.run();
        }
        for (Thread item: ThreadsList) {
            item.start();
        }
    }

    public boolean ifPrime(int x) {
        for (int i = 2; i <= x/2; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
