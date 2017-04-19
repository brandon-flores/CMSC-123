package MazeSolver;

import java.util.Stack;

public class StackAgenda extends Agenda {
  private Stack<Square> stack;

  public StackAgenda() {
    super(StackAgenda.class);
    stack = new Stack<>();
  }

  @Override
  public void add(Square s) {
    // TODO
    stack.push(s);
  }

  @Override
  public Square remove() {
    // TODO
    //return null;
    return stack.pop();
  }

  @Override
  public int size() {
    // TODO
    //return 0;
    return stack.size();
  }
}
