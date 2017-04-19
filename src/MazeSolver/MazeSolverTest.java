package MazeSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MazeSolverTest {


  private void solve(Maze m, Maze solution, Agenda g) throws Exception {
    MazeSolver ms = new MazeSolver(m, g);
    assertTrue(ms.solve());
    assertEquals(solution.toString(), ms.getSolvedMaze().toString());
  }

  @Test
  public void solveStack1() throws Exception {
    solve(maze1(), soln1(), new StackAgenda());
  }

  @Test
  public void solveQueue1() throws Exception {
    solve(maze1(), soln1(), new QueueAgenda());
  }

  @Test
  public void solveStack2() throws Exception {
    solve(maze2(), soln2s(), new StackAgenda());
  }


  @Test
  public void solveQueue2() throws Exception {
    solve(maze2(), soln2q(), new QueueAgenda());
  }

  @Test
  public void solveStack3() throws Exception {
    solve(maze3(), soln3s(), new StackAgenda());
  }


  @Test
  public void solveQueue3() throws Exception {
    solve(maze3(), soln3q(), new QueueAgenda());
  }

  @Test
  public void solveQueue4() throws Exception {
    MazeSolver ms = new MazeSolver(maze4(), new QueueAgenda());
    try{
      assertTrue(ms.solve());
    }catch (Exception e){
      System.out.println(e.getClass() + ": " + e.getMessage());
    }
  }

  @Test
  public void solveStack4() throws Exception {
    MazeSolver ms = new MazeSolver(maze5(), new StackAgenda());
    try{
      assertTrue(ms.solve());
    }catch (Exception e){
      System.out.println(e.getClass() + ": " + e.getMessage());
    }
  }

  private Maze maze1() {
    Maze m = new Maze(4, 7);
    m.setRow(0, "#######");
    m.setRow(1, "#...#o#");
    m.setRow(2, "#*#...#");
    m.setRow(3, "#######");
    return m;
  }

  private Maze soln1() {
    Maze solution = new Maze(4, 7);
    solution.setRow(0, "#######");
    solution.setRow(1, "#xxx#o#");
    solution.setRow(2, "#*#xxx#");
    solution.setRow(3, "#######");
    return solution;
  }

  private Maze maze2() {
    Maze m = new Maze(4, 7);
    m.setRow(0, "#######");
    m.setRow(1, "#...#o#");
    m.setRow(2, "#*....#");
    m.setRow(3, "#######");
    return m;
  }

  private Maze soln2q() {
    Maze solution = new Maze(4, 7);
    solution.setRow(0, "#######");
    solution.setRow(1, "#...#o#");
    solution.setRow(2, "#*xxxx#");
    solution.setRow(3, "#######");
    return solution;
  }

  private Maze soln2s() {
    Maze solution = new Maze(4, 7);
    solution.setRow(0, "#######");
    solution.setRow(1, "#.xx#o#");
    solution.setRow(2, "#*xxxx#");
    solution.setRow(3, "#######");
    return solution;
  }

  private Maze maze3() {
    Maze m = new Maze(10, 12);
    m.setRow(0, "############");
    m.setRow(1, "#.#........#");
    m.setRow(2, "#.#.######.#");
    m.setRow(3, "#.#....#...#");
    m.setRow(4, "#.###.*#.#.#");
    m.setRow(5, "#...####.#.#");
    m.setRow(6, "#.#.#..#.#.#");
    m.setRow(7, "#.#.#.##.#.#");
    m.setRow(8, "#o#......#.#");
    m.setRow(9, "############");
    return m;
  }

  private Maze soln3s() {
    Maze m = new Maze(10, 12);
    m.setRow(0, "############");
    m.setRow(1, "#.#xxxxxxxx#");
    m.setRow(2, "#.#x######x#");
    m.setRow(3, "#.#xxx.#xxx#");
    m.setRow(4, "#.###x*#x#.#");
    m.setRow(5, "#xxx####x#.#");
    m.setRow(6, "#x#x#..#x#.#");
    m.setRow(7, "#x#x#.##x#.#");
    m.setRow(8, "#o#xxxxxx#.#");
    m.setRow(9, "############");
    return m;

  }

  private Maze soln3q() {
    Maze m = new Maze(10, 12);
    m.setRow(0, "############");
    m.setRow(1, "#.#xxxxxxxx#");
    m.setRow(2, "#.#x######x#");
    m.setRow(3, "#.#xxxx#xxx#");
    m.setRow(4, "#.###.*#x#.#");
    m.setRow(5, "#xxx####x#.#");
    m.setRow(6, "#x#x#..#x#.#");
    m.setRow(7, "#x#x#.##x#.#");
    m.setRow(8, "#o#xxxxxx#.#");
    m.setRow(9, "############");
    return m;

  }

  private Maze maze4() {
    Maze m = new Maze(4, 7);
    m.setRow(0, "#######");
    m.setRow(1, "#...#o#");
    m.setRow(2, "#*#..##");
    m.setRow(3, "#######");
    return m;
  }

  private Maze maze5() {
    Maze m = new Maze(10, 12);
    m.setRow(0, "############");
    m.setRow(1, "#.#........#");
    m.setRow(2, "#.#.######.#");
    m.setRow(3, "#.#....#...#");
    m.setRow(4, "#.###.*#.#.#");
    m.setRow(5, "#.#.####.#.#");
    m.setRow(6, "#.#.#..#.#.#");
    m.setRow(7, "#.#.#.##.#.#");
    m.setRow(8, "#o#......#.#");
    m.setRow(9, "############");
    return m;
  }

}