package BST;

/**
 * Created by brandon on 11/11/2016.
 */
import junit.framework.TestCase;
import org.junit.Test;


public class MyBinarySearchTreeTest extends TestCase {
    MyBinarySearchTree tree;

    @Override
    protected void setUp() throws Exception {
        tree = new MyBinarySearchTree();
    }

    @Test
    public void testAdd() throws Exception {
        tree.add(15);
        assertTrue(tree.contains(15));
    }

    @Test
    public void testAddMany() throws Exception {
        tree.add(5);
        tree.add(10);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        assertEquals(tree.toString(), "5 10 20 30 40 ");
    }

    @Test
    public void testRemove() throws Exception {
        tree.add(15);
        tree.add(20);
        tree.remove(15);
        assertFalse(tree.contains(15));
        assertTrue(tree.contains(20));
        assertEquals(tree.toString(), "20 ");
    }

    @Test
    public void testContains() throws Exception {
        tree.add(5);
        tree.add(10);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        assertTrue(tree.contains(5));
        assertFalse(tree.contains(16));
    }

    @Test
    public void testDuplicate() throws Exception {
        tree.add(5);
        tree.add(10);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        try{
            tree.add(5);
            fail("Should've thrown an error");
        }catch(Exception e){

        }
    }

    @Test
    public void testAddplus() throws Exception {
        tree.add(3);
        tree.add(2);
        tree.add(0);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(24);
        tree.add(19);
        tree.add(18);
        tree.add(22);
        assertEquals(tree.toString(), "0 1 2 3 4 5 18 19 22 24 ");
    }

    @Test
    public void testRemoveroot() throws Exception {
        tree.add(3);
        tree.add(2);
        tree.add(0);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(24);
        tree.add(19);
        tree.add(18);
        tree.add(22);
        tree.remove(3);
        assertEquals("0 1 2 4 5 18 19 22 24 ", tree.toString());
        tree.remove(4);
        assertEquals("0 1 2 5 18 19 22 24 ", tree.toString());
    }

    @Test
    public void testRemove2child() throws Exception {
        tree.add(3);
        tree.add(2);
        tree.add(0);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(24);
        tree.add(19);
        tree.add(18);
        tree.add(22);
        tree.remove(5);
        assertEquals("0 1 2 3 4 18 19 22 24 ", tree.toString());
    }

    @Test
    public void testRemove1child() throws Exception {
        tree.add(3);
        tree.add(2);
        tree.add(0);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(24);
        tree.add(19);
        tree.add(18);
        tree.add(22);
        tree.remove(2);
        assertEquals("0 1 3 4 5 18 19 22 24 ", tree.toString());
    }

    @Test
    public void testRemoveLeaf() throws Exception {
        tree.add(3);
        tree.add(2);
        tree.add(0);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(24);
        tree.add(19);
        tree.add(18);
        tree.add(22);
        tree.remove(1);
        assertEquals("0 2 3 4 5 18 19 22 24 ", tree.toString());
        tree.remove(22);
        assertEquals("0 2 3 4 5 18 19 24 ", tree.toString());
    }
}