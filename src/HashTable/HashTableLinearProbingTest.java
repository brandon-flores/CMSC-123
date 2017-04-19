package HashTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableLinearProbingTest {
  private HashTableLinearProbing ht;
  /*
  * 8 collisions in division method
  * 5 collisions in multiplication method
  * around 4. it changes every run in universal method
  * */

  @Before
  public void setUp() throws Exception {
    ht = new HashTableLinearProbing(10);
  }

  @Test
  public void add() throws Exception {
    ht.add(new MyInt(2));
    ht.add(new MyInt(12));
    ht.add(new MyInt(22));
    ht.add(new MyInt(9));
    ht.add(new MyInt(10));
    ht.add(new MyInt(19));
    ht.add(new MyInt(11));
    ht.add(new MyInt(12));
    ht.add(new MyInt(13));
    ht.add(new MyInt(14));
    ht.add(new MyInt(15));

    System.out.println(ht);
    System.out.println(ht.getCollisions());
  }

  @Test
  public void remove() throws Exception {
    ht.add(new MyInt(2));
    ht.add(new MyInt(12));
    ht.add(new MyInt(22));
    ht.add(new MyInt(9));
    ht.add(new MyInt(10));
    ht.add(new MyInt(19));
    ht.add(new MyInt(11));
    ht.add(new MyInt(21));
    ht.add(new MyInt(13));
    ht.add(new MyInt(14));
    ht.add(new MyInt(15));

    ht.remove(new MyInt(11));
    System.out.println(ht);
    ht.remove(new MyInt(21));
    System.out.println(ht);
    ht.add(new MyInt(21));
    System.out.println(ht);


  }

  @Test
  public void contains() throws Exception {
    ht.add(new MyInt(2));
    ht.add(new MyInt(12));
    ht.add(new MyInt(22));
    ht.add(new MyInt(9));
    ht.add(new MyInt(10));
    ht.add(new MyInt(19));
    ht.add(new MyInt(11));
    ht.add(new MyInt(21));
    ht.add(new MyInt(13));
    ht.add(new MyInt(14));
    ht.add(new MyInt(15));

    ht.remove(new MyInt(11));
    assertFalse(ht.contains(new MyInt(11)));
    assertTrue(ht.contains(new MyInt(21)));
  }

}