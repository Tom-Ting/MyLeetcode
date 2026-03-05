import org.junit.Test;

public class T5_M {
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1){
            return s;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int MaxLen = 1;
        int MaxLenIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            int SLoc = i-dp[i-1]-1;
            if (SLoc >= 0 && s.charAt(i) == s.charAt(SLoc) && SLoc < i){
                dp[i] = dp[i-1]+2;
            }else if (i > 1 && s.charAt(i) == s.charAt(i-2)){
                dp[i] = 3;
            }else if (s.charAt(i) == s.charAt(i-1)){
                dp[i] = 2;
            }else {
                dp[i] = 1;
            }
            if (MaxLen < dp[i]){
                MaxLen = dp[i];
                MaxLenIndex = i;
            }
        }
        return s.substring(MaxLenIndex-dp[MaxLenIndex]+1, MaxLenIndex+1);
    }

    @Test
    public void Test(){
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
