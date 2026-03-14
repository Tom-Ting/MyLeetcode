import org.junit.Test;

import java.util.Stack;

public class T20_E {
    /**
     * 判断有效扩红啊
     * @param s 源字符串
     * @return 是否有效
     * 时间复杂度：O(n)
     *      字符串遍历一遍，复杂度为O(n)
     *      循环内部，所有操作（包括 push、pop、字符比较等）复杂度均为 O(1)
     * 空间复杂度：O(n)
     *      最坏的情况（比如所有字符都是左括号），栈的大小会等于 n，复杂度为O(n)
     */
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
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
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
