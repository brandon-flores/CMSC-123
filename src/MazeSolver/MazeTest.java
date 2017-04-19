package MazeSolver;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MazeTest {

  private Maze m;

  @Before
  public void setUp() throws Exception {
    m = new Maze(4, 7);
    m.setRow(0, "#######");
    m.setRow(1, "#...#o#");
    m.setRow(2, "#*#...#");
    m.setRow(3, "#######");
  }

  @Test
  public void neighbors() throws Exception {
    List<Square> ns = m.neighbors(m.getSquare(1, 3));

    assertEquals(2, ns.size());
    assertEquals(new Square('.', false, 1, 2), ns.get(0));
    assertEquals(new Square('.', false, 2, 3), ns.get(1));
  }

  @Test
  public void origin() throws Exception {
    Square o = m.origin();
    assertEquals(1, o.getRow());
    assertEquals(5, o.getCol());
  }

  @Test
  public void origin1() throws Exception {
    try{
      maze6().origin();
    }catch (Exception e){
      System.out.println(e.getClass() + ": " + e.getMessage());
    }

  }

  private Maze maze6() {
    Maze m = new Maze(4, 7);
    m.setRow(0, "#######");
    m.setRow(1, "#...#.#");
    m.setRow(2, "#*#...#");
    m.setRow(3, "#######");
    return m;
  }

  @org.junit.Test
  public void setRow() throws Exception {
    System.out.println(m.toString());
    assertEquals("#######\n#...#o#\n#*#...#\n#######", m.toString());
  }

}