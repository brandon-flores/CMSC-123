import java.util.*;
public class LListTestNew {
  
  public static void main(String[] args) {    
    LList l = new LList();
    l.add("A");
    l.add("B");
    l.add("C");
    
    Iterator it = l.iterator();
    System.out.println(l.get(0));
    System.out.println(l.get(1));
    System.out.println(l.get(2));
    System.out.println(it.next());
    System.out.println(it.next());  
    System.out.println(it.next()); 
   // System.out.println(it.next());
    it.remove();
    
   /* while (it.hasNext()) {
      System.out.println(it.next()); 
    }
    
    for (Object el : l) {
      System.out.println(el);
    }*/

  }
  
}