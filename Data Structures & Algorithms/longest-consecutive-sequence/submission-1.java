class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set =new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int longest=0;
        
        for (int num:set){
            int current=num;
            int length=1;
            if (set.contains(num-1)){
                continue;
            }
            while (set.contains(current+1)){
            current++;
            length++;
            }
        
        longest=Math.max(longest,length);}

        return longest;
    }
}
