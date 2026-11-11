class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        backtrack(0,nums,new ArrayList<>(),set);
        return new ArrayList<>(set);
    }
    void backtrack(int start,int[] nums,List <Integer>current,Set<List<Integer>>set){
        set.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(i+1,nums,current,set);
            current.remove(current.size()-1);
        }
    }
}
