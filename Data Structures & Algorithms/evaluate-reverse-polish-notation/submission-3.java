class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack = new Stack<>();
        for (String token:tokens){
            if (token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int right= stack.pop();
                int left=stack.pop();

            
                switch(token){
                    case"+":
                        stack.push(left+right);
                        break;
                    case"-":
                        stack.push(left-right);
                        break;
                    case"*":
                        stack.push(left*right);
                        break;
                    case"/":
                        stack.push(left/right);
                        break;
                
                }
                }else{
                    stack.push(Integer.parseInt(token));
                }
        }
    return stack.peek();
      }  }

