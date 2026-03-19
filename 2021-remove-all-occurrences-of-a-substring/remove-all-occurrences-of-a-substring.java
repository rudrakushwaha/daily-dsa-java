class Solution {
    public String removeOccurrences(String s, String part) {


        //optimnal approach using stringbuilder:
        StringBuilder sb = new StringBuilder();
        int k = part.length();

        for( char ch: s.toCharArray()){

            sb.append(ch);

            if(sb.length() >= k){
                //last characters of sb if matching with the part, then we can delete that 
                if(sb.substring(sb.length() - k).equals(part)){
                    sb.delete(sb.length() - k, sb.length());
                }
            }
        }
        return sb.toString();


        // int partLen = part.length();
        // int n = 0;

        // while(true){

        //     n = s.length();
        //     int index = findOccurence(s , part , n, partLen);

        //     if(index == -1) break;

        //     s = s.substring(0, index) + s.substring(index + partLen , n);

        // }

        // return s;
    }

    // int findOccurence(String s, String part, int n , int partlen){

    //     for( int i = 0 ; i <= n - partlen ; i++){

    //         if( s.substring(i, i + partlen).equals(part))
    //         return i;
    //     }

    //     return -1;
    // }
}