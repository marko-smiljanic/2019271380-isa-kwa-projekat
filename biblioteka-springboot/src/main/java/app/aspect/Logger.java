package app.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import app.model.Korisnik;
import app.service.KorisnikService;
import app.service.LogService;

@Component
@Aspect
public class Logger {
	@Autowired
	LogService service;
	
//	@Autowired
//	DokumentService dokumentServis;
	
	@Autowired
    private KorisnikService korisnikServis;
	
	
	//ovu verziju sam koristio
//	@Before("execution (* app.service.*.*())") // mora se skloniti (..) desava se rekurzija jer save sam sebe poziva u nedogled, ako stavim && @annotation(nekaanotacija)) znaci da pratim metode samo koje imaju + tu anotaciju
//	public void log44(JoinPoint jp) {
//		service.save(new Log(null, new Date(), jp.getSignature().toString()));
////		System.out.println("Logovanje podataka");
//	}
	
	
	//after returning u ovom slucaju ne mogu koristiti jer se nakon izvrsavanja metode u kontroleru dokument obrise, posle ga ne mogu dohvatiti, ali ce se zato u novom izvestaju upisivati stari naslov od izmenjenog dokumenta
//	@Before("@annotation(LoggedMethod)")  
//	public void log44(JoinPoint jp) {
//		//dohvatanje ulogovanog korisnika
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//        	System.out.println("Logovanje podataka: Greska! Korisnik nije ulogovan.");
//            return;
//        }
//        String korisnickoIme = authentication.getName();
//        Korisnik korisnik = korisnikServis.findByKorisnickoIme(korisnickoIme).orElse(null);
//        if (korisnik == null) {
//        	System.out.println("Logovanje podataka: Greska! Korisnik nije pronadjen.");
//            return;
//        }
//        
//        
//        //dohvatanje id-ja dokumenta nad kojim se radi operacija (iz metode kontrolera)
//        Object[] args = jp.getArgs();
//        Long dokumentId = null;
//        for (Object arg : args) {
//            if (arg instanceof Long) {
//                dokumentId = (Long) arg;
//                break;
//            }
//        }
//        
//        Dokument dokument = this.dokumentServis.findById(dokumentId).orElse(null);	
//        if (dokument == null) {
//            System.out.println("Logovanje podataka: Greska! Dokument nije pronadjen.");
//            return;
//        }
//        
//        
//		Izvestaj izvestaj = new Izvestaj();
//		izvestaj.setTip(jp.getSignature().getName());
//		izvestaj.setSadrzaj("Korisnik: username: '" + korisnik.getKorisnickoIme() + "' je izvrsio operaciju: '" + jp.getSignature().getName() + "' nad dokumentom id: " + dokument.getId() + ", naslov:" + dokument.getNaslov());
//		izvestaj.setDatumObjave(new Date());
//		izvestaj.setAutor(null);
//		
//		
//		dokumentServis.create(izvestaj);
//		
//	}
	
	
	
	

}
