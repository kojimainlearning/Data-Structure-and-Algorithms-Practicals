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
    public double stack_postfix_expr(String postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token: postfix.split(" ")) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (token.matches("[+\\-*/]")) {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                }
            }
        }

        return stack.pop();
    }

    public boolean isNumber(String expr) {
        if (expr == null) return false;
        return "/^\\s*(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:\\s*[+\\-*/]\\s*(?:\\d+(?:\\.\\d*)?|\\.\\d+))*\\s*$/".matches(expr);
    }

    public static void main(String[] args) {
        StackApp stackApp = new StackApp();


    }

}


