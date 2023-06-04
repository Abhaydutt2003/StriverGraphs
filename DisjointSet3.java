package StiverGraphs;

public class DisjointSet3 {

    int size[];
    int parent[];

    public DisjointSet3(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
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
        int sizeu = size[ultimateParentu];
        int sizev = size[ultimateParentv];
        if (sizeu > sizev) {
            parent[ultimateParentv] = ultimateParentu;
            size[ultimateParentu] = sizeu + sizev;
        } else if (sizev > sizeu) {
            parent[ultimateParentu] = ultimateParentv;
            size[ultimateParentv] = sizeu + sizev;
        } else {
            parent[ultimateParentv] = ultimateParentu;
            size[ultimateParentu] = sizeu + sizev;

        }
    }
}
