package StiverGraphs;

public class DisjointSetUse {

    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        boolean a = (ds.findUltimateParent(6) == ds.findUltimateParent(7));
        System.out.print(a);
    }

}
