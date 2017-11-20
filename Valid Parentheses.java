public class Solution {
    /*
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char cur : s.toCharArray()) {
            if (cur == '(') {
                stack.push(')');
            } else if (cur == '{') {
                stack.push('}');
            } else if (cur == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != cur) {
                // (] , )
                return false;
            }
        }
        // ()(
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

// Review 11/19
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                // 空的遇到右括號 --> 一定return false
                if (stack.isEmpty() ||
                    s.charAt(i) == ')' && stack.pop() != '(' ||
                    s.charAt(i) == ']' && stack.pop() != '[' ||
                    s.charAt(i) == '}' && stack.pop() != '{' ) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

// For follow up, 如果有很多對應
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                // 遇到右括號
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            } else {
                // 遇到左括號
                stack.push(map.get(s.charAt(i)));
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}