import java.util.*;

// Demonstration is class that has functionality of showing demonstration for Graph and WeightedGraph
public class Demonstration {

    /**
     * Show demonstration for Graph and WeightedGraph.
     */
    public static void main(String[] args) {
        System.out.println("DEMONSTRATION FOR Graph");
        System.out.println("Create an undirected, unweighted graph called graph1");
        Graph graph1 = new Graph();
        System.out.println("Demonstration for read(String filename) with printGraph():");
        graph1 = graph1.read("text1.txt");
        System.out.println("Print graph1 by using printGraph():");
        graph1.printGraph();
        System.out.println("Create another undirected, unweighted graph called graph2");
        Graph graph2 = new Graph();
        System.out.println("Demonstration for addNode(String name) with printGraph():");
        System.out.println("Add vertex (node) that has name HI to graph2");
        graph2.addNode("HI");
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println(
                "Add vertex (node) that also has name HI to graph2 (should be unsuccessful as it is duplicate)");
        System.out.println("Unsuccessful? " + (!graph2.addNode("HI")));
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println("Demonstration for addNodes(String[] names) with printGraph():");
        System.out.println(
                "Add vertices (nodes) with names BANANA, RASPBERRY, LEMON, CARROT, COCONUT, ORANGE, STRAWBERRY to graph2");
        graph2.addNodes(new String[] { "BANANA", "RASPBERRY", "LEMON", "CARROT", "COCONUT", "ORANGE", "STRAWBERRY" });
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println("Demonstration for addEdge(String from, String to) with printGraph():");
        System.out.println("Add edge from HI to BANANA");
        graph2.addEdge("HI", "BANANA");
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println("Demonstration for addEdges(String from, String[] tolist) with printGraph():");
        System.out.println("Add edges from RASPBERRY to HI, BANANA, CARROT, COCONUT, ORANGE, STRAWBERRY");
        graph2.addEdges("RASPBERRY", new String[] { "HI", "BANANA", "CARROT", "COCONUT", "ORANGE", "STRAWBERRY" });
        System.out.println("Add edges from LEMON to RASPBERRY, CARROT, STRAWBERRY");
        graph2.addEdges("LEMON", new String[] { "RASPBERRY", "CARROT", "STRAWBERRY" });
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println("Demonstration for removeNode(String name) with printGraph():");
        System.out.println("Remove vertex (node) with name CARROT from graph2");
        graph2.removeNode("CARROT");
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println(
                "Remove vertex (node) with name TRAIN (which is not in graph2) from graph2 (should be unsuccessful)");
        System.out.println("Unsuccessful? " + (!graph2.removeNode("TRAIN")));
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println("Demonstration for removeNodes(String[] nodelist) with printGraph():");
        System.out.println("Remove vertices (nodes) with names COCONUT, ORANGE from graph2");
        graph2.removeNodes(new String[] { "COCONUT", "ORANGE" });
        System.out.println("Print graph2 by using printGraph():");
        graph2.printGraph();
        System.out.println("Demonstration for DFS(String from, String to, String neighborOrder):");
        System.out.println("Find path from HI to STRAWBERRY with neighborOrder being alphabetical");
        System.out.print("This path: ");
        System.out.println(Arrays.toString(graph2.DFS("HI", "STRAWBERRY", "alphabetical")));
        System.out.println("Find path from HI to STRAWBERRY with neighborOrder being reverse");
        System.out.print("This path: ");
        System.out.println(Arrays.toString(graph2.DFS("HI", "STRAWBERRY", "reverse")));
        System.out.println("Demonstration for BFS(String from, String to, String neighborOrder):");
        System.out.println("Find path from HI to STRAWBERRY with neighborOrder being alphabetical");
        System.out.print("This path: ");
        System.out.println(Arrays.toString(graph2.BFS("HI", "STRAWBERRY", "alphabetical")));
        System.out.println("Find path from HI to STRAWBERRY with neighborOrder being reverse");
        System.out.print("This path: ");
        System.out.println(Arrays.toString(graph2.BFS("HI", "STRAWBERRY", "reverse")));
        System.out.println("");
        System.out.println("DEMONSTRATION FOR WeightedGraph");
        System.out.println("Create an directed, weighted graph called graph3");
        WeightedGraph graph3 = new WeightedGraph();
        System.out.println("Demonstration for readWeighted(String filename) with printWeightedGraph():");
        graph3 = graph3.readWeighted("text2.txt");
        System.out.println("Print graph3 by using printWeightedGraph():");
        graph3.printWeightedGraph();
        System.out.println("Create another directed, weighted graph called graph4");
        WeightedGraph graph4 = new WeightedGraph();
        System.out.println(
                "Demonstration for addWeightedEdge(String from, String to, int weight) with printWeightedGraph():");
        System.out.println("Add weighted edge with weight 8 from HELLO to NICE");
        graph4.addWeightedEdge("HELLO", "NICE", 8);
        System.out.println("Print graph4 by using printWeightedGraph():");
        graph4.printWeightedGraph();
        System.out.println("Add weighted edge with weight 10 from NICE to KIWI");
        graph4.addWeightedEdge("NICE", "KIWI", 10);
        System.out.println("Print graph4 by using printWeightedGraph():");
        graph4.printWeightedGraph();
        System.out.println(
                "Demonstration for addWeightedEdges(String from, String[] tolist, int[] weightlist) with printWeightedGraph():");
        System.out.println("Add weighted edges from NICE to CHERRY, LYCHEE, LIME with corresponding weights 4, 6, 5");
        graph4.addWeightedEdges("NICE", new String[] { "CHERRY", "LYCHEE", "LIME" }, new int[] { 4, 6, 5 });
        System.out.println("Print graph4 by using printWeightedGraph():");
        graph4.printWeightedGraph();
        System.out.println("Add weighted edges from HELLO to LYCHEE, LIME, CHERRY with corresponding weights 8, 7, 10");
        graph4.addWeightedEdges("HELLO", new String[] { "LYCHEE", "LIME", "CHERRY" }, new int[] { 8, 7, 10 });
        System.out.println("Print graph4 by using printWeightedGraph():");
        graph4.printWeightedGraph();
        System.out.println("Add weighted edges from CHERRY to LIME, KIWI with corresponding weights 4, 5");
        graph4.addWeightedEdges("CHERRY", new String[] { "LIME", "KIWI" }, new int[] { 4, 5 });
        System.out.println("Print graph4 by using printWeightedGraph():");
        graph4.printWeightedGraph();
        System.out.println("Demonstration for shortestPath(String from, String to):");
        System.out.println("Find the shortest path from NICE to KIWI");
        System.out.print("This path: ");
        System.out.println(Arrays.toString(graph4.shortestPath("NICE", "KIWI")));
        System.out.println("");
        System.out.println("REAL-WORLD EXAMPLE");
        WeightedGraph graph5 = new WeightedGraph();
        System.out.println("graph5 is built for some locations in North America");
        graph5.addWeightedEdges("Mayville", new String[] { "Crookston", "Clifford", "Walpeton", "Grandin", "Arvilla" },
                new int[] { 62, 18, 148, 38, 53 });
        graph5.addWeightedEdges("Walpeton", new String[] { "Grandin", "Hatton" }, new int[] { 112, 166 });
        graph5.addWeightedEdges("Grandin", new String[] { "Borup", "Perley" }, new int[] { 38, 16 });
        graph5.addWeightedEdges("Hatton", new String[] { "Mayville", "Crookston", "Finley", "Arvilla", "Borup" },
                new int[] { 18, 65, 32, 31, 88 });
        graph5.addWeightedEdges("Finley", new String[] { "Borup", "Halstad" }, new int[] { 107, 78 });
        graph5.addWeightedEdges("Perley", new String[] { "Arvilla", "Halstad" }, new int[] { 98, 20 });
        System.out.println("Print content of graph5:");
        graph4.printWeightedGraph();
        System.out.print("Shortest path from Grandin to Halstad based on the graph is that ");
        System.out.println(Arrays.toString(graph5.shortestPath("Grandin", "Halstad")));
        System.out.print("Shortest path from Mayville to Hatton based on the graph is that ");
        System.out.println(Arrays.toString(graph5.shortestPath("Mayville", "Hatton")));
        System.out.print("Shortest path from Walpeton to Borup based on the graph is that ");
        System.out.println(Arrays.toString(graph5.shortestPath("Walpeton", "Borup")));
        System.out.print("Shortest path from Hatton to Crookston based on the graph is that ");
        System.out.println(Arrays.toString(graph5.shortestPath("Hatton", "Crookston")));
        System.out.print("Shortest path from Walpeton to Hatton based on the graph is that ");
        System.out.println(Arrays.toString(graph5.shortestPath("Walpeton", "Hatton")));
    }
}