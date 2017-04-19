package trees;
import static org.junit.Assert.*;

public class ExpressionTreeTest {
  @org.junit.Test
  public void eval() throws Exception {
    MyTreeNode five = new MyTreeNode("5", null, null);
    MyTreeNode four = new MyTreeNode("4", null, null);
    MyTreeNode two = new MyTreeNode("2", null, null);
    MyTreeNode three = new MyTreeNode("3", null, null);
    MyTreeNode times1 = new MyTreeNode("*", five, four);
    MyTreeNode times2 = new MyTreeNode("*", two, three);
    MyTreeNode plus = new MyTreeNode("+", times1, times2);

    assertEquals(26, ExpressionTree.eval(plus));
  }

}