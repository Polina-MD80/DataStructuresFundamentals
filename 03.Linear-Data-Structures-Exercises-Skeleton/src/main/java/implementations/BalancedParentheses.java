package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        if (parentheses.isEmpty() || parentheses.length() % 2 != 0) {
            return false;
        }
        String open = "{[(";
        String close = "}])";
        for (int i = 0; i < this.parentheses.length(); i++) {
            char currant = parentheses.charAt(i);
            if (open.indexOf(currant) >= 0) {
                stack.push(currant);
            } else if (!stack.isEmpty()) {
                Character openBracket = stack.pop();
                return open.indexOf(openBracket) == close.indexOf(currant);

            }

        }


        return true;
    }
}
