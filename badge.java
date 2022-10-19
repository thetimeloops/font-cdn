class Solution {
    public boolean isMatch(String s, String p, int si, int pi, Boolean[][] dp) {
        if (si >= s.length() && pi >= p.length())
            return true;
        else if (pi >= p.length())
            return false;

        boolean result = false;
        if (dp[si][pi] == null) {
            boolean match = si < s.length() && (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi));

            if ((pi + 1) < p.length() && p.charAt(pi + 1) == '*') {
                result = isMatch(s, p, si, pi + 2, dp) || (match && isMatch(s, p, si + 1, pi, dp));
            } else {
                result = match && isMatch(s, p, si + 1, pi + 1, dp);
            }
            dp[si][pi] = result;
        }
        return dp[si][pi];
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, dp);
    }
}