package StiverGraphs;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String args[]) {
        int graph[][] = {
                // { 1, 0 },
                // { 2, 0 },
                // { 3, 1 },
                // { 3, 2 }
                {0,2},
                {1,2},
                {2,0}
        };
        int ans[] = util1(4, graph);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    static int[] indegree;

    public static int[] util1(int V, int matrix[][]) {
        ArrayList<ArrayList<Integer>> adj = constructGraph(V, matrix);
        constIndegree(adj, V);
        int ans[] = modifiedBfs(V, adj);
        return ans;
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

    private static int[] modifiedBfs(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int ans[] = new int[V];
        int k = ans.length - 1;
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ans[k--] = currentNode;
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        if (k == -1) {
            return ans;
        } else {
            return new int[0];
        }
    }

}
