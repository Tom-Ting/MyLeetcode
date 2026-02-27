import org.junit.Test;

import java.util.Stack;

public class T20_E {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()){
                stack.push(c);
                continue;
            }
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.pop() != '{'){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void Test(){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid(""));
    }
}
