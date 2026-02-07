class Solution {
    public String minWindow(String s, String t) {

        //=============APPROACH 2 ===============

        int minLen = Integer.MAX_VALUE;
        int l = 0 , r = 0 ;
        int n = s.length();
        int m = t.length();
        int count = 0;
        int sIndex = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for( char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
        }

        while( r < n){

            char ch = s.charAt(r);
        
            if( map.containsKey(ch)) {
                if( map.get(ch) > 0 ) count += 1;

                 map.put(ch, map.getOrDefault(ch, 0) - 1);
            }

            while( count == m){

                if( r - l + 1 < minLen){
                    minLen = r - l + 1;
                    sIndex = l;
                }

                char leftChar = s.charAt(l);

                if( map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);


                    if( map.get(leftChar) > 0) count -= 1;
                }

                l++;

            }
            r = r + 1;
        }
         return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);


        //===========APPROACH  1=============
        // int minLen = Integer.MAX_VALUE;
        // int startIndex = -1;

        // for (int i = 0; i < s.length(); i++) {

        //     HashMap<Character, Integer> map = new HashMap<>();
        //     for (char ch : t.toCharArray()) {
        //         map.put(ch, map.getOrDefault(ch, 0) + 1);
        //     }

        //     int required = t.length();

        //     for (int j = i; j < s.length(); j++) {

        //         char ch = s.charAt(j);

        //         if (map.containsKey(ch)) {
        //             if (map.get(ch) > 0)
        //             { required--;
        //             map.put(ch, map.get(ch) - 1);
        //             }
        //         }

        //         if (required == 0) {
        //             if (j - i + 1 < minLen) {
        //                 minLen = j - i + 1;
        //                 startIndex = i;
        //             }
        //             break; // smallest window starting at i
        //         }
        //     }
        // }

        // return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
