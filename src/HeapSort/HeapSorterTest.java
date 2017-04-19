package HeapSort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSorterTest {

  int[] items;
  HeapSorter hs;

  @Before
  public void setUp() throws Exception {
    items = new int[]{8, 12, 2, 10, 6, 4};
    hs = new HeapSorter(items);
  }

  @Test
  public void add() throws Exception {
    hs.add(8);
    assertEquals(
            Arrays.toString(new int[]{8, 12, 2, 10, 6, 4}),
            Arrays.toString(items)
    );
    hs.add(12);
    assertEquals(
            Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
            Arrays.toString(items)
    );
  }

  @Test
  public void bubbleUp() throws Exception {
    hs.bubbleUp(1);
    assertEquals(
            Arrays.toString(new int[]{12, 8, 2, 10, 6, 4}),
            Arrays.toString(items)
    );
  }

  @Test
  public void parent() throws Exception {
    assertEquals(0, hs.parent(1));
  }

  @Test
  public void sort() throws Exception {
    hs.sort();
    assertEquals(
            Arrays.toString(new int[]{2, 4, 6, 8, 10, 12}),
            Arrays.toString(items)
    );
  }

  @Test
  public void swap() throws Exception {
    hs.swap(0,5);
    assertEquals(
            Arrays.toString(new int[]{4, 12, 2, 10, 6, 8}),
            Arrays.toString(items)
    );
  }

  @Test
  public void remove() throws Exception {
    for(int i = 0; i < 6; i++){
      hs.add(items[i]);
    }
    hs.remove();
    assertEquals(
            Arrays.toString(new int[]{10, 8, 4, 2, 6, 12}),
            Arrays.toString(items)
    );

    /*
    * After add:
    * 12 10 4 8 6 2
    * After remove call:
    * 2 10 4 8 6 12
    * 10 2 4 8 6 12
    * 10 8 4 2 5 12
    * */
  }

  @Test
  public void trickleDown() throws Exception {
    for(int i = 0; i < 6; i++){
      hs.add(items[i]);
    }
    hs.swap(0, 5);
    hs.trickleDown(0);
    assertEquals(
            Arrays.toString(new int[]{10, 8, 4, 2, 6, 12}),
            Arrays.toString(items)
    );

    /*
    * After add:
    * 12 10 4 8 6 2
    * Swap(0, 5):
    * 2 10 4 8 6 12
    * Trickle(0)
    * 10 2 4 8 6 12
    * 10 8 4 2 6 12
    * */
  }

  @Test
  public void hasLeft() throws Exception {
    for(int i = 0; i < 6; i++){
      hs.add(items[i]);
    }
    assertTrue("true", hs.hasLeft(2));
  }

  @Test
  public void hasRight() throws Exception {
    for(int i = 0; i < 6; i++){
      hs.add(items[i]);
    }
    assertFalse("false", hs.hasRight(2));
  }

  @Test
  public void right() throws Exception {
    assertEquals(4, hs.right(1));
  }

  @Test
  public void left() throws Exception {
    assertEquals(5, hs.left(2));
  }

}
