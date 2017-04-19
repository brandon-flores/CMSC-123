import junit.framework.TestCase;
/**
 * created by brandon flores
 */

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class AListTest extends TestCase {
  
  private MyList l;
  
  public void setUp(){
    l = new AList();
  }
  public void testAddOne() {
    
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
     l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
    l.add("Shampoo");
   
   
    assertEquals("added one item", "Shampoo", l.get(0));
  }
  
  public void testAddTwo() {
    
    l.add("Shampoo");
    l.add("Soap");
    assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
    assertEquals("added two items and second was Soap", "Soap", l.get(1));
  }
  
  public void testAddBetween() {
    
    l.add("Shampoo");
    l.add("Soap");
    l.add(1, "Deodorant");
    assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
    assertEquals("added two items and second was Deodorant", "Deodorant", l.get(1));
    assertEquals("added two items and third was Soap", "Soap", l.get(2));
  }
  
  public void testGetOutOfBoundsWhenEmpty() {
    
    try {
      l.get(0);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  
  public void testGetOutOfBounds() {
    
    l.add("Shampoo");
    try {
      l.get(1);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  public void testRemoveLast() {
   
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(2);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Deodorant", "Deodorant", l.get(1));
    }
  }
  
  
  public void testRemoveMid() {
    
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(1);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Soap", "Soap", l.get(1));
    }
  }
  
  
  public void testSet() {
    
    l.add("Shampoo");
    l.set(0, "Deodorant");
    assertEquals("added two items and first was Deodorant", "Deodorant", l.get(0));
  }
  
  public void testRemoveString() {
   
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove("Deodorant");
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Soap", "Soap", l.get(1));
    }
  }
}
