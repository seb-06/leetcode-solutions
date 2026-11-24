class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len2 = s2.length();
        int len1 = s1.length();
        if (len1 > len2) {
            return false;
        }
        int[] permutations = new int[26];
        int[] win = new int[26];

        for (char c : s1.toCharArray()) {
            permutations[c - 'a']++;
        }
        for (int j=0; j < len1; j++) {
            win[s2.charAt(j) - 'a']++;
        }

        for (int i=len1; i<len2; i++) {
            if (Arrays.equals(permutations, win)) {
                return true;
            }
            win[s2.charAt(i) - 'a']++;
            win[s2.charAt(i - len1) - 'a']--;
        }

        if (Arrays.equals(permutations, win)) {
            return true;
        }
        return false;
    }
}
