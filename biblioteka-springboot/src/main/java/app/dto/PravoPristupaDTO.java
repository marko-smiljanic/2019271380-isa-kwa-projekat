package app.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PravoPristupaDTO {
	private Long id;
	private String naziv;

	@JsonIgnore
	private Set<KorisnikHasPravoDTO> korisnikHasPravo = new HashSet<KorisnikHasPravoDTO>();
	
	public PravoPristupaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PravoPristupaDTO(Long id, String naziv) {
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

	public Set<KorisnikHasPravoDTO> getKorisnikHasPravo() {
		return korisnikHasPravo;
	}

	public void setKorisnikHasPravo(Set<KorisnikHasPravoDTO> korisnikHasPravo) {
		this.korisnikHasPravo = korisnikHasPravo;
	}

	
	
	
	
}
