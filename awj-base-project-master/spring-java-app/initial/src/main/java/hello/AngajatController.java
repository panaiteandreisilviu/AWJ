package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class AngajatController {
  private List<Angajat> angajati = new ArrayList<Angajat>();

  AngajatController() {
    Angajat a1 = new Angajat(1,"Ion");
    Angajat a2 = new Angajat(2,"Popescu");

    angajati.add(a1);
    angajati.add(a2);
  }


//GET ALL
  @RequestMapping(value="/angajat", method = RequestMethod.GET)
  public List<Angajat> index() {
    return this.angajati;
  }


//GET ONE
  @RequestMapping(value="/angajat/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Angajat ang : this.angajati) {
      if(ang.getId() == id) {
        return new ResponseEntity<Angajat>(ang, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


//POST
@RequestMapping(value="/angajat/{id}", method = RequestMethod.POST)
  public ResponseEntity show(@PathVariable("id") int id) {

    angajat ang = new angajat(id,"Nume");
    angajati.add(ang);
    return new ResponseEntity<Angajat>(ang, new HttpHeaders(), HttpStatus.OK);
  }


//PUT
  @RequestMapping(value="/angajat/{id}", method = RequestMethod.PUT)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Angajat a : angajati)
    {
      if(id == a.getId())
      {
        a.setId = id++;
        return new ResponseEntity<Angajat>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }

    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  //DEL
  @RequestMapping(value="/angajat/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Angajat a : this.angajati) {
      if(a.getId() == id) {
        this.angajati.remove(a);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}