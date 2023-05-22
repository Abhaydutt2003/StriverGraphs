package StiverGraphs;

public class FindTheCityWithSmallest {

    public static void main(String args[]) {
        int mat[][] = {
                { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 }
        };
        int n = 4;
        int thres = 4;
        int ans = util1(n, mat, thres);
        System.out.print(ans);
    }

    public static int util1(int n, int[][] edges, int distanceThreshold) {
        int matrix[][] = getMat(n, edges, distanceThreshold);

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
                }
            }
        }
        int ans = 0;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int candidate = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    candidate++;
                }
            }
            if (candidate <= smallest) {
                ans = i;
                smallest = candidate;
            }
        }

        return ans;
    }

    public static int[][] getMat(int n, int edges[][], int distanceThreshold) {
        int matrix[][] = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = (int) (1e9);
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        return matrix;
    }

}
