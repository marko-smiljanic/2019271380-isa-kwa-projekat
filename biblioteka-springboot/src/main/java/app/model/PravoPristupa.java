package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class PravoPristupa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String naziv;
	
	@OneToMany(mappedBy = "pravoPristupa")
	private Set<KorisnikHasPravo> korisnikHasPravo = new HashSet<KorisnikHasPravo>();

	
	public PravoPristupa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PravoPristupa(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<KorisnikHasPravo> getKorisnikHasPravo() {
		return korisnikHasPravo;
	}

	public void setKorisnikHasPravo(Set<KorisnikHasPravo> korisnikHasPravo) {
		this.korisnikHasPravo = korisnikHasPravo;
	}
	
	
	

}
