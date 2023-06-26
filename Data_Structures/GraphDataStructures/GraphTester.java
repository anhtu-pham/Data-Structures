import org.junit.*;
import static org.junit.Assert.*;
public class GraphTester{
  
  /**
   * Tests the addNode(String name) method of Graph.
   */
  @Test
  public void testAddNode(){
    Graph graph = new Graph();
    
    // When input name is null
    assertFalse(graph.addNode(null));
    
    // When input name is not null
    assertTrue(graph.addNode("MANGO"));
    assertTrue(graph.addNode("STRAWBERRY"));
    
    // When vertex with input name has already been in graph
    assertFalse(graph.addNode("MANGO"));
    
    System.out.println("Graph in testAddNode():");
    graph.printGraph();
  }
  
  /**
   * Tests the addNodes(String[] names) method of Graph.
   */
  @Test
  public void testAddNodes(){
    Graph graph = new Graph();
    // When input names is null
    assertFalse(graph.addNodes(null));
    
    // When input names contains only 1 element
    assertTrue(graph.addNodes(new String[]{"BANANA"}));
    
    // When input names contains many elements
    assertTrue(graph.addNodes(new String[]{"RASPBERRY", "LEMON", "ORANGE"}));
    
    System.out.println("Graph in testAddNodes():");
    graph.printGraph();
  }
  
  /**
   * Tests the addEdge(String from, String to) method of Graph.
   */
  @Test
  public void testAddEdge(){
    Graph graph = new Graph();
    
    // When from and to in input are null
    assertFalse(graph.addEdge(null, null));
    
    // When only from in input is null
    assertFalse(graph.addEdge(null, null));
    
    // When only to in input is null
    assertFalse(graph.addEdge(null, null));
    
    graph.addNodes(new String[]{"CYAN", "BLUE", "ORANGE", "PURPLE"});
    
    // When from and to are not null and two vertices with the names in input are in graph and edge connecting these two vertices has not been in graph
    assertTrue(graph.addEdge("CYAN", "ORANGE"));
    assertTrue(graph.addEdge("ORANGE", "PURPLE"));
    graph.removeNode("BLUE");
    
    // When a vertex with name in input is not in graph
    assertFalse(graph.addEdge("BLUE", "ORANGE"));
    
    // When edge connecting two vertices with the names in input has already been in graph
    assertFalse(graph.addEdge("CYAN", "ORANGE"));
    
    System.out.println("Graph in testAddEdge():");
    graph.printGraph();
  }
  
  /**
   * Tests the addEdges(String from, String[] tolist) method of Graph.
   */
  @Test
  public void testAddEdges(){
    Graph graph = new Graph();
    
    // When from in input is null
    assertFalse(graph.addEdges(null, new String[]{"HI"}));
    
    graph.addNode("PUMPKIN");
    
    // When tolist in input is null
    assertFalse(graph.addEdges("PUMPKIN", null));
    
    graph.addNodes(new String[]{"CARROT", "SPINACH", "ONION", "LETTUCE", "PEPPER"});
    
    // When both from and tolist are not null and vertices with the names in input are in graph and edges connecting these vertices has not been in graph
    assertTrue(graph.addEdges("CARROT", new String[]{"SPINACH"}));
    assertTrue(graph.addEdges("ONION", new String[]{"LETTUCE", "PEPPER", "SPINACH", "CARROT"}));
    
    System.out.println("Graph in testAddEdges():");
    graph.printGraph();
  }
  
  /**
   * Tests the removeNode(String name) method of Graph.
   */
  @Test
  public void testRemoveNode(){
    Graph graph = new Graph();
    
    graph.addNodes(new String[]{"BANANA", "CARROT", "PEPPER", "PIZZA", "TOMATO"});
    graph.addEdges("BANANA", new String[]{"CARROT", "TOMATO"});
    graph.addEdges("PEPPER", new String[]{"PIZZA", "CARROT", "TOMATO"});
    
    // When input name is null
    assertFalse(graph.removeNode(null));
    
    // When vertex with non-null input name has not been in graph
    assertFalse(graph.removeNode("PURPLE"));
    
    // When vertex with non-null input name has been in graph
    assertTrue(graph.removeNode("CARROT"));
    
    System.out.println("Graph in testRemoveNode():");
    graph.printGraph();
  }
  
