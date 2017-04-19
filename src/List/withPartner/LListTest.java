import java.util.*;
public class LListTest {
  
  public static void main(String[] args) {    
    LList l = new LList();
    l.add("A");
    l.add("B");
    l.add("C");
    
    for (Object el : l) {
      System.out.println("tae: " + el);
    }
    
    for (int i = 0; i < 3; i++) {
      System.out.println("igit: " + l.get(i));
    }
    
    Iterator it = l.iterator();
    System.out.println(it.next());
    System.out.println(it.next());  
    System.out.println(it.next()); 
    System.out.println(it.next()); 
    //it.remove();
    
    /*while (it.hasNext()) {
      System.out.println(it.next()); 
    }
    
    /*for (Object el : l) {
      System.out.println(el);
    }*/

  }
  
}