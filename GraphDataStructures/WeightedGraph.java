import java.util.*;
import java.io.*;

// WeightedGraph is class for the directed and weighted graph
public class WeightedGraph {

  // VertexForWeighted is the class for the vertex (node) in the graph
  private class VertexForWeighted {
    // name is the name of the vertex
    private String name;
    // parent is the parent of the vertex and can be used to backtrace when
    // searching
    private VertexForWeighted parent;
    // edges is the list of edges that are from the vertex
    private LinkedList<WeightedEdge> edges = new LinkedList<WeightedEdge>();
    // finalized is used to check whether the shortest distance from the starting
    // vertex to this vertex is found
    private boolean finalized;
    // edgesSorted is used to certify that the list of edges connecting to the
    // vertex has been sorted alphabetically when it is true
    private boolean edgesSorted;
    // cost is used to store the cost from the starting vertex to this vertex
    private int cost;

    /**
     * Initialize the vertex with name specified in input.
     */
    private VertexForWeighted(String name) {
      this.name = name;
    }

    /**
     * If the list of edges connecting to the vertex is not certified as having been
     * sorted alphabetically, sort it alphabetically and set edgesSorted as true.
     */
    private void sortEdgesAlphabetically() {
      if (!this.edgesSorted) {
        Collections.sort(this.edges, (edge1, edge2) -> edge1.end.name.compareTo(edge2.end.name));
        this.edgesSorted = true;
      }
    }
  }

  // WeightedEdge is the class for the weighted and directed edge connecting 2
  // vertices in the graph
  private class WeightedEdge {

    // end is used to store the end vertex that the edge is connected to
    private VertexForWeighted end;

    // weight is used to store the edge's weight
    private int weight;

    /**
     * Initialize edge with end and weight specified in input.
     */
    private WeightedEdge(VertexForWeighted end, int weight) {
      this.end = end;
      this.weight = weight;
    }
  }

  // vertices is used to store all vertices in the graph
  private Hashtable<String, VertexForWeighted> vertices = new Hashtable<String, VertexForWeighted>();

  /**
   * Add the vertex with name specified in input into the graph.
   * Time complexity: approaching O(1)
   */
  private boolean addNodeForWeighted(String name) {
    // If name from input is null, just return false
    if (name == null) {
      return false;
    }
    // Create a new vertex with name specified in input; if vertices has not had
    // vertex with that name, put that vertex into vertices; otherwise, return false
    VertexForWeighted vertex = new VertexForWeighted(name);
    if (!vertices.containsKey(name)) {
      vertices.put(name, vertex);
      return true;
    }
    return false;
  }

  /**
   * Add edge connecting vertex that has name from (specified in input) to vertex
   * that has name to (specified in input) and has weight specified in input.
   * Time complexity: O(n) (n is number of vertices that vertex having name from
   * (specified in input) directs to in the graph)
   */
  public boolean addWeightedEdge(String from, String to, int weight) {
    // If either from or to is null, just return false
    if (from == null || to == null) {
      return false;
    }
    // Add vertex with name from (specified in input) and vertex with name to
    // (specified in input) to graph
    addNodeForWeighted(from);
    addNodeForWeighted(to);
    // start is used to store the vertex with name from (specified in input) in
    // vertices
    VertexForWeighted start = vertices.get(from);
    /**
     * If neither start nor ending are null or removed,
     * find if there has been edge connecting these vertices;
     * if not, create ending to store the end vertex with name to (specified in
     * input), add new edge with ending and weight to list of edges connecting from
     * start, set edgesSorted of start as false, return true;
     * otherwise, return false
     */
    ListIterator<WeightedEdge> startEdgesIterator = start.edges.listIterator();
    while (startEdgesIterator.hasNext()) {
      if (to.equals(startEdgesIterator.next().end.name)) {
        return false;
      }
    }
    VertexForWeighted ending = vertices.get(to);
    start.edges.addFirst(new WeightedEdge(ending, weight));
    start.edgesSorted = false;
    return true;
  }