  /**
   * Tests the removeNodes(String[] nodelist) method of Graph.
   */
  @Test
  public void testRemoveNodes(){
    Graph graph = new Graph();
    
    // When input nodelist is null
    assertFalse(graph.removeNodes(null));
    
    graph.addNodes(new String[]{"CARROT", "SPINACH", "ONION", "LETTUCE", "PEPPER"});
    graph.addEdges("CARROT", new String[]{"ONION", "LETTUCE"});
    graph.addEdges("SPINACH", new String[]{"LETTUCE, PEPPER"});
    
    // When vertices with non-null names in input has been in graph
    assertTrue(graph.removeNodes(new String[]{"CARROT", "SPINACH", "ONION"}));
    
    System.out.println("Graph in testRemoveNodes():");
    graph.printGraph();
  }
  
  /**
   * Tests the printGraph() method of Graph.
   */
  @Test
  public void testPrintGraph(){
    Graph graph = new Graph();
    graph.addNodes(new String[]{"CYAN", "BLUE", "ORANGE", "PURPLE", "GREEN"});
    graph.addEdges("BLUE", new String[]{"CYAN", "ORANGE"});
    graph.addEdges("PURPLE", new String[]{"CYAN", "GREEN"});
    graph.removeNode("BLUE");
    
    // printGraph() is tested after adding nodes, adding edges to graph, removing node from the graph
    System.out.println("Graph in testPrintGraph():");
    graph.printGraph();
  }
  
  /**
   * Tests the read(String filename) method of Graph.
   */
  @Test
  public void testRead(){
    Graph graph = new Graph();
    
    // Test read(String filename) with file whose name is text1.txt
    graph = graph.read("text1.txt");
    System.out.println("Graph in testRead():");
    graph.printGraph();
  }
  
  /**
   * Tests the DFS(String from, String to, String neighborOrder) method of Graph.
   */
  @Test
  public void testDFS(){
    Graph graph = new Graph();
    graph.addNodes(new String[]{"BANANA", "CARROT", "PEPPER", "PIZZA", "TOMATO", "BREAD"});
    graph.addEdges("BANANA", new String[]{"CARROT", "TOMATO", "BREAD"});
    graph.addEdges("PEPPER", new String[]{"PIZZA", "BREAD", "CARROT", "TOMATO"});
    
    // Test DFS(String from, String to, String neighborOrder) when from is equal to to
    assertArrayEquals(new String[]{"CARROT"}, graph.DFS("CARROT", "CARROT", "alphabetical"));
    
    // Test DFS(String from, String to, String neighborOrder) when searching neighbors in alphabetical order
    assertArrayEquals(new String[]{"BANANA", "BREAD", "PEPPER", "PIZZA"}, graph.DFS("BANANA", "PIZZA", "alphabetical"));
    
    // Test DFS(String from, String to, String neighborOrder) when searching neighbors in reverse order
    assertArrayEquals(new String[]{"BANANA", "TOMATO", "PEPPER", "PIZZA"}, graph.DFS("BANANA", "PIZZA", "reverse"));
    
    // Test DFS(String from, String to, String neighborOrder) when neighborOrder is neither alphabetical nor reverse
    try{
      graph.DFS("BANANA", "PIZZA", "nice");
    }
    catch(IllegalArgumentException exception){
    }
    catch(Exception exception){
      fail("Threw inappropriate exception");
    }
  }
  
  /**
   * Tests the BFS(String from, String to, String neighborOrder) method of Graph.
   */
  @Test
  public void testBFS(){
    Graph graph = new Graph();
    graph.addNodes(new String[]{"SPINACH", "CARROT", "CHILI", "PIZZA", "TOMATO", "BREAD"});
    graph.addEdges("SPINACH", new String[]{"CARROT", "TOMATO", "BREAD"});
    graph.addEdges("CHILI", new String[]{"PIZZA", "BREAD", "CARROT", "TOMATO"});
    
    // Test BFS(String from, String to, String neighborOrder) when from is equal to to
    assertArrayEquals(new String[]{"CHILI"}, graph.BFS("CHILI", "CHILI", "reverse"));
    
    // Test BFS(String from, String to, String neighborOrder) when searching neighbors in alphabetical order
    assertArrayEquals(new String[]{"SPINACH", "BREAD", "CHILI", "PIZZA"}, graph.BFS("SPINACH", "PIZZA", "alphabetical"));
    
    // Test BFS(String from, String to, String neighborOrder) when searching neighbors in reverse order
    assertArrayEquals(new String[]{"SPINACH", "TOMATO", "CHILI", "PIZZA"}, graph.BFS("SPINACH", "PIZZA", "reverse"));
    
    // Test BFS(String from, String to, String neighborOrder) when neighborOrder is neither alphabetical nor reverse
    try{
      graph.BFS("CHILI", "PIZZA", "gate");
    }
    catch(IllegalArgumentException exception){
    }
    catch(Exception exception){
      fail("Threw inappropriate exception");
    }
  }
}