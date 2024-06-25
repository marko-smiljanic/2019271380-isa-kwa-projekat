package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Recenzija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Korisnik korisnik;  
	@ManyToOne
	private Knjiga knjiga;  
	@Lob
	@Column(nullable = false)
	private String opis;
	
	
	public Recenzija(Long id, Korisnik korisnik, Knjiga knjiga, String opis) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.knjiga = knjiga;
		this.opis = opis;
	}
	
	public Recenzija() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
}
