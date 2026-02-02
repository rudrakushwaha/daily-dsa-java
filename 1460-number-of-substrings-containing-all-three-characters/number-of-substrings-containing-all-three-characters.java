class Solution {
    public int numberOfSubstrings(String s) {


        //============APP 3================
        int count = 0;
        int n = s.length();

        int[] map = {-1,-1,-1};

        for( int i = 0 ; i< n ; i++){

            map[s.charAt(i) - 'a'] = i;

            if( map[0] != -1 && map[1] != -1 && map[2] != -1){
                count = count + (1 + Math.min( map[0], Math.min(map[1], map[2]) ));
            }

        }

        return count;
        //==============APP 2===================
        // int count =0;
        // int n = s.length();

        // for (int i = 0 ; i< s.length() ; i++){

		// 	int[] hashmap = new int[3];

		// 	for (int j = i ; j < s.length() ; j++)
		// 	{

		// 		hashmap[s.charAt(j) - 'a'] = 1;

        //         if(hashmap[0] + hashmap[1] + hashmap[2] == 3) {
        //              count++;
        //             // for optimal soln
        //             // count = count + (n - j);
        //             // break;
        //         }
		// 	}
		// }
        // return count;

        //====================APP 1==================
        // int count =0;

        // for (int i = 0 ; i< s.length() ; i++){

		// 	HashMap<Character, Integer> map = new HashMap<>();

		// 	for (int j = i ; j < s.length() ; j++)
		// 	{

		// 		map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0) + 1);

        //         if( map.size() == 3) {
        //             count++;
        //         }
		// 	}
		// }
        // return count;
    }
}