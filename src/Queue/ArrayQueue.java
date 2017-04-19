public class ArrayQueue<E> implements MyQueue<E>{
  private int front;
  private int rear;
  private int size;
  private static final int MAX_CAPACITY = 10;
  private E[] queue;
  
  public ArrayQueue(){
    front = 0;
    rear = 0;
    size = 0;
    queue = (E[])(new Object[MAX_CAPACITY]); 
    
  }
  public void enqueue(E item){
    if (size != MAX_CAPACITY){
      queue[rear] = item;
      size++;
      rear = (rear+1) % MAX_CAPACITY;}
    else throw new IllegalStateException();
  }

  public E dequeue(){
    if (size == 0)
      throw new IllegalStateException();
    E item = queue[front];
    queue[front] = null;
    front = (front+1) % MAX_CAPACITY;;
    size--;
    return item;
  }

  public E front(){
    return queue[front];
  }

  public boolean isEmpty(){
    return size() == 0;
  }

  public int size(){
    return size;
  }
}