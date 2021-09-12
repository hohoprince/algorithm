class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            if (c == ']') {
                while (true) {
                    char peeked = stack.peek();
                    if (Character.isDigit(peeked)) {
                        break;
                    }
                    char poped = stack.pop();
                    if (poped != '[') {
                        sb.append(poped);
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    char charNumber = stack.pop();
                    sb3.append(charNumber);
                }
                
                int number = Integer.parseInt(sb3.reverse().toString());
                System.out.println(number);
                for (int i = 0; i < number; i++) {
                    sb2.insert(0, sb);
                }
                for (char p : sb2.reverse().toString().toCharArray()) {
                    stack.push(p);
                }
            } else {
                stack.push(c);
            }
            
        }
        
        char answer[] = new char[stack.size()];
        for (int i = stack.size() - 1; i >=0; i--) {
            answer[i] = stack.pop();
        }
        
        return new String(answer);
    
    }
}
