package StiverGraphs;

import java.util.*;

class DijkstraHelper {
    int weight;
    int node;

    DijkstraHelper(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}

class DHComparator implements Comparator<DijkstraHelper> {

    public int compare(DijkstraHelper d1, DijkstraHelper d2) {
        if (d1.weight < d2.weight) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class DijkstraAlgo {

    public static void main(String args[]) {

    }

    public static int[] util1(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source) {
        PriorityQueue<DijkstraHelper> pq = new PriorityQueue<>(new DHComparator());
        int distance[] = new int[V];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        pq.add(new DijkstraHelper(0, source));
        while (pq.isEmpty() == false) {
            DijkstraHelper dh = pq.poll();
            int currentWeight = dh.weight;
            int currentNode = dh.node;
            ArrayList<ArrayList<Integer>> currentList = adj.get(currentNode);
            for (ArrayList<Integer> al : currentList) {
                int node = al.get(0);
                int nodeWeight = al.get(1);
                if (currentWeight + nodeWeight < distance[node]) {
                    distance[node] = currentWeight + nodeWeight;
                    pq.add(new DijkstraHelper(distance[node], node));
                }
            }
        }
        return distance;
    }
}
