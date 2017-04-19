//need to implement MyList to LList
import java.util.*;
public class LList implements MyList{
  private MyNode head;
  private int count;
  
  public LList() {
    head = null;
  }
  
  public void add(Object item) {
    if (head == null){
      head = new MyNode(item);
    }
    MyNode next = new MyNode(item);
    MyNode current = head;
    if (current != null) {
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(next);
    }
    count++;
  }
  
  public void add(int i, Object item) {
    if (head == null){
      head = new MyNode(item);
    }
    if (count < i){
      throw new IndexOutOfBoundsException();
    }
    MyNode current = head;
    MyNode next = new MyNode(item);
    
    if (current != null){
      for (int j = 0; j < i && current.getNext() != null; j++){
        current = current.getNext();
      }
    }
    next.setNext(current.getNext());
    current.setNext(next);
    count++;
    
    }
  
  public Object get(int i) {
    if (count == 0 || i >= count){
      throw new IndexOutOfBoundsException();
    }
    MyNode current = null;
    if (head != null) {
      current = head.getNext();
      for (int j = 0; j < i; j++) {
        if (current.getNext() == null){
          return null;
        }
        current = current.getNext();
      }
      return current.getData();
    }
    return current;
  }
  
  public void remove(int i) {
    if (head == null){
      System.out.println("ERROR; LIST IS EMPTY");
      //break;
    }
    MyNode current = head;
    if (current != null){
      for (int j = 0; j < i; j++){
        if (current.getNext() == null){
          System.out.println("Index not found");
        }
        current = current.getNext();
      }
      current.setNext(current.getNext().getNext());
      count--;
    }
  }
  
  public void remove(Object i) {
    int cnt  = 0;
    if (head == null){
      System.out.println("ERROR; LIST IS EMPTY");
      //break;
    }
    MyNode current = head;
    
    while (true){
      if (current.getData().equals(i)){
        break;
      }
      else{
        current = current.getNext();
        cnt++;
      }
    }
      
    if (current != null){
      for (int j = 0; j < cnt; j++){
        if (current.getNext() == null){
          System.out.println("Index not found");
        }
        current = current.getNext();
      }
      current.setNext(current.getNext().getNext());
      count--;
    }
  }
  
  public void set (int i, Object item){
  if (head == null){
      head = new MyNode(item);
    }
    if (count < i){
      throw new IndexOutOfBoundsException();
    }
    MyNode current = head;
    MyNode next = new MyNode(item);
    
    if (current != null){
      for (int j = 0; j < i && current.getNext() != null; j++){
        current = current.getNext();
      }
    }
    next.setNext(current.getNext());
    current.setNext(next);
    //count++;
  }


  /*
  public void set(int i, String item) {
    this.items[i] = item;
  }*/
  
  private class MyNode{
    private Object data;
    private MyNode next;
    
    public MyNode(Object data, MyNode next){
      this.data = data;
      this.next = next;
    }
    
    public MyNode(Object data){
      this(data, null);
    }
    
    public Object getData(){
      return data;
    }
    
    public void setData(Object data){
      this.data = data;
    }
    
    public MyNode getNext(){
      return next;
    }
    
    public void setNext(MyNode next){
      this.next = next;
    }
    
  }
  
  public Iterator iterator() {
    return new LListIterator(head);
  }
  
  private class LListIterator implements Iterator {
    
    private MyNode current;
    private boolean callNext;
    private MyNode prev;
    private MyNode last;
    private MyNode next;
    private int countNext;
    
    public LListIterator(MyNode head) {
      current = last = head;
      prev = next = null;
      countNext = 0;
    }
    
    public Object next() {
      if (current == null) {
        throw new NoSuchElementException();
      }
      callNext = true;
      countNext++;
      Object data = current.getData();
      current = current.getNext();
      last = current;
      return data;
    }
    
    public boolean hasNext() {
      return current != null;
    }
    
    public void remove(){
      if(!callNext) throw new IllegalStateException("error");
      if(count == 1){
        current = last = head = prev = next = null;
      }
      else{
        if(countNext == 1){
          last = head;
          head = head.getNext();
          next = head.getNext();
        }
        /*else if(countNext == count){
          for (int j = 0; j < countNext - 1; j++){
            if (current.getNext() == null){
              System.out.println("Index not found");
            }
            last = current;
            current = current.getNext();
          }
          current 
        }*/
        else{
          for (int j = 0; j < countNext; j++){
            if (current.getNext() == null){
              System.out.println("Index not found");
            }
            current = current.getNext();
          }
          prev = current;
          next = current.getNext().getNext();
          last = null;
        }
      }
      callNext  = false;
    }
  }
}