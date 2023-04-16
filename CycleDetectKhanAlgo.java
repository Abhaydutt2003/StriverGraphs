package StiverGraphs;

import java.util.*;

public class CycleDetectKhanAlgo {

    public static void main(String args[]) {
        ArrayList<Integer> zero = new ArrayList<Integer>();
        ArrayList<Integer> five = new ArrayList<Integer>();
        five.add(3);
        ArrayList<Integer> three = new ArrayList<Integer>();
        three.add(1);
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(2);
        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(4);
        ArrayList<Integer> four = new ArrayList<Integer>();
        four.add(0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(zero);
        adj.add(one);
        adj.add(two);
        adj.add(three);
        adj.add(four);
        adj.add(five);
        System.out.println(util1(6, adj));
    }

    static int indegree[];
    static int toCompare = 0;// tells how many elements in the topo sort

    public static boolean util1(int V, ArrayList<ArrayList<Integer>> adj) {
        constIndegree(adj, V);
        modifiedBfs(V, adj);
        if (toCompare == V) {
            return false;
        }
        return true;
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
            System.out.println(currentNode);
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
