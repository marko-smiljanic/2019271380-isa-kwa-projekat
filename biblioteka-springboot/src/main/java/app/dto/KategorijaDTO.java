package app.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class KategorijaDTO {
	
    private Long id;
	private String naziv;
	
	@JsonIgnore
	private Set<KnjigaDTO> knjige = new HashSet<KnjigaDTO>();
	
	
	public KategorijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KategorijaDTO(Long id, String naziv) {
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
	public Set<KnjigaDTO> getKnjige() {
		return knjige;
	}
	public void setKnjige(Set<KnjigaDTO> knjige) {
		this.knjige = knjige;
	}
	

}
