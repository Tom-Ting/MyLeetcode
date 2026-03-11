import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T17_M {
    /**
     * 我的思路：外层循环数字，然后将数字对应的字母逐个分别加到已有的字符串中
     * @param digits 源数字。其中，有m个数对应3个字母，n个数对应4个字母。
     * @return 对应的全部字符串组合
     * 时间复杂度：O((m+n)(3^m × 4^n))
     *      总组合数：O(3^m × 4^n)
     *      字符串拼接：O(m+n)
     * 空间复杂度：O((m+n) × 3^m × 4^n)
     *      总组合数：O(3^m × 4^n)
     *      每个组合中字符串长度：(m+n)
     */
    public List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> Num2String = new HashMap<>();
        Num2String.put("2", Arrays.asList("a","b","c"));
        Num2String.put("3", Arrays.asList("d","e","f"));
        Num2String.put("4", Arrays.asList("g","h","i"));
        Num2String.put("5", Arrays.asList("j","k","l"));
        Num2String.put("6", Arrays.asList("m","n","o"));
        Num2String.put("7", Arrays.asList("p","q","r","s"));
        Num2String.put("8", Arrays.asList("t","u","v"));
        Num2String.put("9", Arrays.asList("w","x","y","z"));

        List<String> SA = Num2String.get(digits.substring(0,1));

        if (digits.length() == 1){
            return SA;
        }

        for (int i = 1; i < digits.length(); i++) {
            List<String> BA = Num2String.get(digits.substring(i,i+1));
            SA = StringCombination(SA, BA);
        }
        return SA;
    }

    public List<String> StringCombination(List<String> s1, List<String> s2){
        List<String> ans = new ArrayList<>();
        for (String ss1 : s1) {
            for (String ss2 : s2) {
                ans.add(ss1+ss2);
            }
        }
        return ans;
    }


    @Test
    public void run(){
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
        // System.out.println(StringCombination(Arrays.asList("a","b","c"), Arrays.asList("d","e","f")));
    }
}
/*
    1. 输入的字符串如何转数字
    2. 数字如何对应字母
    3. 如何进行组合

    1. 先循环，构造n个备选的列表
    2. 写函数，构造两个字符串相乘
 */
