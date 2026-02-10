import java.util.Stack;

public class StackApp {
    // Question 3
    public boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch: expr.toCharArray()) {
            if ("({[".indexOf(ch) >= 0) {
                stack.push(ch);
            } else if (")}]".indexOf(ch) >= 0) {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!matches(open, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }


    // Question 4


    public static void main(String[] args) {
        StackApp stackApp = new StackApp();


    }

}


