class Solution {
    public String removeOccurrences(String s, String part) {

        int partLen = part.length();
        int n = 0;

        while(true){

            n = s.length();
            int index = findOccurence(s , part , n, partLen);

            if(index == -1) break;

            // if ( (index + partLen) == n) {

            //     s = s.substring(0, index);
            //     break;

            // } 
            s = s.substring(0, index) + s.substring(index + partLen , n);

        }

        return s;
    }

    int findOccurence(String s, String part, int n , int partlen){

        for( int i = 0 ; i <= n - partlen ; i++){

            if( s.substring(i, i + partlen).equals(part))
            return i;
        }

        return -1;
    }
}