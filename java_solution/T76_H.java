import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T76_H {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> wMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!tMap.containsKey(c)){
                tMap.put(c, 1);
            }else {
                tMap.put(c, tMap.get(c) + 1);
            }
        }

        int left = 0;
        int right = 0;

        int[] left_length = new int[]{0, s.length()+1};

        while (right < s.length()){
            // 不是子串
            while (right < s.length() && !subStringCheck(wMap, tMap)){
                char c = s.charAt(right);
                if (tMap.containsKey(c)){
                    if (!wMap.containsKey(c)){
                        wMap.put(c, 1);
                    }else {
                        wMap.put(c, wMap.get(c) + 1);
                    }
                }
                right++;
            }

            // 已成为子串。right处位置已经过判定
            while (left < right && subStringCheck(wMap, tMap)){
                char c = s.charAt(left);
                if (tMap.containsKey(c)){
                    wMap.put(c, wMap.get(c) - 1);
                }
                left++;
            }
            // 刚好不是子串。left处位置已从子串中删除
            if (left_length[1] > right-left+1){
                left_length[0] = left-1;
                left_length[1] = right-left+1;
            }
        }
        if (left_length[1] > s.length()){
            return "";
        }
        return s.substring(left_length[0], left_length[0]+left_length[1]);
    }

    public boolean subStringCheck(Map<Character, Integer> s, Map<Character, Integer> t){
        for (Character tkey : t.keySet()) {
            if(s.getOrDefault(tkey,0) < t.get(tkey)){
                return false;
            }
        }
        return true;
    }


    @Test
    public void Test(){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("a", "b"));
    }
}

/*
if (s == null || t == null){
            return "";
        }

        int[] left_length = new int[]{0, s.length()+1};
        int left = -1;
        int right = -1;
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (tMap.containsKey(c)){
                tMap.put(c, (tMap.get(c)+1));
            }else {
                tMap.put(c, 1);
            }
        }
        Set<Character> tSet = new HashSet<>(tMap.keySet());

        while(right<s.length()){
            while (!tMap.isEmpty()){
                right++;
                if (right >= s.length()){
                    break;
                }
                char c = s.charAt(right);
                if (tSet.contains(c)) {
                    if (tMap.containsKey(c)) {
                        if (tMap.get(c) == 1) {
                            tMap.remove(c);
                        } else {
                            tMap.put(c, (tMap.get(c) - 1));
                        }
                    }
                }
            }
            // tMap.isEmpty() == true。此时[left, right]为子串

            while (tMap.isEmpty()){
                left++;
                if (left > right){
                    break;
                }
                char c = s.charAt(left);
                if (tSet.contains(c)){
                    tMap.put(c, 1);
                }
            }

            // 比较和更新最小字串长度信息
            if (left_length[1] > right-left+1){
                left_length[0] = left;
                left_length[1] = right-left+1;
            }
        }

        // 无匹配，返回空串
        if (left_length[1] == s.length()+1){
            return "";
        }

        return s.substring(left_length[0], left_length[0] + left_length[1]);
    }
 */
