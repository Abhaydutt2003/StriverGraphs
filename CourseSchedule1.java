package StiverGraphs;

import java.util.*;

public class CourseSchedule1 {

    public static void main(String agrs[]) {
        int matrix[][] = {
                { 1, 0 },
                { 0, 1 }
        };
        System.out.println(util1(2, matrix));
    }

    static int indegree[];
    static int toCompare = 0;

    public static boolean util1(int V, int matrix[][]) {
        ArrayList<ArrayList<Integer>> adj = constructGraph(V, matrix);
        constIndegree(adj, V);
        modifiedBfs(V, adj);
        return toCompare == V;
    }

    private static ArrayList<ArrayList<Integer>> constructGraph(int V, int graph[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < graph.length; i++) {
            adj.get(graph[i][0]).add(graph[i][1]);
        }
        return adj;
    }

    private static void constIndegree(ArrayList<ArrayList<Integer>> adj, int V) {
        indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int a : adj.get(i)) {
                indegree[a]++;
            }
        }
    }

    private static void modifiedBfs(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            toCompare++;
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
    }

}
