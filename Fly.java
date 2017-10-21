/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author huber
 */

class Passenger{
private String name;
private String surname;
private int age;
private long flyid;

public Passenger(String name, String surname, int age, long flyid){
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.flyid = flyid;
}
 
public void setName(String name){
    this.name = name;
}

public String getName(){
    return this.name;
}

public void setSurname(String surname){
    this.surname = surname;
}

public String getSurname(){
    return this.surname;
}

public void setAge(int age){
    this.age = age;
}

public int getAge(){
    return this.age;
}

public void setFlyID(long flyid){
    this.flyid = flyid;
}

public long getFlyID(){
    return this.flyid;
}

}

public class Fly implements Serializable, Cloneable{
  public static Fly fly = null;
  public static Vector<Passenger> lista;
  protected Object readResolve()
    {
        return fly;
    }
  protected Object clone() throws CloneNotSupportedException 
  {
    return super.clone();
  }
  
  public static Fly getInstance() {
        if (fly == null) {
            synchronized (Fly.class) {
                if (fly == null) {
                    fly = new Fly();
                    lista = new Vector<Passenger>();
                }
            }
        }
        return fly;
    }
  
  public Fly()
    {
       if( fly != null)
          throw new RuntimeException("Instance already exist");      
    }
  
    public Passenger addPassenger(String name, String surname, int age, long flyid){
        for(Passenger passenger : lista){
            if(passenger.getName().equals(name)&&passenger.getSurname().equals(surname)&&passenger.getAge() == age && passenger.getFlyID() == flyid){
                System.out.println("This passenger already exists");
                return null;
            }
            else{
                continue;
            }
        }
        Passenger psngr1 = new Passenger(name, surname, age, flyid);
        lista.add(psngr1);
        return psngr1;
    }
  
}

