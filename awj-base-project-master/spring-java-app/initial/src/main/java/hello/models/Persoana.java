package hello;

import java.util.List;
import java.util.ArrayList;

public class Persoana {
  private String name;
  private int id;

  public Persoana() {}

  public Persoana(int id, String name) {
      this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setNume(String nume){
    this.nume = nume;
  }

  public int getId() {
    return this.id;
  }
}