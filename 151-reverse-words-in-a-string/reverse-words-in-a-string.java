class Solution {
    public String reverseWords(String s) {
        
        String[] wordArr = s.split("\\s+");
        String newString = "";

        for(int i = wordArr.length - 1 ; i >= 0 ; i--){
            newString = newString + " " + wordArr[i];
    }

    return newString.trim();
}
}