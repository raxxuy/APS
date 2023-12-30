package Labs.Labs10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class AdjacencyMatrixGraph {
    String[][] matrix;
    int startRow;
    int startCol;

    public AdjacencyMatrixGraph(int m, int n) {
        matrix = new String[m][n];
    }

    public void updateGraph(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split("");

            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];

                if (line[j].equals("S")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
    }

    public void startPath() {
        Set<List<String>> paths = new HashSet<>();

        findMinimumPath(startRow, startCol, new ArrayList<>(), paths);
        paths.stream().min(Comparator.comparing(List::size)).get().forEach(System.out::println);
    }

    private void findMinimumPath(int i, int j, ArrayList<String> visited, Set<List<String>> paths) {
        if (matrix[i][j].equals("#") || visited.contains(String.format("%d,%d", i, j))) return;

        visited.add(String.format("%d,%d", i, j));

        if (matrix[i][j].equals("E")) {
            paths.add(visited);
            return;
        }

        if (i > 0) findMinimumPath(i - 1, j, new ArrayList<>(visited), paths);
        if (j > 0) findMinimumPath(i, j - 1, new ArrayList<>(visited), paths);
        if (i < matrix.length - 1) findMinimumPath(i + 1, j, new ArrayList<>(visited), paths);
        if (j < matrix[0].length - 1) findMinimumPath(i, j + 1, new ArrayList<>(visited), paths);
    }
}

public class MazeGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(",");

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
        graph.updateGraph(br.lines().toArray(String[]::new));

        graph.startPath();
    }
}