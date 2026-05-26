class Solution {
    public int numberOfSpecialChars(String word) {

        int count = 0 ;
        int[] freqArrLower = new int[26];
        int[] freqArrUpper = new int[26];

        
        for(char ch: word.toCharArray()){

            if(Character.isLowerCase(ch)){
                freqArrLower[ch-'a']++;
            }
            else if(Character.isUpperCase(ch)){
                 freqArrUpper[ch-'A']++;
            }
        }

        for(int i = 0; i < freqArrLower.length ; i++){

            if( freqArrLower[i] != 0 && freqArrUpper[i] != 0)
                count++;
        }

        return count;
        
    }
}