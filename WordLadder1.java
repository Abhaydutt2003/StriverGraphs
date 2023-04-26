package StiverGraphs;

import java.util.*;

class LadderHelper {
    String str;
    int steps;

    LadderHelper(String str, int steps) {
        this.str = str;
        this.steps = steps;
    }
}

public class WordLadder1 {

    public static void main(String agrs[]) {
        String beginWord = "ymain";
        String endWord = "oecij";
        List<String> words = new ArrayList<>();
        words.add("ymann");
        words.add("yycrj");
        words.add("oecij");
        words.add("ymcnj");
        words.add("yzcrj");
        words.add("yycij");
        words.add("xecij");
        words.add("yecij");
        words.add("ymanj");
        words.add("yzcnj");
        words.add("ymain");
        System.out.println(util1(beginWord, endWord, words));
    }

    public static int util1(String begin, String end, List<String> words) {
        HashSet<String> hs = new HashSet<>();
        for (String s : words) {
            hs.add(s);
        }
        Queue<LadderHelper> q = new LinkedList<>();
        q.add(new LadderHelper(begin, 1));
        while (q.isEmpty() == false) {
            LadderHelper current = q.poll();
            String currentString = current.str;
            int currentStep = current.steps;

            if (currentString.compareTo(end) == 0) {
                return currentStep;
            }

            char charArray[] = currentString.toCharArray();

            for (int i = 0; i < currentString.length(); i++) {

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    int currentIndexToReplace = i;
                    char temp = charArray[currentIndexToReplace];
                    charArray[currentIndexToReplace] = ch;
                    String replacedString = new String(charArray);
                    if (hs.contains(replacedString)) {
                        hs.remove(replacedString);
                        q.add(new LadderHelper(replacedString, currentStep + 1));
                    }
                    charArray[currentIndexToReplace] = temp;
                }
            }
        }
        return 0;
    }

}
