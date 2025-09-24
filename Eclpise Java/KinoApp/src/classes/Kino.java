package classes;

import java.util.ArrayList;

public class Kino {
	private ArrayList<Sala> Sale = new ArrayList<Sala>();

	public Kino() {
		Sale.add(new Sala("Poznanska", 5));
		Sale.add(new Sala("Warszawska", 5));
	}
	
	public Sala getSala(int numer) {
		return Sale.get(numer);
	}

	public void rezerwuj(int a, int b) {
		if (Sale.get(0).czyWolne(a, b)) 
			Sale.get(0).zerezwuj(a, b);
		else
			System.out.print("Miejsce zajęte");
	}
}
