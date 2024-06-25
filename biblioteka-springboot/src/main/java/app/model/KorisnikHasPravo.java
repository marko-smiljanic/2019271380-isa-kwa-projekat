package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KorisnikHasPravo {
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
	private Korisnik vlasnik;            
	@ManyToOne
	private PravoPristupa pravoPristupa;
	
	
	
	public KorisnikHasPravo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikHasPravo(Long id, Korisnik vlasnik, PravoPristupa pravoPristupa) {
		super();
		this.id = id;
		this.vlasnik = vlasnik;
		this.pravoPristupa = pravoPristupa;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Korisnik getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(Korisnik vlasnik) {
		this.vlasnik = vlasnik;
	}
	public PravoPristupa getPravoPistupa() {
		return pravoPristupa;
	}
	public void setPravoPistupa(PravoPristupa pravoPistupa) {
		this.pravoPristupa = pravoPistupa;
	}
	
	
	
}
