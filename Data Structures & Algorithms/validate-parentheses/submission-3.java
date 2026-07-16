class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack= new Stack<>();
        HashMap<Character,Character>map=new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i=0;i<s.length();i++){
            char current=s.charAt(i);
            if(current=='('||current =='{'||current=='['){
                stack.push(current);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != map.get(current)){
                   return false; 
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
