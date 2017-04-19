import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ArrayQueueTest extends TestCase {
  private ArrayQueue<String> queue;
  public void setUp(){
    queue = new ArrayQueue<String>();
  }
  public void testFront() {
    queue.enqueue("SOAP");
    queue.enqueue("SOAP2");
    assertEquals("added two items", "SOAP", queue.front());
  }
  
  public void testDequeue(){
     queue.enqueue("SOAP");
     queue.enqueue("SOAP2");
     queue.dequeue();
     assertEquals("dequeued one item", "SOAP2", queue.front());
  }
  
  public void testDequeueEmpty(){
     try {
      queue.dequeue();
      fail("Should have thrown an exception!");
    } catch (IllegalStateException e) {  
      // expected!
    }
  }
  
  public void testGetSobra(){
     queue.enqueue("SOAP1");
      queue.enqueue("SOAP2");
      queue.enqueue("SOAP3");
      queue.enqueue("SOAP4");
      queue.enqueue("SOAP5");
      queue.enqueue("SOAP6");
      queue.enqueue("SOAP7");
      queue.enqueue("SOAP8");
      queue.enqueue("SOAP9");
      queue.enqueue("SOAP10");
      try {
      queue.enqueue("SOAP11");
      fail("Should have thrown an exception!");
    } catch (IllegalStateException e) {  
      // expected!
    }
                       
  }
  
  public void testCircularQueue(){
      queue.enqueue("SOAP1");
      queue.enqueue("SOAP2");
      queue.enqueue("SOAP3");
      queue.enqueue("SOAP4");
      queue.enqueue("SOAP5");
      queue.enqueue("SOAP6");
      queue.enqueue("SOAP7");
      queue.enqueue("SOAP8");
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.enqueue("SOAP9");
      queue.enqueue("SOAP10");
      queue.enqueue("SOAP11");
      assertEquals("peek items", "SOAP6", queue.front());
      assertEquals("check sizes", 6, queue.size());
      assertEquals("dequeued items", "SOAP6", queue.dequeue());
      assertEquals("check sizes", 5, queue.size());
  }
  
  public void testMakeEmpty(){
      queue.enqueue("SOAP1");
      queue.enqueue("SOAP2");
      queue.enqueue("SOAP3");
      queue.enqueue("SOAP4");
      queue.enqueue("SOAP5");
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      queue.dequeue();
      assertEquals("deleted all entries", true, queue.isEmpty());
  }
  
}
