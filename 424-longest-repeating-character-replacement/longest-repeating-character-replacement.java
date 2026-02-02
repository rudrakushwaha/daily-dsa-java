class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0, r = 0, maxf = 0, maxLen = 0;
        int n = s.length();
        int[] map = new int[26];

        while(r < n){

            map[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, map[s.charAt(r) - 'A']);

            while( (r - l + 1) - maxf > k){

                map[s.charAt(l) - 'A']--;
                l++;
            }

            if ( (r - l + 1) - maxf <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
        
    }
}