  /**
   * Add edges connecting from vertex that has name from (specified in input) to
   * vertices that have names in tolist and have corresponding weights in
   * weightlist.
   * Time complexity: O(nk) (n is number of vertices that vertex having name from
   * (specified in input) directs to in the graph; k is number of elements in
   * tolist or weightlist)
   */
  public boolean addWeightedEdges(String from, String[] tolist, int[] weightlist) {
    // If from or tolist or weightlist is null, just return false
    if (from == null || tolist == null || weightlist == null) {
      return false;
    }
    // If length of tolist is not equal to length of weightlist, just return false
    if (tolist.length != weightlist.length) {
      return false;
    }
    // Add edge connecting from vertex that has name from (specified in input) to
    // each vertex that has non-null name in tolist and has corresponding weight in
    // weightlist
    for (int i = 0; i < tolist.length; i = i + 1) {
      if (tolist[i] != null) {
        addWeightedEdge(from, tolist[i], weightlist[i]);
      }
    }
    // After adding all needed edges, return true
    return true;
  }

  /**
   * Print the content of the graph with vertices (with corresponding weights)
   * sorted in alphabetical order and neighbors that each vertex directs to and
   * are sorted in alphabetical order.
   * Time complexity: worst: O((n^2)*(logn)) (n is number of vertices in graph);
   * if all edges lists are certified as alphabetically sorted, time complexity:
   * O(n^2) (n is number of vertices in graph)
   */
  public void printWeightedGraph() {
    // verticesCollection is used to store the vertices of the graph
    Collection<VertexForWeighted> verticesCollection = vertices.values();
    // verticesList is used to store array of vertices of the graph
    VertexForWeighted[] verticesList = verticesCollection.toArray(new VertexForWeighted[verticesCollection.size()]);
    // Sort verticesList in alphabetical order
    Arrays.sort(verticesList, (vertex1, vertex2) -> vertex1.name.compareTo(vertex2.name));
    /**
     * With each vertex in verticesList,
     * sort the list of neighbors that it directs to and are in alphabetical order
     * if the list of its neighbors has not been certified as having been sorted in
     * alphabetical order,
     * print that vertex and its neighbors with corresponding weights
     */
    for (int i = 0; i < verticesList.length; i = i + 1) {
      verticesList[i].sortEdgesAlphabetically();
      ListIterator<WeightedEdge> edgesIterator = verticesList[i].edges.listIterator();
      StringBuilder builder = new StringBuilder(verticesList[i].name);
      while (edgesIterator.hasNext()) {
        WeightedEdge nextEdge = edgesIterator.next();
        builder.append(" ").append(nextEdge.weight).append(" ").append(nextEdge.end.name);
      }
      System.out.println(builder.toString());
    }
  }

