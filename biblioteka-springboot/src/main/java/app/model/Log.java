package app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity   
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//TemporalType.DATE: Mapira polje tako da čuva samo datum (bez vremena). U bazi podataka ovo bi obično bio tip DATE.
	//TemporalType.TIME: Mapira polje tako da čuva samo vreme (bez datuma). U bazi podataka ovo bi obično bio tip TIME.
	//TemporalType.TIMESTAMP: Mapira polje tako da čuva i datum i vreme. U bazi podataka ovo bi obično bio tip TIMESTAMP  .. moze se cuvati kombinacija datuma i vremena ili samo datum
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String description;
	
	
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Log(Long id, Date date, String description) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
