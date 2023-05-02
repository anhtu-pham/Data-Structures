import java.util.*;
import java.io.*;

// Graph is class for the undirected and unweighted graph
public class Graph {

  // Vertex is the class for the vertex (node) in the graph
  private class Vertex {
    // name is the name of the vertex
    private String name;
    // parent is the parent of the vertex and can be used to backtrace when
    // searching
    private Vertex parent;
    // edges is the list of edges that connect to the vertex
    private LinkedList<Edge> edges = new LinkedList<Edge>();
    // encountered is used to check whether the vertex is examined
    private boolean encountered;
    // removed is used to check whether the vertex is removed
    private boolean removed;
    // edgesSortedAlphabetically is used to certify that the list of edges
    // connecting to the vertex has been sorted alphabetically when it is true
    private boolean edgesSortedAlphabetically;
    // edgesSortedInReverse is used to certify that the list of edges connecting to
    // the vertex has been sorted in reverse when it is true
    private boolean edgesSortedInReverse;

    /**
     * Initialize vertex with name specified in input.
     */
    private Vertex(String name) {
      this.name = name;
    }

    /**
     * If the list of edges connecting to the vertex is not certified as having been
     * sorted alphabetically, sort it alphabetically and set
     * edgesSortedAlphabetically as true.
     */
    private void sortEdgesAlphabetically() {
      if (!this.edgesSortedAlphabetically) {
        Collections.sort(this.edges, (edge1, edge2) -> edge1.end.name.compareTo(edge2.end.name));
        this.edgesSortedAlphabetically = true;
      }
    }

    /**
     * If the list of edges connecting to the vertex is not certified as having been
     * sorted in reverse, sort it in reverse and set edgesSortedInReverse as true.
     */
    private void sortEdgesInReverse() {
      if (!this.edgesSortedInReverse) {
        Collections.sort(this.edges, (edge1, edge2) -> edge2.end.name.compareTo(edge1.end.name));
        this.edgesSortedInReverse = true;
      }
    }
  }

  // Edge is the class for the unweighted and undirected edge connecting 2
  // vertices in the graph
  private class Edge {

    // end is used to store the end vertex connecting to the edge
    private Vertex end;

    /**
     * Initialize edge with end specified in input.
     */
    private Edge(Vertex end) {
      this.end = end;
    }
  }

  // vertices is used to store all vertices in the graph
  private Hashtable<String, Vertex> vertices = new Hashtable<String, Vertex>();

  // isCorrectPath is used to check whether the path found is correct
  private boolean isCorrectPath = false;

  /**
   * Add the vertex with name specified in input into the graph.
   * Time complexity: approaching O(1)
   */
  public boolean addNode(String name) {
    // If name from input is null, just return false
    if (name == null) {
      return false;
    }
    // Create a new vertex with name specified in input; if vertices has not had
    // vertex with that name, put that vertex into vertices; otherwise, return false
    Vertex vertex = new Vertex(name);
    if (!vertices.containsKey(name)) {
      vertices.put(name, vertex);
      return true;
    }
    return false;
  }

  /**
   * Add the vertices with names specified in input into the graph.
   * Time complexity: approaching O(k) (k is size of names in input)
   */
  public boolean addNodes(String[] names) {
    // If names is null, just return false
    if (names == null) {
      return false;
    }
    // Add each vertex having corresponding name from names in input into the graph
    for (int i = 0; i < names.length; i = i + 1) {
      addNode(names[i]);
    }
    // After adding all needed vertices, return true
    return true;
  }

