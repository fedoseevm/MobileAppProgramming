package classes;

import java.util.List;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotesManager manager = new NotesManager();
		manager.Load();
		List<Note> notes = List.of();
		notes = manager.Wy1();
		manager.ShowNotes(notes);
	}

}
