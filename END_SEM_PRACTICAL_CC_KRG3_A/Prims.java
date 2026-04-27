import java.util.*;

public class Prims {
    static class Node {
        int vertex;
        int weight;
        Node(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
    
    public static void primMST(int[][] graph, int V) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(0, 0));
        int total = 0;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.vertex]) continue;
            
            visited[curr.vertex] = true;
            total += curr.weight;
            
            if (curr.vertex != 0) {
                System.out.println(curr.vertex + " - " + (V - 1) + "\t" + curr.weight);
            }
            
            for (int i = 0; i < V; i++) {
                if (graph[curr.vertex][i] != 0 && !visited[i]) {
                    pq.add(new Node(i, graph[curr.vertex][i]));
                }
            }
        }
        
        System.out.println("Total MST Weight: " + total);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();
        System.out.println("Enter number of edges:");
        int E = sc.nextInt();
        
        int[][] graph = new int[V][V];
        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
            graph[v][u] = w;
        }
        
        primMST(graph, V);
    }
}