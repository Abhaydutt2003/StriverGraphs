package StiverGraphs;

public class SurroundedRegions {

    public static void main(String args[]) {
        char matrix[][] = {
            {'X','O','X','X'},
            {'X','O','X','X'},
            {'X','O','O','X'},
            {'X','O','X','X'},
            {'O','X','O','X'},
            {'O','X','O','X'},
            {'O','X','X','O'}
        };
        util1(matrix);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }System.out.println();
        }
    }

    static boolean visited[][];

    public static void util1(char[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        // traversing the left boundry
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 'O' && visited[i][0] == false) {
                dfs(matrix, i, 0);
            }
        }
        // traversing for the bottom boundry
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[matrix.length - 1][j] == 'O' && visited[matrix.length - 1][j] == false) {
                dfs(matrix, matrix.length - 1, j);
            }
        }
        // traversing for the right boundry
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] == 'O' && visited[i][matrix[0].length - 1] == false) {
                dfs(matrix, i, matrix[0].length - 1);
            }
        }
        // traversing top boundry
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 'O' && visited[0][j] == false) {
                dfs(matrix, 0, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'O' && visited[i][j] == false) {
                    matrix[i][j] = 'X';
                }
            }
        }
    }

    static int xdir[] = { 0, 0, 1, -1 };
    static int ydir[] = { 1, -1, 0, 0 };

    private static void dfs(char matrix[][], int i, int j) {
        if (visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        for (int a = 0; a < xdir.length; a++) {
            int x = xdir[a] + i;
            int y = ydir[a] + j;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 'O') {
                dfs(matrix, x, y);
            }
        }
    }

}
