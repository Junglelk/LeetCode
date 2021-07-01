package question_0005.LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        //
        int n = s.length();
        String ans = "";
        boolean[][] flag = new boolean[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i+k < n; i++) {
                int j = i+k;
                if (k==0){
                    flag[i][j]=true;
                }else if (k==1){
                    flag[i][j] = (s.charAt(i)==s.charAt(j));
                }else {
                    flag[i][j] = (s.charAt(i)==s.charAt(j))&&flag[i+1][j-1];
                }
                if (ans.length()<k+1 &&flag[i][j]){
                    ans = s.substring(i, i + k + 1);
                }
            }
        }
        return ans;
    }
}
