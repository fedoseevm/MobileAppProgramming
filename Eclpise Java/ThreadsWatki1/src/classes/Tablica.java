package classes;

public class Tablica {
	private int[] Table = new int[50];
	
	public int[] getTable() {
		return Table;
	}

	public Tablica() {
		for (int i = 0; i < Table.length; i++) {
			Table[i] = 0;
		}
	}
	
	public void Print() {
		for (int i = 0; i < Table.length; i++) {
			System.out.print(Table[i] + " ");
		}
		System.out.print("\n");
	}
	
	public void Insertvalue(int index, int value) {
		Table[index] = value;
	}
	
}
