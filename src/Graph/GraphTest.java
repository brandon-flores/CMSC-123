package Graph;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class GraphTest {

  private Graph g;

  @Before
  public void setUp() throws Exception {
    g = new Graph();
  }

  @Test
  public void addNode() throws Exception {
    g.addNode("Manila");
    g.addNode("Cebu");
    g.addNode("Bacolod");
    g.addNode("Tagbilaran");
    g.addNode("Zamboanga");
    g.addNode("Davao");
    g.addNode("Naga");
    g.addNode("Basilan");
    g.addNode("Tawi-tawi");

    String s = "Basilan Tawi-tawi Tagbilaran Zamboanga Naga Cebu Manila Davao Bacolod ";

    assertEquals(s, g.getStr());
  }

  @Test
  public void addEdge() throws Exception {
    g.addEdge("Manila", "Cebu");
    g.addEdge("Manila", "Bacolod");
    g.addEdge("Manila", "Tagbilaran");
    g.addEdge("Manila", "Zamboanga");
    g.addEdge("Manila", "Davao");
    g.addEdge("Manila", "Naga");
    g.addEdge("Zamboanga", "Tawi-tawi");

    String ss = "";
    for(String s : g.outEdges("Manila")){
      ss += s + " ";
    }

    assertEquals("Cebu Bacolod Tagbilaran Zamboanga Davao Naga ", ss);
    ss = "";
    for(String s : g.outEdges("Zamboanga")){
      ss += s + " ";
    }
    assertEquals("Manila Tawi-tawi ", ss);

  }

  @Test
  public void removeEdge() throws Exception {
    g.addEdge("Manila", "Cebu");
    g.addEdge("Manila", "Bacolod");
    g.addEdge("Manila", "Tagbilaran");
    g.addEdge("Manila", "Zamboanga");
    g.addEdge("Manila", "Davao");
    g.addEdge("Manila", "Naga");
    g.addEdge("Zamboanga", "Tawi-tawi");

    String ss = "";
    for(String s : g.outEdges("Manila")){
      ss += s + " ";
    }

    assertEquals("Cebu Bacolod Tagbilaran Zamboanga Davao Naga ", ss);
    ss = "";
    for(String s : g.outEdges("Zamboanga")){
      ss += s + " ";
    }
    assertEquals("Manila Tawi-tawi ", ss);

    g.removeEdge("Manila", "Cebu");
    g.removeEdge("Manila", "Davao");
    g.removeEdge("Manila", "Zamboanga");

    ss = "";
    for(String s : g.outEdges("Manila")){
      ss += s + " ";
    }

    assertEquals("Bacolod Tagbilaran Naga ", ss);
    ss = "";
    for(String s : g.outEdges("Zamboanga")){
      ss += s + " ";
    }
    assertEquals("Tawi-tawi ", ss);

  }

  @Test
  public void hasEdge() throws Exception {
    g.addEdge("Manila", "Cebu");
    g.addEdge("Manila", "Bacolod");
    g.addEdge("Manila", "Tagbilaran");
    g.addNode("Basilan");

    assertTrue(g.hasEdge("Manila", "Bacolod"));
    assertTrue(g.hasEdge("Manila", "Cebu"));
    assertTrue(g.hasEdge("Manila", "Tagbilaran"));
    assertFalse(g.hasEdge("Manila", "Basilan"));
  }

  @Test
  public void outEdges() throws Exception {
    g.addEdge("Manila", "Cebu");
    g.addEdge("Manila", "Bacolod");
    g.addEdge("Manila", "Tagbilaran");
    g.addEdge("Manila", "Zamboanga");
    g.addEdge("Manila", "Davao");
    g.addEdge("Manila", "Naga");
    g.addEdge("Zamboanga", "Tawi-tawi");

    String ss = "";
    for(String s : g.outEdges("Manila")){
      ss += s + " ";
    }

    assertEquals("Cebu Bacolod Tagbilaran Zamboanga Davao Naga ", ss);
  }

  @Test
  public void inEdges() throws Exception {
    g.addEdge("Manila", "Cebu");
    g.addEdge("Manila", "Bacolod");
    g.addEdge("Manila", "Tagbilaran");
    g.addEdge("Manila", "Zamboanga");
    g.addEdge("Manila", "Davao");
    g.addEdge("Manila", "Naga");
    g.addEdge("Zamboanga", "Tawi-tawi");

    String ss = "";
    for(String s : g.inEdges("Zamboanga")){
      ss += s + " ";
    }

    assertEquals("Manila Tawi-tawi ", ss);
  }

  @Test
  public void bfs() throws Exception {
    g.addEdge("Manila", "Cebu");
    g.addEdge("Manila", "Bacolod");
    g.addEdge("Manila", "Tagbilaran");
    g.addEdge("Manila", "Zamboanga");
    g.addEdge("Manila", "Davao");
    g.addEdge("Manila", "Naga");
    g.addEdge("Cebu", "Zamboanga");
    g.addEdge("Cebu", "Bacolod");
    g.addEdge("Cebu", "Davao");
    g.addEdge("Zamboanga", "Davao");
    g.addEdge("Zamboanga", "Tawi-tawi");
    g.addNode("Basilan");

    String ss = "";
    for(String s : g.bfs("Manila")){
      ss += s + " ";
    }
    assertEquals("Manila Cebu Bacolod Tagbilaran Zamboanga Davao Naga Tawi-tawi ", ss);
    ss = "";
    for(String s : g.bfs("Zamboanga")){
      ss += s + " ";
    }
    assertEquals("Zamboanga Manila Cebu Davao Tawi-tawi Bacolod Tagbilaran Naga ", ss);
  }

  @Test
  public void dfs() throws Exception {
    g.addEdge("Manila", "Cebu");
    g.addEdge("Manila", "Bacolod");
    g.addEdge("Manila", "Tagbilaran");
    g.addEdge("Manila", "Zamboanga");
    g.addEdge("Manila", "Davao");
    g.addEdge("Manila", "Naga");
    g.addEdge("Cebu", "Zamboanga");
    g.addEdge("Cebu", "Bacolod");
    g.addEdge("Cebu", "Davao");
    g.addEdge("Zamboanga", "Davao");
    g.addEdge("Zamboanga", "Tawi-tawi");
    g.addNode("Basilan");

    String ss = "";
    for(String s : g.dfs("Manila")){
      ss += s + " ";
    }
    assertEquals("Manila Naga Davao Zamboanga Tawi-tawi Tagbilaran Bacolod Cebu ", ss);
    ss = "";
    for(String s : g.dfs("Zamboanga")){
      ss += s + " ";
    }
    assertEquals("Zamboanga Tawi-tawi Davao Cebu Bacolod Manila Naga Tagbilaran ", ss);
  }

}