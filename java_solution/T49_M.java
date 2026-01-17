package org.leetcode;

import org.junit.Test;

import java.util.*;

public class T49_M {
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

    @Test
    public void run(){
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
    }
}
