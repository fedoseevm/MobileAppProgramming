package classes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class NotesManager {
	private List<Note> notes = List.of();
	
	public void Load() {
		Note note1 = new Note(
				0, 
				"Pierwsza", 
				"Wstęp do notatek", 
				LocalDate.of(2014, 2, 14), 
				"Programowanie", 
				5);
		notes.add(note1);
		Note note2 = new Note(
				1, 
				"Druga", 
				"Lol", 
				LocalDate.of(2005, 9, 2), 
				"Android", 
				9);
		notes.add(note2);
		Note note3 = new Note(
				2, 
				"Trzecia", 
				"Lol", 
				LocalDate.of(207, 1, 29), 
				"Android", 
				2);
		notes.add(note3);
		Note note4 = new Note(
				3, 
				"Czwarta", 
				"Lol", 
				LocalDate.of(2023, 11, 19), 
				"Programowanie", 
				7);
		notes.add(note4);
	}
	
	public List<Note> Wy1() {
		List<Note> notes1 = this.notes
				.stream()
				.filter(n -> n.getTag() == "Android")
				.collect(Collectors.toList());
		return notes1;
	}
	
	public List<Note> Wy2() {
		List<Note> notes2 = this.notes
				.stream()
				.filter(n -> n.getTag() == "Android")
				.filter(n -> n.getRating() >= 5)
				.collect(Collectors.toList());
		return notes2;
	}
	
	public void ShowNotes(List<Note> notesList) {
		for (Note note : notesList) {
			System.out.println(note.getId() + " " 
					+ note.getTytul() + " " 
					+ note.getTresc() + " " 
					+ note.getData() + " "
					+ note.getTag() + " "
					+ note.getRating());
		}
	}
}
