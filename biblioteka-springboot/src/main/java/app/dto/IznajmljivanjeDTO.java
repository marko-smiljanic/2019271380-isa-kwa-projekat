package app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import app.model.Knjiga;
import app.model.Korisnik;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class IznajmljivanjeDTO {
	
    private Long id;
	private KorisnikDTO korisnik; 
    private KnjigaDTO knjiga;
    private Date datumIznajmljivanja;
    private Date datumVracanja;
    
    
	public IznajmljivanjeDTO(Long id, KorisnikDTO korisnik, KnjigaDTO knjiga, Date datumIznajmljivanja,
			Date datumVracanja) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.knjiga = knjiga;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
	}
	
	public IznajmljivanjeDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(Date datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public Date getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(Date datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
    
    
    
    

}
