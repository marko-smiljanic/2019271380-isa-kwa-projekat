package app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Iznajmljivanje {
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne()
	private Korisnik korisnik; 
	@ManyToOne
    private Knjiga knjiga;
	
    @Column(nullable = false)
	@Temporal(TemporalType.DATE)
    private Date datumIznajmljivanja;
    
    @Column(nullable = false)
	@Temporal(TemporalType.DATE)
    private Date datumVracanja;
    
    
//    public Iznajmljivanje() {
//        this.datumIznajmljivanja = new Date(); // Default to current timestamp
//        this.datumVracanja = new Date(System.currentTimeMillis() + (30 * 24 * 60 * 60 * 1000L)); // Default return date is 30 days from rental date
//    }
    
    
    
    public Iznajmljivanje() {
    	
    }

	public Iznajmljivanje(Long id, Korisnik korisnik, Knjiga knjiga, Date datumIznajmljivanja, Date datumVracanja) {
	super();
	this.id = id;
	this.korisnik = korisnik;
	this.knjiga = knjiga;
	this.datumIznajmljivanja = datumIznajmljivanja;
	this.datumVracanja = datumVracanja;
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
