package StiverGraphs;

public class NumberOfEnclaves {

    public static void main(String args[]){
        
    }

    static boolean visited[][];
    public static int util1(int[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        // traversing the left boundry
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1 && visited[i][0] == false) {
                dfs(matrix, i, 0);
            }
        }
        // traversing for the bottom boundry
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[matrix.length - 1][j] == 1 && visited[matrix.length - 1][j] == false) {
                dfs(matrix, matrix.length - 1, j);
            }
        }
        // traversing for the right boundry
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] == 1 && visited[i][matrix[0].length - 1] == false) {
                dfs(matrix, i, matrix[0].length - 1);
            }
        }
        // traversing top boundry
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 1 && visited[0][j] == false) {
                dfs(matrix, 0, j);
            }
        }

        int ans = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(visited[i][j] == false && matrix[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }


    static int xdir[] = { 0, 0, 1, -1 };
    static int ydir[] = { 1, -1, 0, 0 };

    private static void dfs(int matrix[][], int i , int j){
        if(visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        for (int a = 0; a < xdir.length; a++) {
            int x = xdir[a] + i;
            int y = ydir[a] + j;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 1) {
                dfs(matrix, x, y);
            }
        }
    }
    
}
