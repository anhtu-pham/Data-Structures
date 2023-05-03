import org.junit.*;
import static org.junit.Assert.*;
public class WeightedGraphTester{
  
  /**
   * Tests the addWeightedEdge(String from, String to, int weight) method of WeightedGraph.
   */
  @Test
  public void testAddWeightedEdge(){
    WeightedGraph graph = new WeightedGraph();
    
    // When from and to in input are null
    assertFalse(graph.addWeightedEdge(null, null, 5));
    
    // When from in input is null
    assertFalse(graph.addWeightedEdge(null, "PINEAPPLE", 9));
    
    // When to in input is null
    assertFalse(graph.addWeightedEdge("CHERRY", null, 1));
    
    // When from and to in input are not null
    assertTrue(graph.addWeightedEdge("CYAN", "ORANGE", 6));
    assertTrue(graph.addWeightedEdge("ORANGE", "PURPLE", 12));
    assertTrue(graph.addWeightedEdge("ORANGE", "GREEN", 4));
    assertTrue(graph.addWeightedEdge("ORANGE", "YELLOW", 18));
    
    System.out.println("Graph in testAddWeightedEdge():");
    graph.printWeightedGraph();
  }
  
  /**
   * Tests the addWeightedEdges(String from, String[] tolist, int[] weightlist) method of WeightedGraph.
   */
  @Test
  public void testAddWeightedEdges(){
    WeightedGraph graph = new WeightedGraph();
    
    // When from in input is null
    assertFalse(graph.addWeightedEdges(null, new String[]{"HI"}, new int[]{10}));
    
    // When tolist in input is null
    assertFalse(graph.addWeightedEdges("HELLO", null, new int[]{12}));
    
    // When weightlist in input is null
    assertFalse(graph.addWeightedEdges("WATER", new String[]{"TREE"}, null));
    
    // When from, tolist, weightlist in input are not null and tolist's length and weightlist's length are not equal to each other
    assertFalse(graph.addWeightedEdges("NICE", new String[]{"HELLO"}, new int[]{8, 6}));
    
    // When from, tolist, weightlist in input are not null and tolist's length and weightlist's length are equal to each other
    assertTrue(graph.addWeightedEdges("CARROT", new String[]{"SPINACH"}, new int[]{14}));
    assertTrue(graph.addWeightedEdges("ONION", new String[]{"LETTUCE", "PEPPER", "SPINACH", "CARROT"}, new int[]{15, 4, 6, 12}));
    
    System.out.println("Graph in testAddWeightedEdges():");
    graph.printWeightedGraph();
  }
  
  /**
   * Tests the printWeightedGraph() method of WeightedGraph.
   */
  @Test
  public void testPrintWeightedGraph(){
    WeightedGraph graph = new WeightedGraph();
    graph.addWeightedEdges("CARROT", new String[]{"SPINACH"}, new int[]{16});
    graph.addWeightedEdges("LETTUCE", new String[]{"ONION", "PEPPER", "SPINACH", "CARROT"}, new int[]{12, 16, 22, 41});
    
    // printWeightedGraph() is tested after adding weighted edges to graph
    System.out.println("Graph in testPrintWeightedGraph():");
    graph.printWeightedGraph();
  }
  
  /**
   * Tests the readWeighted(String filename) method of WeightedGraph.
   */
  @Test
  public void testReadWeighted(){
    WeightedGraph graph = new WeightedGraph();
    
    // Test readWeighted(String filename) with file whose name is text2.txt
    graph = graph.readWeighted("text2.txt");
    System.out.println("Graph in testReadWeighted():");
    graph.printWeightedGraph();
  }
  
  /**
   * Tests the shortestPath(String from, String to) method of WeightedGraph.
   */
  @Test
  public void testShortestPath(){
    WeightedGraph graph = new WeightedGraph();
    graph.addWeightedEdges("LETTUCE", new String[]{"ONION", "APRICOT", "LEMON", "MANGO"}, new int[]{12, 6, 2, 6});
    graph.addWeightedEdges("APRICOT", new String[]{"MANGO", "ONION", "ORANGE", "GRAPES"}, new int[]{8, 12, 6, 4});
    graph.addWeightedEdges("LEMON", new String[]{"MANGO", "ONION", "ORANGE", "GRAPES"}, new int[]{4, 4, 1, 3});
    
    // Test shortestPath(String from, String to) when from is equal to to
    assertArrayEquals(new String[]{"ORANGE"}, graph.shortestPath("ORANGE", "ORANGE"));
    
    // Test shortestPath(String from, String to) when there are many paths from vertex with name from to vertex with name to
    assertArrayEquals(new String[]{"LETTUCE", "LEMON", "GRAPES"}, graph.shortestPath("LETTUCE", "GRAPES"));
    
    // Test shortestPath(String from, String to) when vertex with name from directs to vertex with name to but there is another path that costs less
    assertArrayEquals(new String[]{"LETTUCE", "LEMON", "ONION"}, graph.shortestPath("LETTUCE", "ONION"));
  }
}