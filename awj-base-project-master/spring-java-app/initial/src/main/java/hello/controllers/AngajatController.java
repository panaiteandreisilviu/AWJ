package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class AngajatController {
  private List<Angajat> angajati = new ArrayList<Angajat>();

  AngajatController() {
    Angajat p1 = new Angajat(1, "Gavrila Alexandru");
    Angajat p2 = new Angajat(2, "Caradan Andrei");
    Angajat p3 = new Angajat(3, "Daniel Adrian");
    Angajat p4 = new Angajat(4, "Florin Alina");


    angajati.add(p1);
    angajati.add(p2);
    angajati.add(p3);
    angajati.add(p4);
  }

  @RequestMapping(value="/angajat", method = RequestMethod.GET)
  public List<Angajat> index() {
    return this.angajati;
  }

@RequestMapping(value="/angajat", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Angajat p)
  {
      angajati.add(p);
      return new ResponseEntity<Angajat>(p, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/angajat/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Angajat p : this.angajati) {
      if(p.getId() == id) {
        return new ResponseEntity<Angajat>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @CrossOrigin
  @RequestMapping(value="/angajat/{id}/{nume}", method = RequestMethod.PUT)
  public List<Angajat> update(@PathVariable("id") int id,@PathVariable("nume") String nume){
    for(Angajat p : this.angajati){
      if(p.getId() == id){
		p.setName(nume);
      }
    }
    return this.angajati;
  }
  
  @CrossOrigin
  @RequestMapping(value="/angajat/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Angajat p : this.angajati) {
      if(p.getId() == id) {
        this.angajati.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}