  /**
   * Read the file with name specified in input and create directed, weighted
   * graph based on the content of that file.
   * Time complexity: O(n^2) (n is number of vertices in graph)
   */
  public WeightedGraph readWeighted(String filename) {
    // graph is used to store the graph required by this method
    WeightedGraph graph = new WeightedGraph();
    // file is used to store the File instance of file with filename specified in
    // input
    File file = new File(filename);
    /**
     * If file is not found, throw exception;
     * otherwise, with each line of file,
     * add vertex with name as the first element in the line into the graph,
     * add edge connecting from vertex having name as the first element in the line
     * to other vertices having names and weights as the remaining corresponding
     * elements in the line
     */
    try {
      Scanner scanner = new Scanner(file);
      String line;
      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        String[] content = line.split(" ");
        graph.addNodeForWeighted(content[0]);
        for (int i = 1; i < (content.length - 1); i = i + 2) {
          graph.addWeightedEdge(content[0], content[i + 1], Integer.parseInt(content[i]));
        }
      }
      scanner.close();
    } catch (FileNotFoundException exception) {
      System.out.println("File could not be found");
    }
    // Return the graph
    return graph;
  }

  /**
   * Find the shortest path from vertex with name from to vertex with name to by
   * using Dijkstra's algorithm.
   * Time complexity: O(ne+n^2) (n is number of vertices in graph; e is number of
   * edges in graph)
   */
  public String[] shortestPath(String from, String to) {
    // path is used to store the LinkedList representation of the path required by
    // this method
    LinkedList<String> path = new LinkedList<String>();
    // startVertex is used to store the starting vertex
    VertexForWeighted startVertex = vertices.get(from);
    // If startVertex is in the vertices, follow the code in brackets right after
    // this condition
    if (startVertex != null) {
      /**
       * Set all vertices's finalized as false and all vertices's cost as maximum
       * value of integer that Java allows
       */
      Iterator<VertexForWeighted> verticesIterator = vertices.values().iterator();
      while (verticesIterator.hasNext()) {
        VertexForWeighted nextVertex = verticesIterator.next();
        nextVertex.finalized = false;
        nextVertex.cost = Integer.MAX_VALUE;
      }
      // Set startVertex's cost as 0 and startVertex's parent as null, create
      // vertexPointer to backtrace later based on parent
      startVertex.cost = 0;
      startVertex.parent = null;
      VertexForWeighted vertexPointer = null;
      // This loop continues until minimalVertex is null or has cost being equal to
      // maximum value of integer that Java allows or the to vertex has been finalized
      while (true) {
        // minimalVertex is used to store unfinalized vertex with the minimal cost
        VertexForWeighted minimalVertex = null;
        verticesIterator = vertices.values().iterator();
        // When the vertex that is unfinalized and having cost lower than that of
        // minimalVertex or minimalVertex is null, set minimalVertex as that vertex
        while (verticesIterator.hasNext()) {
          VertexForWeighted vertex = verticesIterator.next();
          if (!vertex.finalized && (minimalVertex == null || minimalVertex.cost > vertex.cost)) {
            minimalVertex = vertex;
          }
        }
        // If minimalVertex is null or has cost being equal to maximum value of integer
        // that Java allows, end the loop
        if (minimalVertex == null || minimalVertex.cost == Integer.MAX_VALUE) {
          break;
        }
        // Otherwise, set minimalVertex's finalized as true; if name of minimalVertex is
        // equal to to (specified in input), set vertexPointer as minimalVertex and end
        // the loop
        minimalVertex.finalized = true;
        if (minimalVertex.name.equals(to)) {
          vertexPointer = minimalVertex;
          break;
        }
        /**
         * With each neighbor that minimalVertex directs to,
         * if that neighbor is unfinalized and has cost higher than the cost from
         * starting vertex through minimalVertex to that neighbor,
         * set that neighbor's cost as the cost from starting vertex through
         * minimalVertex to neighbor and that neighbor's parent as minimalVertex
         */
        ListIterator<WeightedEdge> edgesIterator = minimalVertex.edges.listIterator();
        while (edgesIterator.hasNext()) {
          WeightedEdge edge = edgesIterator.next();
          VertexForWeighted neighbor = edge.end;
          if (!neighbor.finalized) {
            int costThroughMinimalVertex = minimalVertex.cost + edge.weight;
            if (costThroughMinimalVertex < neighbor.cost) {
              neighbor.cost = costThroughMinimalVertex;
              neighbor.parent = minimalVertex;
            }
          }
        }
      }
      // Backtrace vertexPointer by going from finalized vertex with name to
      // (specified in input) to starting vertex based on parent, add name of
      // vertexPointer to path's beginning in each iteration
      while (vertexPointer != null) {
        path.addFirst(vertexPointer.name);
        vertexPointer = vertexPointer.parent;
      }
    }
    String[] correctPath = path.toArray(new String[path.size()]);
    // Return the array representation of path
    return correctPath;
  }
}