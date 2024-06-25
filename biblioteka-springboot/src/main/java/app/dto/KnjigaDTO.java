package app.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class KnjigaDTO {
	
    private Long id;
	private String naslov;
	private Date datumObjave;
	private Integer komadaNaStanju;
	private Double cena;
	private AutorDTO autor; 
	private KategorijaDTO kategorija;
	
	@JsonIgnore
	private Set<RecenzijaDTO> recenzije = new HashSet<RecenzijaDTO>();
	@JsonIgnore
	private Set<IznajmljivanjeDTO> iznajmljivanja = new HashSet<IznajmljivanjeDTO>();
	
	
	public KnjigaDTO(Long id, String naslov, Date datumObjave, AutorDTO autor, KategorijaDTO kategorija, Integer komadaNaStanju, Double cena) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.datumObjave = datumObjave;
		this.autor = autor;
		this.kategorija = kategorija;
		this.komadaNaStanju = komadaNaStanju;
		this.cena = cena;
	}
	
	public KnjigaDTO() {
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
	
	public AutorDTO getAutor() {
		return this.autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	

	public KategorijaDTO getKategorija() {
		return kategorija;
	}

	public void setKategorija(KategorijaDTO kategorija) {
		this.kategorija = kategorija;
	}

	public Set<RecenzijaDTO> getRecenzije() {
		return recenzije;
	}

	public void setRecenzije(Set<RecenzijaDTO> recenzije) {
		this.recenzije = recenzije;
	}

	public Set<IznajmljivanjeDTO> getIznajmljivanja() {
		return iznajmljivanja;
	}

	public void setIznajmljivanja(Set<IznajmljivanjeDTO> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}
	
	
	
	
	
}
