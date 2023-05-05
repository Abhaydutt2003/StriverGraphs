package StiverGraphs;

import java.util.*;

public class WordLadder2 {

    public static void main(String args[]) {

    }

    public static List<List<String>> util1(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for (String a : wordList) {
            hs.add(a);
        }

        Queue<List<String>> q = new LinkedList<>();

        List<String> firstList = new ArrayList<>();
        firstList.add(beginWord);
        q.add(firstList);

        List<String> used = new ArrayList<>();
        used.add(beginWord);

        List<List<String>> ans = new ArrayList<>();

        int level = 1;
        while (q.isEmpty() == false) {
            List<String> currentList = q.poll();

            if (currentList.size() > level) {
                for (String i : used) {
                    hs.remove(i);
                }
                level++;
            }

            if (currentList.get(currentList.size() - 1).compareTo(endWord) == 0) {
                if (ans.size() == 0) {
                    ans.add(currentList);
                } else if (currentList.size() == ans.get(0).size()) {
                    ans.add(currentList);
                }
            }

            String word = currentList.get(currentList.size() - 1);
            char charArray[] = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    int currentIndexToReplace = i;
                    char temp = charArray[currentIndexToReplace];
                    charArray[currentIndexToReplace] = ch;
                    String replacedString = new String(charArray);
                    if (hs.contains(replacedString)) {
                        currentList.add(replacedString);
                        q.add(new ArrayList<>(currentList));
                        used.add(replacedString);
                        currentList.remove(currentList.size() - 1);
                    }
                    charArray[currentIndexToReplace] = temp;
                }
            }
        }
        return ans;
    }

}
