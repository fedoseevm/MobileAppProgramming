package classes;

import java.util.Scanner;

public class Manager {

	public static void main(String[] args) {
		// w - wyswietl
		// d - dodaj rezerwacje
		// q - wyjscie
		
		Kino kino = new Kino();
		
		boolean live = true;
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			switch (input) {
			case "q": {
				live = false;
				break;
			}
			case "w": {
				kino.getSala(0).wyswietlSale();
				break;
			}
			case "d": {
				String line = scanner.nextLine();
				char[] C = line.toCharArray();
				int a = C[0] - '0';
				int b = C[2] - '0';
				
				kino.rezerwuj(a, b);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + input);
			}
			scanner.close();
		}
	}

}
