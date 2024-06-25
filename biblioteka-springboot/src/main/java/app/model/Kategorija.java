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
public class Kategorija {
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 255)
	private String naziv;
	
	@OneToMany(mappedBy = "kategorija")
	private Set<Knjiga> knjige = new HashSet<Knjiga>();
	
	
	public Kategorija() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kategorija(Long id, String naziv) {
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
	public Set<Knjiga> getKnjige() {
		return knjige;
	}
	public void setKnjige(Set<Knjiga> knjige) {
		this.knjige = knjige;
	}
	
	
	
}
