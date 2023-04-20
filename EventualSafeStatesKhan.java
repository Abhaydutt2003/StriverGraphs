package StiverGraphs;

import java.util.*;

public class EventualSafeStatesKhan {

    public static void main(String args[]) {
        int matrix[][] = {
            {1,2},
            {2,3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        List<Integer> ans = util1(matrix);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }

    static int indegree[];

    public static List<Integer> util1(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = constructArrayList(graph);
        constIndegree(adj, graph.length);
        List<Integer> ans = modifiedBfs(graph.length, adj);
        return ans;
    }

    private static ArrayList<ArrayList<Integer>> constructArrayList(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
            }
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

    private static List<Integer> modifiedBfs(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ans.add(currentNode);
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

}
