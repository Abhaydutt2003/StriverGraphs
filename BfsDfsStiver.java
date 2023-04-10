package StiverGraphs;

import java.util.*;

public class BfsDfsStiver {

    public static void main(String args[]) {

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean visitedArray[] = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        visitedArray[0] = true;
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ans.add(currentNode);
            ArrayList<Integer> current = adj.get(currentNode);
            for (int i : current) {
                if (visitedArray[i] == false) {
                    q.add(i);
                    visitedArray[i] = true;
                }
            }
        }
        return ans;
    }

    static boolean visitedArray2[];
    static ArrayList<Integer> ans2;

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        visitedArray2 = new boolean[V];
        ans2 = new ArrayList<Integer>();
        visitedArray2[0] = true;
        dfs(adj, 0);
        return ans2;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int currentNode) {
        visitedArray2[currentNode] = true;
        ans2.add(currentNode);
        ArrayList<Integer> currList = adj.get(currentNode);
        for (int i : currList) {
            if (visitedArray2[i] == false) {
                dfs(adj, i);
            }
        }
    }
}
