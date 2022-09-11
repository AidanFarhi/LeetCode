import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * 
 * Given a string s which consists of lowercase or uppercase letters, 
 * return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
class Solution {
    public int optimalSolution(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    public int mySolution(String s) {
        
        // create a HashMap of counts
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        
        // find the character with the largest odd count
        int maxOddNumber = -1;
        char maxOddChar = ' ';
        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            if (e.getValue() % 2 != 0 && e.getValue() > maxOddNumber) {
                maxOddNumber = e.getValue();
                maxOddChar = e.getKey();
            }
        }
        
        // start counting
        int length = 0;
        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            if (e.getValue() % 2 != 0) {
                if (e.getKey() == maxOddChar) {
                    length += e.getValue();
                } else if (e.getValue() > 1) {
                    length += e.getValue() - 1;
                }
            } else {
                length += e.getValue();
            }
        }
        
        return length;
    }
}
