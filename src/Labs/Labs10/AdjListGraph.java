package Labs.Labs10;

import java.util.*;

class AdjacencyListGraph {
    Map<Integer, Set<Integer>> adjacencyList;

    public void create() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(Integer v1, Integer v2) {
        adjacencyList.putIfAbsent(v1, new HashSet<>());
        adjacencyList.putIfAbsent(v2, new HashSet<>());
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    public void deleteEdge(Integer v1, Integer v2) {
        if (adjacencyList.containsKey(v1)) {
            adjacencyList.get(v1).remove(v2);
            adjacencyList.get(v2).remove(v1);
        }
    }

    public boolean adjacent(Integer v1, Integer v2) {
        return adjacencyList.containsKey(v1) && adjacencyList.get(v1).contains(v2);
    }

    public void printGraph() {
        adjacencyList.forEach((key, value) -> System.out.printf("%d: %s%n", key, value));
        System.out.println();
    }
}

public class AdjListGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdjacencyListGraph graph = new AdjacencyListGraph();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String command = scanner.next();

            switch (command) {
                case "CREATE": {
                    graph.create();
                    break;
                }

                case "ADDEDGE": {
                    graph.addEdge(scanner.nextInt(), scanner.nextInt());
                    break;
                }

                case "DELETEEDGE": {
                    graph.deleteEdge(scanner.nextInt(), scanner.nextInt());
                    break;
                }

                case "ADJACENT": {
                    System.out.println(graph.adjacent(scanner.nextInt(), scanner.nextInt()));
                    break;
                }

                case "PRINTGRAPH": {
                    graph.printGraph();
                    break;
                }
            }
        }
    }
}