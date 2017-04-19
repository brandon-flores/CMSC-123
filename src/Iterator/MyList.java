import java.util.*;
public interface MyList extends Iterable{
  public void add(int i, Object item);
  
  public void add(Object item);
  
  public Object get(int i);
  
  public void remove(int i);
  
  public void remove(Object i);
  
  public void set(int i, Object item);  
  
  
 
}