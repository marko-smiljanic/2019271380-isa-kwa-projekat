package app.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import app.model.Knjiga;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AutorDTO {
	
    private Long id;
	private String ime;
	private String prezime;
	
	@JsonIgnore
	private Set<KnjigaDTO> knjige = new HashSet<KnjigaDTO>();

	public AutorDTO(Long id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	public AutorDTO() {
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

	public Set<KnjigaDTO> getKnjige() {
		return knjige;
	}

	public void setKnjige(Set<KnjigaDTO> knjige) {
		this.knjige = knjige;
	}

	
	
	
}
