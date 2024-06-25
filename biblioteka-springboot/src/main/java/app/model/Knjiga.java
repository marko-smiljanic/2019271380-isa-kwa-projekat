package app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
public class Knjiga {
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String naslov;
	private Date datumObjave;
	private Date datumBrisanja;
	@ManyToOne()
	private Autor autor; 
	
	
	public Knjiga(Long id, String naslov, Date datumObjave, Date datumBrisanja, Autor autor) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.datumObjave = datumObjave;
		this.datumBrisanja = datumBrisanja;
		this.autor = autor;
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
	public Date getDatumBrisanja() {
		return datumBrisanja;
	}
	public void setDatumBrisanja(Date datumBrisanja) {
		this.datumBrisanja = datumBrisanja;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
}
