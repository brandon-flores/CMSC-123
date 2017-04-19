package Splay;

public class MazeSolver {
  private Maze maze;
  private Maze solvedMaze;
  private Agenda ag;

  public MazeSolver(Maze maze, Agenda ag) {
    this.maze = maze;
    this.ag = ag;
    solvedMaze = maze.clone();
  }

  public boolean solve() throws Exception {
    return markPathToEnd(solvedMaze.origin());
  }

  private boolean markPathToEnd(Square sq) throws InstantiationException, IllegalAccessException {
    // TODO 1. base case: if you're at the end (you made it!), return true

    // TODO 2. otherwise, mark the current square:
    // - as visited, and
    // - as a step on the path (x)

    // 3. create an empty agenda of next squares to visit!
    Agenda agenda = ag.newInstance();
    // use the generator, which will generate either a:
    // - stack agenda, or
    // - queue agenda
    //
    // the generator allows us to not be concerned with
    // specific agenda implementation we're using

    // TODO 4. add all sq's neighbors to the agenda

    // TODO 5. take a square out of the agenda, and do this:
    // if that square is not yet visited,
    // call markPathToEnd on that square
    // if that call to markPathToEnd is successful (you made it!): return true
    // otherwise, take the next square out of the agenda
    // repeat until the agenda is empty


    // if you made it this far, seems there is no
    // path to the end from this square (boo!)
    // TODO 6. unmark the current square (change it back to '.' from 'x')

    // 7. report that there's no path to the end from here!
    return false;

  }

  public Maze getSolvedMaze() {
    return solvedMaze;
  }

}
