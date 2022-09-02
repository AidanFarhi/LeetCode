import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character 
 * while preserving the order of characters. No two characters may map to the same character, 
 * but a character may map to itself.
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        var sMap = new HashMap<Character, Character>();
        var tMap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            Character sLookup = sMap.getOrDefault(sChar, null);
            Character tLookup = tMap.getOrDefault(tChar, null);
            if (sLookup != null) {
                if (!sLookup.equals(tChar)) return false;
            } else {
                sMap.put(sChar, tChar);
            }
            if (tLookup != null) {
                if (!tLookup.equals(sChar)) return false;
            } else {
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }
}