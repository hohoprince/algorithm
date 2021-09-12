class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty()) return false;
                char poped = stack.pop();
                if (map.get(c) != poped) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
