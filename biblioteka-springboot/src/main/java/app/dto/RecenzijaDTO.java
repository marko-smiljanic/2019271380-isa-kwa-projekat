package app.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RecenzijaDTO {
	private Long id;
	private KorisnikDTO korisnik;  
	private KnjigaDTO knjiga;  
	private String opis;
	
	
	public RecenzijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecenzijaDTO(Long id, KorisnikDTO korisnik, KnjigaDTO knjiga, String opis) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.knjiga = knjiga;
		this.opis = opis;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public KorisnikDTO getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	public KnjigaDTO getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(KnjigaDTO knjiga) {
		this.knjiga = knjiga;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

	
	
}
