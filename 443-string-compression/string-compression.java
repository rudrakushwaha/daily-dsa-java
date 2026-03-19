class Solution {
    public int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();

       char currentChar = chars[0];
       int count = 1;
       sb.append(currentChar);


       for(int i = 1 ; i < chars.length ; i++){

        if( chars[i] == chars[i - 1]) {   
            count++;
        } else {   //character changed

            if(count != 1){
                sb.append(count);
                count = 1;
               
            } 

            currentChar = chars[i];
            sb.append(currentChar);
        }
       }

       //appending the last value of count
        if( count != 1) sb.append(count);


        //updating the input array
       for( int i = 0 ; i< sb.length() ; i++){
        chars[i] = sb.charAt(i);
       }
        

        
        
        return sb.length();
    }
}