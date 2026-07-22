import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else { // ch == ')'
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses solver = new LongestValidParentheses();
        System.out.println(solver.longestValidParentheses("(()"));      
        System.out.println(solver.longestValidParentheses(")()())"));   
        System.out.println(solver.longestValidParentheses(""));        
    }
}