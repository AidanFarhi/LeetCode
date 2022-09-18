import java.util.HashSet;

/**
 * 202. Happy Number
 * 
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * 
 * REMEMBER:
 * A given value can never go beyond 3 digits. Any number with more than 3
 * digits will always lose a digit at each step until it is back to 3 digits.
 * ex) 999 -> 9^2 + 9^2 + 9^2 -> 243
 * This means you don't have to account for infinitely growing numbers.
 */
class Solution {
    /**
     * Time: O(log n) | Space: O(1)
     */
    public boolean mySolution(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1) {
            int current = 0;
            String chars = String.valueOf(n);
            for (char ch : chars.toCharArray()) {
                current += Math.pow(Character.getNumericValue(ch), 2);
            }
            if (seen.contains(current)) return false;
            seen.add(current);
            n = current;
        }
        return true;
    }

    public boolean floydsCycleFindingAlgorithm() {
        return true;
    }
}
