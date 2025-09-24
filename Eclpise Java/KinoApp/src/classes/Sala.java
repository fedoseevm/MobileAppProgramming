package classes;

public class Sala {
	private String Nazwa;
	private int [][] Miejsca;
	
	public Sala(String nazwa, int n) {
		super();
		Nazwa = nazwa;
		Miejsca = new int[n][n];
		for (int i = 0; i < Miejsca.length; i++) {
			for (int j = 0; j < Miejsca.length; j++) {
				Miejsca[i][j] = 0;
			}
		}
	}

	public String getNazwa() {
		return Nazwa;
	}

	public boolean czyWolne(int i, int j) {
		return (Miejsca[i][j]) == 0;
	}
	
	public void zerezwuj(int i, int j) {
		Miejsca[i][j] = 1;
	}
	
	public void anulujRezerwacje(int i, int j) {
		Miejsca[i][j] = 0;
	}
	
	public int iloscWolnych() {
		int ilosc = 0;
		for (int i = 0; i < Miejsca.length; i++) {
			for (int j = 0; j < Miejsca.length; j++) {
				if (Miejsca[i][j] == 0) {
					ilosc++;
				}
			}
		}
		return ilosc;
	}
	
	public void wyswietlSale( ) {
		for (int i = 0; i < Miejsca.length; i++) {
			for (int j = 0; j < Miejsca.length; j++) {
				if (Miejsca[i][j] == 0) System.out.print("O");
				else System.out.print("X");
			}
		}
	}
}
