package MazeSolver;

import java.util.ArrayList;
import java.util.List;

public class Maze {
  private Square[][] maze;
  private int rows;
  private int cols;

  public Maze(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    maze = new Square[rows][cols];
  }

  public void setRow(int i, String row) {
    for(int j = 0; j < cols; j++){
      if(row.charAt(j) == 'o') maze[i][j] = new Square(row.charAt(j), true, i, j);
      else maze[i][j] = new Square(row.charAt(j), false, i, j);
    }

  }

  public Square origin() throws Exception {
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        if(maze[i][j].getType() == 'o') return maze[i][j];
      }
    }

    throw new Exception("origin not found");
  }

  public List<Square> neighbors(Square sq) {
    List<Square> neighbors = new ArrayList<>(4);

    if(maze[sq.getRow()][sq.getCol() - 1].getType() != '#')
      neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
    if(maze[sq.getRow() - 1][sq.getCol()].getType() != '#')
      neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
    if(maze[sq.getRow()][sq.getCol() + 1].getType() != '#')
      neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
    if(maze[sq.getRow() + 1][sq.getCol()].getType() != '#')
      neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
    return neighbors;
  }

  public Square getSquare(int row, int col) {
    return maze[row][col];
  }

  @Override
  public String toString() {
    String mazeStr = "";
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        mazeStr += maze[i][j].getType();
      }
      if (i < rows - 1) {
        mazeStr += "\n";
      }
    }
    return mazeStr;
  }

  public Maze clone() {
    Maze clone = new Maze(rows, cols);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        clone.maze[i][j] = maze[i][j].clone();
      }
    }
    return clone;
  }

  public void setSquare(int row, int col, Square s) {
    maze[row][col] = s;
  }
}
