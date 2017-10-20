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