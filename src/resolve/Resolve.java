package resolve;

import entity.Automate;
import entity.Function;

import java.util.List;
import java.util.Stack;

public class Resolve {
    public static boolean resolve(Automate automate, List<Character> input) {
        Stack<Character> stack = new Stack<>();
        stack.push(automate.getStartSymbol());
        while (!input.isEmpty()) {
            for (Function function : automate.getFunctions()) {
                char current = stack.pop();
                if (function.getFromSymbols().get(0).equals(current)) {
                    if (function.getToSymbols() == null) {
                        input.remove(0);
                        break;
                    } else {
                        for (int i = function.getToSymbols().size() - 1; i >= 0; i--) {
                            stack.push(function.getToSymbols().get(i));
                        }
                        break;
                    }
                } else {
                    stack.push(current);
                }
            }
        }
        if (input.isEmpty() && stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isEqual(List l1, List l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
