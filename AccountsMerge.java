package StiverGraphs;

import java.util.*;

public class AccountsMerge {

    public static void main(String args[]) {
        
    }

    public static List<List<String>> util1(List<List<String>> accounts) {
        // firstly creating the disjoint set
        HashMap<String, Integer> hm = new HashMap<>();
        DisjointSet2 ds = new DisjointSet2(accounts.size());

        for (int i = 0; i < accounts.size(); i++) {
            List<String> current = accounts.get(i);
            for (int j = 1; j < current.size(); j++) {
                if (hm.containsKey(current.get(j)) == true) {
                    ds.unionBySize(i, hm.get(current.get(j)));
                } else {
                    hm.put(current.get(j), i);
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[accounts.size()];
        for (int i = 0; i < mergedMail.length; i++) {
            mergedMail[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String mail = entry.getKey();
            int mailParent = ds.ultimateParent(entry.getValue());
            mergedMail[mailParent].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < mergedMail.length; i++) {
            if (mergedMail[i].size() == 0) {
                continue;
            }
            Collections.sort(mergedMail[i]);
            List<String> toAdd = new ArrayList<>();
            toAdd.add(accounts.get(i).get(0));
            for (String str : mergedMail[i]) {
                toAdd.add(str);
            }
            ans.add(toAdd);
        }
        return ans;
    }

}
