import java.util.*;
public class LListTest {
  
  public static void main(String[] args) {    
    LList l = new LList();
    l.add("A");
    l.add("B");
    l.add("C");
    l.add("D");
    l.add("E");
    
    /*for (int i = 0; i < 3; i++) {
      System.out.println("igit: " + l.get(i));
    }*/
    
    Iterator it = l.iterator();
    System.out.println(it.next());
    //it.remove();
    //it.remove();    
//it.remove();
    it.remove();
    System.out.println(it.next());  
    //it.remove();
    //it.remove();
    it.remove();
    System.out.println(it.next()); 
    it.remove();
    System.out.println(it.next()); 
    //it.remove();
    it.remove();
    System.out.println(it.next()); 
    //it.remove();
    //it.remove();
    
    //System.out.println(it.next()); 
    
    
    /*while (it.hasNext()) {
      System.out.println("tae: " + it.next()); 
    }*/
    
    for (Object el : l) {
      System.out.println("tae: " + el);
    }

  }
  
}