  /**
   * Add undirected edge connecting vertex that has name from (specified in input)
   * to vertex that has name to (specified in input).
   * Time complexity: O(n) (n is number of vertices connecting to vertex that has
   * name from (specified in input) in the graph)
   */
  public boolean addEdge(String from, String to) {
    // If either from or to is null, just return false
    if (from == null || to == null) {
      return false;
    }
    // start is used to store the vertex with name from (specified in input) in
    // vertices
    Vertex start = vertices.get(from);
    // ending is used to store the vertex with name from (specified in input) in
    // vertices
    Vertex ending = vertices.get(to);
    /**
     * If neither start nor ending are null or removed,
     * find if there has been edge connecting these vertices;
     * if not, add edge with end being ending to list of edges connecting to start,
     * add edge with end being start to list of edges connecting to ending,
     * set boolean fields that check whether the start's edges and the ending's
     * edges are certified as being sorted as false, return true;
     * otherwise, return false
     */
    if (start != null && ending != null && !start.removed && !ending.removed) {
      ListIterator<Edge> startEdgesIterator = start.edges.listIterator();
      while (startEdgesIterator.hasNext()) {
        if (to.equals(startEdgesIterator.next().end.name)) {
          return false;
        }
      }
      start.edges.addFirst(new Edge(ending));
      ending.edges.addFirst(new Edge(start));
      start.edgesSortedAlphabetically = false;
      ending.edgesSortedAlphabetically = false;
      start.edgesSortedInReverse = false;
      ending.edgesSortedInReverse = false;
      return true;
    }
    return false;
  }

  /**
   * Add undirected edges connecting vertex that has name from (specified in
   * input) to vertices that have names in tolist.
   * Time complexity: O(nk) (n is number of vertices connecting to vertex that has
   * name from (specified in input) in the graph; k is number of elements in
   * tolist)
   */
  public boolean addEdges(String from, String[] tolist) {
    // If either from or tolist is null, just return false
    if (from == null || tolist == null) {
      return false;
    }
    // Add undirected edge connecting vertex that has name from (specified in input)
    // to each vertex that has non-null name in tolist into the graph
    for (int i = 0; i < tolist.length; i = i + 1) {
      if (tolist[i] != null) {
        addEdge(from, tolist[i]);
      }
    }
    // After adding all needed edges, return true
    return true;
  }

  /**
   * Remove vertex that has name specified in input from the graph and remove all
   * edges connecting to that vertex.
   * Time complexity: approaching O(1)
   */
  public boolean removeNode(String name) {
    // If name is null, just return false
    if (name == null) {
      return false;
    }
    // removedVertex is used to store the vertex that has name specified in input
    // (the vertex that is about to be removed)
    Vertex removedVertex = vertices.get(name);
    /**
     * If the required vertex is not in the graph, return false;
     * otherwise, if that vertex has already been removed, return false;
     * otherwise, set removed of removedVertex as true and remove that vertex (the
     * vertex with name specified in input) from vertices, return true
     */
    if (removedVertex != null) {
      if (removedVertex.removed) {
        return false;
      }
      removedVertex.removed = true;
      vertices.remove(name);
      return true;
    }
    return false;
  }

  /**
   * Remove all vertices that have names in nodelist and remove all edges
   * connecting to those vertices from the graph.
   * Time complexity: approaching O(k) (k is number of elements in nodelist)
   */
  public boolean removeNodes(String[] nodelist) {
    // If nodelist is null, just return false
    if (nodelist == null) {
      return false;
    }
    // Remove each vertex that has non-null name in nodelist and all edges
    // connecting to that vertex from the graph, return true
    for (int i = 0; i < nodelist.length; i = i + 1) {
      if (nodelist[i] != null) {
        removeNode(nodelist[i]);
      }
    }
    // After removing all needed nodes, return true
    return true;
  }

  /**
   * Print the content of the graph with vertices sorted in alphabetical order and
   * neighbors connecting to each vertex sorted in alphabetical order.
   * Time complexity: worst: O((n^2)*(logn)) (n is number of vertices in graph);
   * if all edges lists are certified as alphabetically sorted, time complexity:
   * O(n^2) (n is number of vertices in graph)
   */
  public void printGraph() {
    // verticesCollection is used to store the vertices of the graph
    Collection<Vertex> verticesCollection = vertices.values();
    // verticesList is used to store array of vertices of the graph
    Vertex[] verticesList = verticesCollection.toArray(new Vertex[verticesCollection.size()]);
    // Sort verticesList in alphabetical order
    Arrays.sort(verticesList, (vertex1, vertex2) -> vertex1.name.compareTo(vertex2.name));
    /**
     * With each vertex in verticesList,
     * sort the list of its neighbors in alphabetical order if the list of its
     * neighbors has not been certified as having been sorted in alphabetical order,
     * print that vertex and its neighbors
     */
    for (int i = 0; i < verticesList.length; i = i + 1) {
      verticesList[i].sortEdgesAlphabetically();
      ListIterator<Edge> edgesIterator = verticesList[i].edges.listIterator();
      StringBuilder builder = new StringBuilder(verticesList[i].name);
      while (edgesIterator.hasNext()) {
        Vertex nextVertex = edgesIterator.next().end;
        if (!nextVertex.removed) {
          builder.append(" ").append(nextVertex.name);
        }
      }
      System.out.println(builder.toString());
    }
  }

