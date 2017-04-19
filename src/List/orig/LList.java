/**
 * created by brandon
 */
public class LList implements MyList{
  private NewNode head;
  int size;
  
  private static class NewNode{
    private Object item;
    private NewNode next;
    
    public NewNode(){
      next = null;
    }
    public NewNode(Object i){
      item = i;
      next = null;
    }
  }
  
  public LList(){
    head = null;
    size = 0;
  }
  
  public void add(Object i) {
    NewNode n = new NewNode(i);
    NewNode temp = head;
    if(size == 0){
      head = n;
    }
    else{
      while(temp.next != null){
        temp = temp.next;
      }
      temp.next = n;
    }
    size++;
  }
  
  public void add(int x, Object i) {
    NewNode n = new NewNode(i);
    NewNode temp = head;
    if(x > size) throw new IndexOutOfBoundsException();
    if(x == 0){
      n.next = head;
      head = n;
    }
    else{
      int ctr = 0;
      while(ctr < x - 1){
        temp = temp.next;
        ctr++;
      }
      n.next = temp.next;
      temp.next = n;    
    }
    size++;
  }
  
  public Object get(int i) {
    check(i);
    NewNode temp = head;
    int ctr = 0;
    while(ctr < i){
      temp = temp.next;
      ctr++;
    }
    return temp.item;
  }
  
  public void remove(int i) {
    check(i);
    NewNode temp = head;
    if(i == 0){
      head = head.next;
    }
    else{
      for(int x = 1; x < i; x++){
        temp = temp.next;
      }
      temp.next = temp.next.next;
    }
     size--;  
  }

  public void remove(Object s) {
    int x;
    NewNode temp = head;
    for(x = 0; x < size && !(temp.item.equals(s)); x++){  
      temp = temp.next;
    } 
    if(x == size && !(temp.item.equals(s))){
      throw new IndexOutOfBoundsException();
    }
    else{
      remove(x);
    }
  }
  
  public void set(int i, Object s) {
    check(i);
    NewNode temp = head;
    int ctr = 0;
    while(ctr < i){
      temp = temp.next;
      ctr++;
    }
    temp.item = s;
  }
 
  public void check(int i){
    if (size == 0 || i >= size || i < 0) {
      throw new IndexOutOfBoundsException();
    }
  }

}
