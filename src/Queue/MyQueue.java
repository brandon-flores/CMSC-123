public interface MyQueue<E> {
  public void enqueue(E item);

  public E dequeue();

  public E front();

  public boolean isEmpty();

  public int size();


}