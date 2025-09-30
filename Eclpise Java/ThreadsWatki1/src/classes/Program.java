package classes;

public class Program {

	public static void main(String[] args) {
		Tablica table = new Tablica();
		table.Print();
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < table.getTable().length; i++) {
				table.Insertvalue(i, 1);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = table.getTable().length - 1; i >= 0 ; i--) {
				table.Insertvalue(i, 2);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t3 = new Thread(() -> {
			for (;;) {
				table.Print();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}

}
