class Solution {
    public String minWindow(String s, String t) {
        // Brute force: iterate through every substring and check it with t. O (n^2)
        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) {
            return "";
        }

        int[] goal = new int[58];
        int[] win = new int[58];
        
        for (char c : t.toCharArray()) {
            goal[c - 'A']++;
        }

        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;

        int left = 0;
        int need = len2;
        int have = 0;

        for (int right=0;right<len1;right++) {
            int rightIdx = s.charAt(right) - 'A';
            win[rightIdx] ++;
            if (goal[rightIdx] > 0 && win[rightIdx] <= goal[rightIdx]) {
                have++;
            }
            while (have == need) {
                if (right - left + 1 < bestLen) {
                    bestStart = left;
                    bestLen = right - left + 1;
                }

                int leftIdx = s.charAt(left) - 'A';
                win[leftIdx]--;
                if (goal[leftIdx] > 0 && win[leftIdx] < goal[leftIdx]) {have--;}
                left++;
            }

        }
        if (bestLen == Integer.MAX_VALUE) {
            return "";
        }
        else {
            return s.substring(bestStart, bestStart + bestLen);
        }
    }   
}
