package Hash;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class HashTableTest {
  HashTable<String> t;
  @Before
  public void setUp() throws Exception {
    t = new HashTable<>(10);
  }

  @Test
  public void add() throws Exception {
    t.add("Hello");
    assertTrue(t.contains("Hello"));
  }

  @Test
  public void remove() throws Exception {
    t.add("1");
    t.add("2");
    t.add("3");
    t.add("Hello");
    t.add("4");
    t.add("5");
    t.add("6");
    assertTrue(t.contains("1"));
    assertTrue(t.contains("2"));
    assertTrue(t.contains("3"));
    assertTrue(t.contains("Hello"));
    assertTrue(t.contains("4"));
    assertTrue(t.contains("5"));
    assertTrue(t.contains("6"));
    t.remove("Hello");
    assertFalse(t.contains("Hello"));

  }

  @Test
  public void contains() throws Exception {
    t.add("Hello");
    t.add("World");
    assertTrue(t.contains("Hello"));
    assertTrue(t.contains("World"));
    assertFalse(t.contains("!"));
  }

  @Test
  public void removeNone() throws Exception {
    assertFalse(t.contains("Hello"));
  }

}
