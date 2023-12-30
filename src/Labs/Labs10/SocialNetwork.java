package Labs.Labs10;

import java.util.*;

class AdjacencyListGraph {
    Map<String, Set<String>> users;

    public AdjacencyListGraph() {
        users = new HashMap<>();
    }

    public void addUser(String user) {
        users.computeIfAbsent(user, k -> new HashSet<>());
    }

    public void addFriends(String user, List<String> friends) {
        for (String friend : friends) {
            users.get(user).add(friend);
        }
    }

    public int startDegree(String user1, String user2) {
        Set<List<String>> paths = new HashSet<>();

        findPath(user1, user2, new ArrayList<>(), paths);

        if (paths.isEmpty()) return 0;
        else return paths.stream().mapToInt(List::size).min().getAsInt();
    }

    private void findPath(String user1, String user2, List<String> visited, Set<List<String>> paths) {
        if (visited.contains(user1)) return;

        visited.add(user1);

        if (users.get(user1).contains(user2)) {
            paths.add(visited);
            return;
        }

        for (String user : users.get(user1)) {
            findPath(user, user2, new ArrayList<>(visited), paths);
        }
    }
}

public class SocialNetwork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdjacencyListGraph graph = new AdjacencyListGraph();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String user = scanner.nextLine();
            graph.addUser(user);

            List<String> friends = new ArrayList<>();

            int m = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < m; j++) {
                String friend = scanner.nextLine();
                friends.add(friend);
            }

            graph.addFriends(user, friends);
        }

        String user1 = scanner.nextLine();
        String user2 = scanner.nextLine();

        System.out.println(graph.startDegree(user1, user2));
    }
}