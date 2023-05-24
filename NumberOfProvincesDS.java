package StiverGraphs;

public class NumberOfProvincesDS {

    public static void main(String args[]) {

    }

    // for this question in disjoint set implementation,instead of taking
    // parent array of size n+1, we will take it of size n.

    public static int util1(int[][] matrix) {
        DisjointSet2 ds = new DisjointSet2(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }
        int arr[] = ds.parent;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    public static int util2(int[][] matrix) {
        DisjointSet2 ds = new DisjointSet2(matrix.length);
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1 && (ds.ultimateParent(i) != ds.ultimateParent(j))) {
                    ds.unionBySize(i, j);
                    visited[i] = true;
                    visited[j] = true;
                }
            }
        }
        int arr[] = ds.parent;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                ans++;
            }
        }
        return ans;
    }

}
