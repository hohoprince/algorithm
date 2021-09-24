class Solution {
    
     public boolean isRight(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        return true;
    }

    public int getBalancedIndex(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }

        return -1;
    }

    public String process(String s) {
        if (s.equals("")) return "";

        int index = getBalancedIndex(s);
        String u = s.substring(0, index + 1);
        String v = s.substring(index + 1);

        if (isRight(u)) {
            return u + process(v);
        } else {
            String result = "(" + process(v) + ")";

            String tmp = u.substring(1, u.length() - 1);
            StringBuilder newU = new StringBuilder();
            for (char c : tmp.toCharArray()) {
                if (c == '(') {
                    newU.append(')');
                } else if (c == ')') {
                    newU.append('(');
                }
            }

            return result + newU;

        }
    }
    
    public String solution(String p) {
        return process(p);
    }
}
    


