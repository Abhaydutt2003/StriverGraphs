package StiverGraphs;

public class DisjointSetUse {

    public static void main(String args[]) {
//         DisjointSet ds = new DisjointSet(7);
//         ds.unionByRank(1, 2);
//         ds.unionByRank(2, 3);
//         ds.unionByRank(4, 5);
//         ds.unionByRank(6, 7);
//         ds.unionByRank(5, 6);
//         boolean a = (ds.findUltimateParent(6) == ds.findUltimateParent(7));
//         System.out.print(a);
        DisjointSet2 ds = new DisjointSet2(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        boolean a = (ds.ultimateParent(3) == ds.ultimateParent(7));
        System.out.print(a);
    }

}
