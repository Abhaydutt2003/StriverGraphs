package StiverGraphs;

import java.util.*;

public class AlienDictionary {

    public static void main(String args[]) {
        String dict[] = {"baa","abcd","abca","cab","cad"}; 
        int n = 5,k=4;
        System.out.print(util1(dict,n,k));
    }

    public static String util1(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = getAdj(dict, K);
        constIndegree(adj, K);
        List<Integer> ans = modifiedBfs(adj, K);
        String a = "";
        for (int i : ans) {
            char z = (char) (97 + i);
            a += z;
        }
        return a;
    }

    static int indegree[];

    private static ArrayList<ArrayList<Integer>> getAdj(String[] dict, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int toGet1 = ((int) (s1.charAt(j))) - 97;
                    int toPut = ((int) (s2.charAt(j))) - 97;
                    adj.get(toGet1).add(toPut);
                    break;
                }
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

    private static List<Integer> modifiedBfs(ArrayList<ArrayList<Integer>> adj, int K) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<Integer>();
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            topo.add(currentNode);
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return topo;
    }

}
