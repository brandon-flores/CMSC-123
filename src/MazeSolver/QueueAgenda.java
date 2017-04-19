package MazeSolver;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAgenda extends Agenda {
  private Queue<Square> queue;

  public QueueAgenda() {
    super(QueueAgenda.class);
    queue = new LinkedList<>();
  }

  @Override
  public void add(Square s) {
    // TODO
    queue.add(s);
  }

  @Override
  public Square remove() {
    // TODO
    //return null;
    return queue.remove();
  }

  @Override
  public int size() {
    // TODO
    //return 0;
    return queue.size();
  }
}
