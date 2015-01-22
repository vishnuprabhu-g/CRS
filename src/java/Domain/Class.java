/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.lang.reflect.Field;

/**
 *
 * @author vishnu-pt517
 */
public class Class {
   public long id;
   public String name;
   public static void main(String...in){
      Field[] fl= new Class().getClass().getFields();
      System.out.println(new Class().getClass());
      for(Field f:fl)
      {
          System.out.println(f.getName());
      }
   }
}
