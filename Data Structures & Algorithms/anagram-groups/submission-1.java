class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String word:strs){
            char[]arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!map.containsKey(key)){
              ArrayList<String> keys= new ArrayList<>();
                 map.put(key,keys);
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
