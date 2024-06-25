package app.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class KorisnikHasPravoDTO {
    private Long id;
	private KorisnikDTO vlasnik; 
	private PravoPristupaDTO pravoPistupa;
	
	
	public KorisnikHasPravoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KorisnikHasPravoDTO(Long id, KorisnikDTO vlasnik, PravoPristupaDTO pravoPistupa) {
		super();
		this.id = id;
		this.vlasnik = vlasnik;
		this.pravoPistupa = pravoPistupa;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public KorisnikDTO getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(KorisnikDTO vlasnik) {
		this.vlasnik = vlasnik;
	}
	public PravoPristupaDTO getPravoPistupa() {
		return pravoPistupa;
	}
	public void setPravoPistupa(PravoPristupaDTO pravoPistupa) {
		this.pravoPistupa = pravoPistupa;
	}
	
}
