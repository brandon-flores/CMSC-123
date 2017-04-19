package BST;
import org.junit.Test;

import static org.junit.Assert.*;

public class SplayTreeTest {

  @Test
  public void testSplay() throws Exception {
    SplayTree tree = new SplayTree();
    tree.add(20);
    tree.add(10);
    tree.add(30);
    tree.add(25);
    tree.add(26);
    tree.add(27);

    assertEquals("root should be 20", (Integer) 20, tree.root());
    //assertEquals("root after splay should be 25", (Integer) 25, tree.root());
    assertTrue("splay should find 27", tree.splay(27));
    assertEquals("root after splay should be 27", (Integer) 27, tree.root());
  }
}