  /**
   * Read the file with name specified in input and create undirected, unweighted
   * graph based on the content of that file
   * Time complexity: O(n^2) (n is number of vertices in graph)
   */
  public Graph read(String filename) {
    // graph is used to store the graph required by this method
    Graph graph = new Graph();
    // file is used to store the File instance of file with filename specified in
    // input
    File file = new File(filename);
    /**
     * If file is not found, throw exception;
     * otherwise, with each line of file,
     * add the vertices with names as the elements in the line into the graph,
     * add undirected edge connecting vertex having name as the first element in the
     * line to other vertices having names as the remaining elements in the line
     */
    try {
      Scanner scanner = new Scanner(file);
      String line;
      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        String[] names = line.split(" ");
        graph.addNode(names[0]);
        for (int i = 1; i < names.length; i = i + 1) {
          graph.addNode(names[i]);
          graph.addEdge(names[0], names[i]);
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
   * Search by depth first search algorithm and return the path from the vertex
   * with name from (specified in input) to the vertex with name to (specified in
   * input); neighbors are searched in neighborOrder order
   * (neighborOrder can be alphabetical or reverse).
   * Time complexity: O(n + e); worst: O(n^2) (n is number of vertices in graph; e
   * is number of edges in graph)
   */
  public String[] DFS(String from, String to, String neighborOrder) {
    // If neighborOrder is neither alphabetical nor reverse, throw exception
    if (!neighborOrder.equals("alphabetical") && !neighborOrder.equals("reverse")) {
      throw new IllegalArgumentException("neighborOrder has to be alphabetical or reverse");
    }
    // If from is equal to to, just return the array having only from
    if (from.equals(to)) {
      return new String[] { from };
    }
    // path is used to store the LinkedList representation of the path required by
    // this method
    LinkedList<String> path = new LinkedList<String>();
    // startVertex is used to store the starting vertex
    Vertex startVertex = vertices.get(from);
    /**
     * If startVertex is neither null nor removed,
     * set all vertices's encountered as false and isCorrectPath as false,
     * call recurDFS, check isCorrectPath; if isCorrectPath is true, add the
     * starting node's name to the path's beginning
     */
    if ((startVertex != null) && (!startVertex.removed)) {
      Iterator<Vertex> verticesIterator = vertices.values().iterator();
      while (verticesIterator.hasNext()) {
        verticesIterator.next().encountered = false;
      }
      isCorrectPath = false;
      recurDFS(path, startVertex, to, neighborOrder);
      if (isCorrectPath) {
        path.addFirst(startVertex.name);
      }
    }
    String[] correctPath = path.toArray(new String[path.size()]);
    // Return the array representation of path
    return correctPath;
  }

  /**
   * Recursive method that helps DFS method,
   * this method searches neighbors based on depth first search algorithm and in
   * neighborOrder order, add elements of the correct path to path,
   * continues calling itself until finding out the vertex with name to (specified
   * in input).
   */
  private void recurDFS(LinkedList<String> path, Vertex vertex, String to, String neighborOrder) {
    // Set vertex's encountered as true
    vertex.encountered = true;
    // If neighborOrder is alphabetical, sort list of neighbors of vertex in
    // alphabetical order
    if (neighborOrder.equals("alphabetical")) {
      vertex.sortEdgesAlphabetically();
    }
    // Otherwise, sort list of neighbors of vertex in reverse order
    else {
      vertex.sortEdgesInReverse();
    }
    /**
     * With each neighbor of vertex,
     * if that neighbor is neither encountered nor removed:
     * in case that neighbor's name is equal to to (specified in input), add that
     * neighbor's name to path's beginning, set isCorrectPath as true, and end the
     * method;
     * in case that neighbor's name is not equal to to (specified in input),
     * recursively call this method, and when isCorrectPath is true, add that
     * neighbor's name to path's beginning
     */
    ListIterator<Edge> edgesIterator = vertex.edges.listIterator();
    while (edgesIterator.hasNext() && !isCorrectPath) {
      Vertex nextVertex = edgesIterator.next().end;
      if (!nextVertex.encountered && !nextVertex.removed) {
        if (nextVertex.name.equals(to)) {
          path.addFirst(nextVertex.name);
          isCorrectPath = true;
          return;
        }
        recurDFS(path, nextVertex, to, neighborOrder);
        if (isCorrectPath) {
          path.addFirst(nextVertex.name);
        }
      }
    }
  }

  /**
   * Search by breadth first search algorithm and return the path from the vertex
   * with name from (specified in input) to the vertex with name to (specified in
   * input); neighbors are searched in neighborOrder order
   * (neighborOrder can be alphabetical or reverse).
   * Time complexity: O(n + e); worst: O(n^2) (n is number of vertices in graph; e
   * is number of edges in graph)
   */
  public String[] BFS(String from, String to, String neighborOrder) {
    // If neighborOrder is neither alphabetical nor reverse, throw exception
    if (!neighborOrder.equals("alphabetical") && !neighborOrder.equals("reverse")) {
      throw new IllegalArgumentException("neighborOrder has to be alphabetical or reverse");
    }
    // If from is equal to to, just return the array having only from
    if (from.equals(to)) {
      return new String[] { from };
    }
    // path is used to store the LinkedList representation of the path required by
    // this method
    LinkedList<String> path = new LinkedList<String>();
    // startVertex is used to store the starting vertex
    Vertex startVertex = vertices.get(from);
    /**
     * If startVertex is neither null nor removed,
     * set all vertices's encountered as false and isCorrectPath as false,
     * create vertexPointer to backtrace later based on parent, create queue, set
     * startVertex's encountered as true and parent as null, add startVertex to
     * queue
     * when queue is not empty and correct path has not been found,
     * remove vertex from queue's beginning, sort list of that vertex's neighbor
     * based on neighborOrder,
     * when isCorrectPath is false, with each neighbor that is neither removed nor
     * encountered:
     * set that neighbor's encountered as true and its parent as vertex (to
     * backtrace later);
     * if a neighbor's name is equal to to (specified in input), set vertexPointer
     * as that neighbor and set isCorrectPath as true;
     * otherwise, add that neighbor to the queue
     */
    if ((startVertex != null) && (!startVertex.removed)) {
      Iterator<Vertex> verticesIterator = vertices.values().iterator();
      while (verticesIterator.hasNext()) {
        verticesIterator.next().encountered = false;
      }
      isCorrectPath = false;
      Vertex vertexPointer = null;
      Queue<Vertex> queue = new LinkedList<Vertex>();
      startVertex.encountered = true;
      startVertex.parent = null;
      queue.add(startVertex);
      while (queue.peek() != null && !isCorrectPath) {
        Vertex vertex = queue.remove();
        if (neighborOrder.equals("alphabetical")) {
          vertex.sortEdgesAlphabetically();
        } else {
          vertex.sortEdgesInReverse();
        }
        ListIterator<Edge> edgesIterator = vertex.edges.listIterator();
        while (edgesIterator.hasNext() && !isCorrectPath) {
          Vertex nextVertex = edgesIterator.next().end;
          if (!nextVertex.removed && !nextVertex.encountered) {
            nextVertex.encountered = true;
            nextVertex.parent = vertex;
            if (nextVertex.name.equals(to)) {
              vertexPointer = nextVertex;
              isCorrectPath = true;
            } else {
              queue.add(nextVertex);
            }
          }
        }
      }
      // Backtrace vertexPointer by going from vertex with name to (specified in
      // input) to starting vertex based on parent, add name of vertexPointer to
      // path's beginning in each iteration
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