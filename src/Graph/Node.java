package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by brandon on 12/8/2016.
 */
public class Node {

    private String name;
    private List<Node> neighbours;
    private boolean visited;

    Node(String s){
        name = s;
        neighbours = new LinkedList<>();
        visited = false;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public List<String> getNeighboursString() {
        return neighbours.stream().map(n -> n.name).collect(Collectors.toCollection(LinkedList::new));
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
