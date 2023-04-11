
    package StiverGraphs;

import java.util.*;

public class DetectCycleInGraph {

    public static void main(String args[]) {
        int v = 5;
        visited = new boolean[v];
        // for(int i = 0;i<visited.length;i++){
        // if(visited[i] == false){
        // bfs();
        // }
        // }
    }

    // wrong
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        boolean visitedArray[] = new boolean[V];
        visitedArray[0] = true;
        int prev = -1;
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ArrayList<Integer> current = adj.get(currentNode);
            for (int i : current) {
                if (i != prev && visitedArray[i] == true) {
                    return true;
                } else if (visitedArray[i] == false) {
                    q.add(i);
                    visitedArray[i] = true;
                }
            }
            prev = currentNode;
        }
        return false;
    }

    static boolean visited[];

    // right approach , basically the same intution as the above approach..
    // will need to call this method in all the componenets of the graph..
    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<myPair> q = new LinkedList<myPair>();
        q.add(new myPair(-1, src));
        visited[src] = true;
        while (q.isEmpty() == false) {
            int currentNode = q.peek().y;
            int currentParent = q.poll().x;
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int a : currentList) {
                if (visited[a] == false) {
                    q.add(new myPair(currentNode, a));
                    visited[a] = true;
                } else if (a != currentParent) {
                    return true;
                }
            }
        }
        return false;
    }

    // using dfs
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int parent){
        if(visited[src] == true){
            return true;
        }
        visited[src] = true;
        ArrayList<Integer> current = adj.get(src);
        for(int i : current){
            if(i != parent){
                boolean smallAns = dfs(adj,i,src);
                if(smallAns){return true;}
            }
        }
        return false;
    }

}
