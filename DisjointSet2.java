package StiverGraphs;

public class DisjointSet2 {

    int size[];
    int parent[];

    public DisjointSet2(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            size[i] = 0;
            parent[i] = i;
        }
    }

    public int ultimateParent(int node) {
        if (parent[node] == node) {
            return parent[node];
        }
        int up = ultimateParent(parent[node]);
        parent[node] = up;
        return up;
    }

    public void unionBySize(int u, int v) {
        int ultimateParentu = ultimateParent(u);
        int ultimateParentv = ultimateParent(v);
        if (size[ultimateParentu] > size[ultimateParentv]) {
            parent[ultimateParentv] = ultimateParentu;
            size[ultimateParentu]++;
        } else if (size[ultimateParentu] < size[ultimateParentv]) {
            parent[ultimateParentu] = ultimateParentv;
            size[ultimateParentv]++;
        } else {
            parent[ultimateParentu] = ultimateParentv;
            size[ultimateParentv]++;
        }
    }
}
