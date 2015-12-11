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
public class AnimalController {
  private List<Animal> animale = new ArrayList<Animal>();

  AnimalController() {
    Animal a1 = new Animal(1, "Urs");
    Animal a2 = new Animal(2, "Zebra");
    Animal a3 = new Animal(3, "Capybara");
    Animal a3 = new Animal(4, "Cartita");

    animale.add(a1);
    animale.add(a2);
    animale.add(a3);
    animale.add(a4);
  }

//GET ONE
  @RequestMapping(value="/animal", method = RequestMethod.GET)
  public List<Animal> index() {
    return this.animale;
  }
    
//GET ALL
  @RequestMapping(value="/animal/{id}", method = RequestMethod.GET)
  public ResponseEntity getanim(@PathVariable("id") int id) {
    for(Animal a : this.animale) {
      if(a.getId() == id) {
        return new ResponseEntity<Animal>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

//CREATE
@RequestMapping(value="/animal/{id} /{name}", method = RequestMethod.POST)
  public ResponseEntity createanim(@PathVariable("id") int id, @PathVariable("name") String name) {

    Animal anim = new Animal(id,name);
    animale.add(anim);
    return new ResponseEntity<Animal>(anim, new HttpHeaders(), HttpStatus.OK);
  }

//UPDATE
  @RequestMapping(value="/animal/{id} /{name}", method = RequestMethod.PUT)
  public ResponseEntity updateanim(@PathVariable("id") int id, @PathVariable("name") String name) {
    for(Animal a : animale)
    {
      if(id == a.getId())
      {
        a.setName(name);
        return new ResponseEntity<Animal>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }

    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

//DELETE
  @RequestMapping(value="/animal/{id}", method = RequestMethod.DELETE)
  public ResponseEntity removeanim(@PathVariable("id") int id) {
    for(Animal a : this.animale) {
      if(a.getId() == id) {
        this.animale.remove(a);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}