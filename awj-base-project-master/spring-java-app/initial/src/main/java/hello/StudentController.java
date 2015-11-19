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
public class StudentController {
  private List<Student> studenti = new ArrayList<Student>();

  StudentController() {
    Student s1 = new Student(1, "Student1");
    Student s2 = new Student(2, "Student2");
    Student s3 = new Student(3, "Student3");

    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
  }


//GET ALL
  @RequestMapping(value="/student", method = RequestMethod.GET)
  public List<Student> index() {
    return this.studenti;
  }


//GET ONE
  @RequestMapping(value="/student/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


//POST
@RequestMapping(value="/student/{id}", method = RequestMethod.POST)
  public ResponseEntity show(@PathVariable("id") int id) {

    student stud = new student(id,"Nume");
    studenti.add(stud);
    return new ResponseEntity<Student>(stud, new HttpHeaders(), HttpStatus.OK);
  }


//PUT
  @RequestMapping(value="/student/{id}", method = RequestMethod.PUT)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Student s : studenti)
    {
      if(id == s.getId())
      {
        s.setId = id+1;
        return new ResponseEntity<Student>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }

    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


  //DEL
  @RequestMapping(value="/student/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Student s : this.studenti) {
      if(s.getId() == id) {
        this.studenti.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}