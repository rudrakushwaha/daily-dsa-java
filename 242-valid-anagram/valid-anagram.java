class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character , Integer> map = new HashMap<>();


        ////////////////////==============using frequency map==
        int[] freq = new int[26];

        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(char ch: t.toCharArray()){
            freq[ch - 'a']--;
        }

        for(int n: freq){
            if( n != 0) return false;
        }

        return true;
        ///////using hashmap 
        // for(char ch: s.toCharArray()){
        //     map.put(ch, map.getOrDefault(ch, 0 ) + 1);
        // }


        // for(char ch: t.toCharArray()){

        //      if (!map.containsKey(ch)) return false;
        //     map.put(ch, map.get(ch) - 1);

        //     if(map.get(ch) == 0)
        //     map.remove(ch);

            
        // }

        // return map.isEmpty();



    }
}
           