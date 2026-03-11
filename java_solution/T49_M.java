import org.junit.Test;

import java.util.*;

public class T49_M {
    /**
     * 我的解法：暴力解法。遍历所有字符串，判断其是否能加入已有字符串分组。
     * @param strs 源字符串数组。字符串个数为N，平均长度为L
     * @return 已分组的字符串组
     * 时间复杂度：O(L × N²)
     *      groupAnagrams函数：遍历数组O(N)
     *      IsIn函数：O(N)
     *      IsAnagrams函数：O(L)
     * 空间复杂度：O(N × L)
     *      最终结果数组ans：O(N × L)
     *      辅助数组flag1、flag2：O(1)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int N = strs.length;
        if (N == 0){
            return null;
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add(strs[0]);
        ans.add(temp);
        if (N == 1){
            return ans;
        }
        for (int i = 1; i < N; i++) {
            IsIn(ans, strs[i]);
        }
        return ans;
    }
    public void IsIn(List<List<String>> strss, String str){
        boolean flag = false;
        for (List<String> strs : strss) {
            if (IsAnagrams(strs.get(0), str)){
                strs.add(str);
                flag = true;
                break;
            }
        }
        if (!flag){
            List<String> temp = new ArrayList<>();
            temp.add(str);
            strss.add(temp);
        }
    }

    public boolean IsAnagrams(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        int[] flag1 = new int[26];
        int[] flag2 = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            flag1[str1.charAt(i)-'a']++;
            flag2[str2.charAt(i)-'a']++;
        }

        if (!Arrays.equals(flag1, flag2)){
            return false;
        }
        return true;
    }

    /**
     * 官方题解：将字符串内部字符按字典排序后的新字符串（不改变原字符串）作为字符串分组、存储和查找的键。
     * @param strs 源字符串数组。字符串个数为N，平均长度为L
     * @return 已分组的字符串组
     * 时间复杂度：O(N × L log L)
     *      字符串转字符数组：O(L)
     *      字符数组排序：O(L log L)
     *      HashMap操作：O(1)平均
     *      构建结果：O(N)
     * 空间复杂度：O(N × L)
     *      HashMap存储：O(N × L)
     *      临时字符数组：O(L)（可重用）
     *      排序辅助空间：O(log L) 或 O(L)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        // 略
        return null;
    }

    @Test
    public void run(){
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
    }
}
