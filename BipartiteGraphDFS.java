package StiverGraphs;

import java.util.*;

public class BipartiteGraphDFS {

    public static void main(String args[]) {
        int matrix[][] = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
                // { 1, 3 },
                // { 0, 2 },
                // { 1, 3 },
                // { 0, 2 }
        };
        System.out.print(util1(matrix));
    }

    static int colorArray[];

    // color1 == 1, color2 == 2
    public static boolean dfs(int matrix[][], int vertex, int col) {
        colorArray[vertex] = col;
        int connectedNodes[] = matrix[vertex];
        for(int i:connectedNodes){
            if(colorArray[i] == 0){
                if(col == 1){
                    boolean smallAns = dfs(matrix,i,2);
                    if(smallAns == false){return false;}
                }else{
                    boolean smallAns = dfs(matrix,i,1);
                    if(smallAns == false){return false;}
                }
            }else if(colorArray[i] == col){
                return false;
            }
        }
        return true;
    }

    public static boolean util1(int matrix[][]) {
        colorArray = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (colorArray[i] == 0) {
                boolean smallAns = dfs(matrix, i, 1);
                if (smallAns == false) {
                    return false;
                }
            }
        }
        return true;
    }

}
