/**
 * created by brandon
 */
import java.util.*;
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
    public Object getData(){
      return item;
    }
    
    public void setData(Object data){
      this.item = item;
    }
    
    public NewNode getNext(){
      return next;
    }
    
    public void setNext(NewNode next){
      this.next = next;
    }
  }
  
  public Iterator iterator() {
    return new LListIterator(this);
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
    NewNode temp1;
    if(i == 0){
  temp1 = head;
      head = head.next;
   temp1 = null;
    }
    else{
      for(int x = 1; x < i; x++){
        temp = temp.next;
      }
      temp1 = temp.next;
      temp.next = temp.next.next;
      temp1 = null;
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
  
  private class LListIterator implements Iterator {
    
    private NewNode current;
    private NewNode prev;
    private NewNode last;
    private NewNode next;
    private int countNext;
    private boolean callNext;
    private LList l = new LList();
    
    public LListIterator(LList x) {
      l = x;
      current = next = l.head;
      last = prev = null;
      countNext = 0;
      callNext = false;
    }
    
    public Object next() {
      if (current == null) {
        throw new NoSuchElementException();
      }
      if(callNext) prev = last;
      callNext = true;
      countNext++;
      Object data = current.getData();
      last = next;
      current = current.getNext();
      next = current;
      return data;
    }
    
    public boolean hasNext() {
      return current != null;
    }
    
    public void remove(){
      if(!callNext) throw new IllegalStateException();
      callNext  = false;
      if(l.size == 1){
        current = last = l.head = prev = next = null;
      }
      else{
        if(countNext == 1){
          l.head = next;
          last = null;
        }
        else if(countNext == l.size){
          NewNode temp = l.head;
          for (int j = 1; j < countNext - 2; j++){
            temp = temp.getNext();
          }
          last = prev;
          prev = temp;
          last.setNext(next);
        }
        else{
          prev.setNext(next);
          last = null;
        }
      }
      
      countNext--;
      l.size--;
    }
  }

}
