package MazeSolver;

public class Square {
  private char type;
  private boolean visited;
  private int row;
  private int col;

  public Square(char type, boolean visited, int row, int col) {
    this.type = type;
    this.visited = visited;
    this.row = row;
    this.col = col;
  }

  public char getType() {
    return type;
  }

  public boolean isVisited() {
    return visited;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  @Override
  public String toString() {
    return "Square{" +
                   "type=" + type +
                   ", visited=" + visited +
                   ", row=" + row +
                   ", col=" + col +
                   '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Square square = (Square) o;

    if (type != square.type) return false;
    if (row != square.row) return false;
    return col == square.col;

  }

  @Override
  public int hashCode() {
    int result = (int) type;
    result = 31 * result + row;
    result = 31 * result + col;
    return result;
  }

  public Square clone() {
    return new Square(type, visited, row, col);
  }

}
