package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Korisnik {
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(unique = true)
	private String korisnickoIme;
	@Column(length = 255)
	private String lozinka;
	private String ime;
	private String prezime;
	
	@OneToMany(mappedBy = "vlasnik")
	private Set<KorisnikHasPravo> korisnikHasPravo = new HashSet<KorisnikHasPravo>();
	
	public Korisnik() {}
	
	public Korisnik(Long id, String korisnickoIme, String lozinka, String ime, String prezime) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public Set<KorisnikHasPravo> getKorisnikHasPravo() {
		return korisnikHasPravo;
	}
	public void setKorisnikHasPravo(Set<KorisnikHasPravo> korisnikHasPravo) {
		this.korisnikHasPravo = korisnikHasPravo;
	}

    
	
	
	
}
