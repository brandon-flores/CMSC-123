package Graph;

import java.util.*;

public class Graph {
  private Map<String, Node> nodes = new HashMap<>();

  //add lang
  public void addNode(String src) {
    Node n = nodes.get(src);
    if (n == null) {
      n = new Node(src);
      nodes.put(src, n);
    }
  }

  //mao ning para connect??
  public void addEdge(String src, String dst) {
    if(!hasEdge(src, dst)){
      addNode(src);
      addNode(dst);
      nodes.get(src).getNeighbours().add(nodes.get(dst));
      nodes.get(dst).getNeighbours().add(nodes.get(src));
    }
  }

  //remove connection??
  public void removeEdge(String src, String dst) {
    if(hasEdge(src, dst)){
      nodes.get(src).getNeighbours().remove(nodes.get(dst));
      nodes.get(dst).getNeighbours().remove(nodes.get(src));
    }
  }

  //if connected ba??
  public boolean hasEdge(String src, String dst) {
    return !(!nodes.containsKey(src) || !nodes.containsKey(dst)) && nodes.get(src).getNeighbours().contains(nodes.get(dst));
  }

  public List<String> outEdges(String src) {
    return nodes.get(src).getNeighboursString();
  }

  public List<String> inEdges(String src) {
    return nodes.get(src).getNeighboursString();
  }

  public List<String> bfs(String src) {
    List<String> l = new LinkedList<>();
    Queue<String> q = new LinkedList<>();
    q.add(nodes.get(src).getName());
    nodes.get(src).setVisited(true);
    while(!q.isEmpty()){
      String ss = q.remove();
      l.add(ss);
      for (String s : outEdges(ss)) {
        Node n = nodes.get(s);
        if(!n.isVisited()) {
          q.add(s);
          n.setVisited(true);
        }
      }
    }
    reset();
    return l;
  }

  public List<String> dfs(String src) {
    List<String> l = new LinkedList<>();
    Stack<String> s = new Stack<>();
    s.push(nodes.get(src).getName());
    nodes.get(src).setVisited(true);
    while(!s.isEmpty()){
      String temp = s.pop();
      l.add(temp);
      for(String ss : outEdges(temp)){
        Node n = nodes.get(ss);
        if(!n.isVisited()){
          s.push(ss);
          n.setVisited(true);
        }
      }
    }
    reset();
    return l;
  }

  //for GraphTest

  public String getStr() {
    String s = "";
    int i = 0;
    for (Map.Entry<String, Node> entry : nodes.entrySet()) {
      s += entry.getValue().getName() + " ";
    }

    return s;
  }

  private void reset(){
    for (Map.Entry<String, Node> entry : nodes.entrySet()) {
      entry.getValue().setVisited(false);
    }
  }
}
