package app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Knjiga {
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
	private String naslov;
	@Column(nullable = false)
	private Date datumObjave;
	private Integer komadaNaStanju;
	private Double cena;
	@ManyToOne()
	private Autor autor; 
	@ManyToOne()
	private Kategorija kategorija;
	
	
	@OneToMany(mappedBy = "knjiga")  
	private Set<Recenzija> recenzije = new HashSet<Recenzija>();
	@OneToMany(mappedBy = "knjiga")  
	private Set<Iznajmljivanje> iznajmljivanja = new HashSet<Iznajmljivanje>();
	
	
	public Knjiga(Long id, String naslov, Date datumObjave, Integer komadaNaStanju, Double cena, Autor autor, Kategorija kategorija) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.datumObjave = datumObjave;
		this.komadaNaStanju = komadaNaStanju;
		this.cena = cena;
		this.autor = autor;
		this.kategorija = kategorija;
	}
	
	public Knjiga() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public Date getDatumObjave() {
		return datumObjave;
	}
	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}
	
	public Integer getKomadaNaStanju() {
		return komadaNaStanju;
	}

	public void setKomadaNaStanju(Integer komadaNaStanju) {
		this.komadaNaStanju = komadaNaStanju;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}
	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Set<Recenzija> getRecenzije() {
		return recenzije;
	}

	public void setRecenzije(Set<Recenzija> recenzije) {
		this.recenzije = recenzije;
	}

	public Set<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}

	public void setIznajmljivanja(Set<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}
	
	


	
	
}
