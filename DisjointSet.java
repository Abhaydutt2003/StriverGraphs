package StiverGraphs;

public class DisjointSet {

    int[] rank;
    int[] parent;

    public DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int findUltimateParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        int ultimateParent = findUltimateParent(parent[node]);
        parent[node] = ultimateParent;
        return parent[node];
    }

    public void unionByRank(int u, int v) {
        int ultimateParentu = findUltimateParent(u);
        int ultimateParentv = findUltimateParent(v);
        if (rank[ultimateParentu] > rank[ultimateParentv]) {
            parent[ultimateParentv] = ultimateParentu;
        } else if (rank[ultimateParentv] > rank[ultimateParentu]) {
            parent[ultimateParentu] = ultimateParentv;
        } else {
            parent[ultimateParentu] = ultimateParentv;
            int r = rank[ultimateParentv];
            rank[ultimateParentv] = r + 1;
        }
    }
    
}
