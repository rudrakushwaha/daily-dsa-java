class Solution {
    public String reverseWords(String s) {
        
        // ====================USING STRING BUILDER=================
        StringBuilder res = new StringBuilder();
        String[] wordArr = s.trim().split("\\s+");

        for(int i = wordArr.length - 1 ; i >=0 ;i--){

            res.append(wordArr[i]);
            if(i != 0) res.append(" ");
        }

        return res.toString();

    // ========== NORMAL WAY================
    //     String[] wordArr = s.split("\\s+");
    //     String newString = "";

    //     for(int i = wordArr.length - 1 ; i >= 0 ; i--){
    //         newString = newString + " " + wordArr[i];
    // }

    // return newString.trim();
}
}