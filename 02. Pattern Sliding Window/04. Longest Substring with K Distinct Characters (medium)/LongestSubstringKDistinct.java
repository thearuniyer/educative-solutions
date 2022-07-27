import java.util.HashMap;
import java.util.HashSet;

import jdk.jfr.Frequency;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if(str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        } 
        int windowStart = 0, maxLength = 0, curLength = 0;

        HashMap<Character, Integer> charFrequency = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            charFrequency.put(str.charAt(windowEnd), charFrequency.getOrDefault(str.charAt(windowEnd), 0) + 1);
            while(charFrequency.size() > k) {
                charFrequency.put(str.charAt(windowStart), charFrequency.get(str.charAt(windowStart)) - 1);
                if(charFrequency.get(str.charAt(windowStart)) == 0) {
                    charFrequency.remove(str.charAt(windowStart));
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        System.out.println(findLength(str, k));
    }
}