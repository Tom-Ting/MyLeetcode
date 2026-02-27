import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class T739_M {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()){
                int tem = stack.pop();
                if (temperatures[tem] < temperatures[i]){
                    answer[tem] = i-tem;
                }else {
                    stack.push(tem);
                    break;
                }
            }
            stack.push(i);
        }
        return answer;
    }

    @Test
    public void Test(){
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60,90})));
    }
}
/*
    这题表面上很抽象，其实还真是使用栈做的。
    对于某天，先和栈内元素进行判断，看能吐出几个元素。判断完了自己入栈
    由于实际上满足升序就出栈，所以栈内其实是降序排列
 */
