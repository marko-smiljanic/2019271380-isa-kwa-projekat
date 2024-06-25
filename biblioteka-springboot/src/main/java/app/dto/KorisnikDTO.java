package app.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


//sa ovim sprecavam problem rekruzije u inicijalizaciji dto preko konverzije u model maperu
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class KorisnikDTO {
	
    private Long id;
	private String korisnickoIme;
	private String lozinka;
	private String ime;
	private String prezime;
	
	@JsonIgnore     //ignorisi u json serijalizaciji. Logika je valjda da ono sto nemam u konstruktoru ne vracam kroz dto
	private Set<KorisnikHasPravoDTO> korisnikHasPravo = new HashSet<KorisnikHasPravoDTO>();
	
	public KorisnikDTO() {}
	
	public KorisnikDTO(Long id, String korisnickoIme, String lozinka, String ime, String prezime) {
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
	
	public Set<KorisnikHasPravoDTO> getKorisnikHasPravo() {
		return korisnikHasPravo;
	}
	public void setKorisnikHasPravo(Set<KorisnikHasPravoDTO> korisnikHasPravo) {
		this.korisnikHasPravo = korisnikHasPravo;
	}

	
	
	
	
}
