package StiverGraphs;

public class MakeNetworkConnected {

    public static void main(String args[]) {
        int matrix[][] = {
                // {0,1},
                // {0,2},
                // {1,2}
                // // {0,1},
                // // {0,2},
                // // {0,3},
                // // {1,2},
                // // {1,3}
                { 1, 5 }, { 1, 7 }, { 1, 2 }, { 1, 4 }, { 3, 7 }, { 4, 7 }, { 3, 5 }, { 0, 6 }, { 0, 1 }, { 0, 4 },
                { 2, 6 }, { 0, 3 }, { 0, 2 }
        };
        int n = 12;
        System.out.print(util1(n, matrix));
    }

    // number of
    // edges required
    // to make
    // n components
    // conncted is n-1...

    public static int util1(int n, int matrix[][]) {
        DisjointSet2 ds = new DisjointSet2(n);
        int extraEdges = 0;
        for (int i = 0; i < matrix.length; i++) {
            int nodeA = matrix[i][0];
            int nodeB = matrix[i][1];
            if (ds.ultimateParent(nodeB) != ds.ultimateParent(nodeA)) {
                ds.unionBySize(nodeA, nodeB);
            } else {
                extraEdges++;
            }
        }
        int numberComp = 0;
        int arr[] = ds.parent;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                numberComp++;
            }
        }
        if (extraEdges >= (numberComp - 1)) {
            return numberComp - 1;
        }
        return -1;
    }
}
