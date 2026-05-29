class Solution {
    public int numberOfSpecialChars(String word) {


        //last lowercase index < first uppercase index
        
        int [] lower = new int[26];
        int [] upper = new int[26];

        Arrays.fill(lower,-1);
        Arrays.fill(upper,-1);

        for(int i = 0 ; i < word.length() ; i++){

            char ch = word.charAt(i);

            //if character is lower -- everytime update the index to get the last lower index
            if(Character.isLowerCase(ch)){
                    lower[ch - 'a'] = i;
            } else {

                //if it a uppercase store only the first occurence
                int index = ch - 'A';

                if(upper[index] == -1){
                    upper[index] = i;
                }

            }
        }

        int count = 0 ; 

        for(int i = 0 ; i < 26 ; i++){

            if(lower[i] != -1 &&
                upper[i] != -1 &&
                lower[i] < upper[i]){
                    count++;
                }
        }

        return count;
    }
}