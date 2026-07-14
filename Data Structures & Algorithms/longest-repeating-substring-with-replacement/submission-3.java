class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxlength=0;
        int maxFreq=0;
        int []freqofchar=new int[26];
        for (int right =0;right<s.length();right++){
            char current=s.charAt(right);
            freqofchar[current-'A']++;//a to subtract the ascii val of char 
            maxFreq=Math.max(maxFreq,freqofchar[current-'A']);
            while((right-left+1)-maxFreq>k){
                freqofchar[s.charAt(left)-'A']--;

                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);

        }   return maxlength;}

}
