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
public class Autor {
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String ime;
	private String prezime;
	
	@OneToMany(mappedBy = "autor")
	private Set<Knjiga> knjige = new HashSet<Knjiga>();
	
	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	public Set<Knjiga> getKnjige() {
		return this.knjige;
	}
	
	public void setKnjige(Set<Knjiga> knjige) {
		this.knjige = knjige;
	}
	
	

	
}
