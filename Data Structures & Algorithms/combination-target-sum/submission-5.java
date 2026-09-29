class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        backtrack(nums,0,target,current,result);
        return result;
    }

private void backtrack(int[]nums,int index,int remainingTarget,List<Integer>current,List<List<Integer>>result){
    if(remainingTarget == 0){
        result.add(new ArrayList<>(current));
        return;
    }
    if(remainingTarget < 0 || index==nums.length){
        return;
    }
    current.add(nums[index]);
    backtrack(nums,index,remainingTarget-nums[index],current,result);
    current.remove(current.size()-1);
    backtrack(nums,index+1,remainingTarget,current,result);
}}
