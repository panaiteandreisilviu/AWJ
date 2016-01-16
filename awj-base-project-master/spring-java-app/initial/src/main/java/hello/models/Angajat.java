package hello;

import java.util.List;
import java.util.ArrayList;

public class Angajat {
  private String name;
  private int id;


  public Angajat() {}

  public Angajat(int id ,String name) {
      this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }
  
  public void setName(String nume) {
      this.name = nume;
  }

  public int getId() {
    return this.id;
  }
}
