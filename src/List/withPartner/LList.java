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
    return new LListIterator(this);
  }
  
  private class LListIterator implements Iterator {
    
    private MyNode current;
    private MyNode prev;
    private MyNode last;
    private MyNode next;
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
      if(l.count == 1){
        current = last = l.head = prev = next = null;
      }
      else{
        if(countNext == 1){
          l.head = next;
          last = null;
        }
        else if(countNext == l.count){
          MyNode temp = l.head;
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
      l.count--;
    }
  }

}