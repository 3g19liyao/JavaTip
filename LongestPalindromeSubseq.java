package LiKou;

public class LongestPalindromeSubseq {
    public static void main(String[] args) {

    }
    public static int longestPalindromeSubseq(String s) {
        if(s == null){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i<len; i++){
            dp[i][i] = 1;
        }
        //从下往上遍历
        for(int i = len-1; i>=0; i--){
            for(int j = i+1; j<len; j++){
                //那么就说明在原先的基础上又增加了回文子序列的长度
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                //表明这时dp[i][j]只需取两者之间的最大值即可
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
