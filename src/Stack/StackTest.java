import junit.framework.TestCase;
import java.util.EmptyStackException;

public class StackTest extends TestCase {
  
  private Stack<String> s;
  public void setUp(){
    s = new Stack<String>();
  }
  
  public void testPush() {
    s.push("Shampoo");
    assertEquals("added items first:", "Shampoo", s.peek());
    s.push("Shampoo1");
    assertEquals("added items second:", "Shampoo1", s.peek());
    s.push("Shampoo2");
    assertEquals("added items third:", "Shampoo2", s.peek());
  }
  
  public void testPop() {
    s.push("Shampoo");
    s.push("Shampoo1");
    s.push("Shampoo2");
    assertEquals("added items first:", "Shampoo2", s.pop());
    assertEquals("added items second:", "Shampoo1", s.pop());
    assertEquals("peek test:", "Shampoo", s.peek());
    assertEquals("added items third:", "Shampoo", s.pop());
  }
  
  public void testPeek(){
    s.push("Shampoo");
    s.push("Shampoo1");
    s.push("Shampoo2");
    assertEquals("last item:", "Shampoo2", s.peek());
  }
  
  public void testPopEmpty() {
    try {
      s.pop();
      fail("Should have thrown an exception!");
    } catch (EmptyStackException e) {  
      // expected!
    }
  }
  
  public void testPeekEmpty(){
    try {
      s.peek();
      fail("Should have thrown an exception!");
    } catch (EmptyStackException e) {  
      // expected!
    }
  }
  
  public void testPopMoreThan() {
    s.push("Shampoo");
    s.push("Shampoo1");
    s.push("Shampoo2");
    s.pop();
    s.pop();
    s.pop();
    try {
      s.pop();
      fail("Should have thrown an exception!");
    } catch (EmptyStackException e) {  
      // expected!
    }
  }
  
  public void testPeekMoreThan() {
    s.push("Shampoo");
    s.push("Shampoo1");
    s.push("Shampoo2");
    s.pop();
    s.pop();
    s.pop();
    try {
      s.peek();
      fail("Should have thrown an exception!");
    } catch (EmptyStackException e) {  
      // expected!
    }
  }
  
  public void testPushplusplus() {
    s.push("Shampoo1");
    s.push("Shampoo2");
    s.push("Shampoo3");
    s.push("Shampoo4");
    s.push("Shampoo5");
    s.push("Shampoo6");
    s.push("Shampoo7");
    s.push("Shampoo8");
    s.push("Shampoo9");
    s.push("Shampoo10");
    s.push("Shampoo11");
    s.push("Shampoo12");
    s.push("Shampoo13");
    s.push("Shampoo14");
    s.push("Shampoo15");
    s.push("Shampoo16");
    s.push("Shampoo17");
    assertEquals("last item:", "Shampoo17", s.peek());
    
  }
}
