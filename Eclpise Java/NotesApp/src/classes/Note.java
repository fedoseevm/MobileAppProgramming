package classes;

import java.time.LocalDate;
import java.util.Date;

public class Note {
	private int id;
	private String tytul;
	private String tresc;
	private LocalDate data;
	private String tag;
	private int rating;
	
	public Note(int id, String tytul, String tresc, LocalDate data, String tag, int rating) {
		super();
		this.id = id;
		this.tytul = tytul;
		this.tresc = tresc;
		this.data = data;
		this.tag = tag;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getTresc() {
		return tresc;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
