class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Parenthes> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new Parenthes(c, i));
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    stack.push(new Parenthes(c, i));
                    continue;
                }
                
                Parenthes p = stack.peek();
                
                if (p.parenthes == '(') {
                    stack.pop();
                } else {
                    stack.push(new Parenthes(c, i));
                }
            }
            
        }
        
        StringBuilder sb = new StringBuilder(s);
        
        while (!stack.isEmpty()) {
            Parenthes p = stack.pop();
            sb.deleteCharAt(p.index);
        }
        
        return sb.toString();
    }
    
    class Parenthes {
        char parenthes;
        int index;
        
        public Parenthes(char parenthes, int index) {
            this.parenthes = parenthes;
            this.index = index;
        }
        
    }
}
