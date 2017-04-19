package MazeSolver;

import java.util.List;

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
    boolean status = markPathToEnd(solvedMaze.origin());
    if(!status) throw new Exception("No valid path!");
    return status;
  }

  private boolean markPathToEnd(Square sq) throws InstantiationException, IllegalAccessException {
    if(sq.getType() == '*'){
      return true;
    }else{
      Square ss = new Square('x', true, sq.getRow(), sq.getCol());
      if(!sq.isVisited()) solvedMaze.setSquare(sq.getRow(), sq.getCol(), ss);
      Agenda agenda = ag.newInstance();
      List<Square> square = solvedMaze.neighbors(sq);
      for(Square s : square){
        agenda.add(s);
      }
      while (agenda.size() > 0){
        Square s = agenda.remove();
        if(!s.isVisited() && s.getType() != '#') {
          if(markPathToEnd(s)){
            return true;
          }
        }
      }
    }
    Square ss = new Square('.', true, sq.getRow(), sq.getCol());
    if(sq.getType() != 'o') solvedMaze.setSquare(sq.getRow(), sq.getCol(), ss);

    return false;
  }

  public Maze getSolvedMaze() {
    return solvedMaze;
  }

}
