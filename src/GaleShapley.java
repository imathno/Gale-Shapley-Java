import java.util.*;

public class GaleShapley {

    static class Pair {
        Object a;
        Object b;

        public Pair(Object a, Object b) {
            this.a = a;
            this.b = b;
        }
    }

    /**
     * This is the main Gale Shapley function implementation with a time complexity of O(n^2)
     * @param M this is the list of group1 and their preferences
     * @param W this is the list of group2 and their preferences
     * @return a list of couples
     */
    public static List<Pair> getMatches(String[][] M, String[][] W) {
        // Initially all m in M and w in W are set free
        Map<String, Integer> indexTracker = new HashMap<>();
        Map<String, String> matches = new HashMap<>();
        Deque<String> mToMatch = new LinkedList<>();

        for (int i = 0; i < M.length; i++) {
            mToMatch.addLast(M[i][0]);
            indexTracker.put(M[i][0], i);
            indexTracker.put(W[i][0], i);
        }

        // While there is an m that is free
        while (!mToMatch.isEmpty()) {
            // Choose next m
            String person = mToMatch.peek();

            int nextMatchIndex = getNextMatch(M, indexTracker.get(person));
            String potentialMatch = M[indexTracker.get(person)][nextMatchIndex];

            M[indexTracker.get(person)][nextMatchIndex] = "";

            // If w is free
            if (!matches.containsKey(potentialMatch)) {
                // (m, w) becomes engaged
                matches.put(potentialMatch, person);
                mToMatch.pop();
            // Else w is engaged to m' but prefers m to m'
            } else if (prefers(W, indexTracker.get(potentialMatch), person, matches.get(potentialMatch))) {
                mToMatch.pop();
                mToMatch.add(matches.get(potentialMatch));
                matches.put(potentialMatch, person);
            }
        }

        List<Pair> ret = new ArrayList<>();
        for (String p : matches.keySet()) {
            ret.add(new Pair(matches.get(p), p));
        }

        return ret;
   }

   public static int getNextMatch(String[][] p, int index) {
        for (int i = 1; i < p[0].length; i++) {
            if (!p[index][i].equals("")) {
                return i;
            }
        }
        return -1;
   }

   private static boolean prefers(String[][] w, int wIndex, String a, String b) {
       for (int i = 1; i < w[0].length; i++) {
           if (w[wIndex][i].equals(a)) {
               return true;
           } else if (w[wIndex][i].equals(b)) {
               return false;
           }
       }
        return false;
   }
}
