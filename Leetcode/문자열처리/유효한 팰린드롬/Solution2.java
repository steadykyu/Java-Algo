public class Solution {
    public boolean isPalindrome(String s){
        // 정규식으로 유효한 문자(영숫자)만 추출한 다음 소문자로 변경
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // 문자열을 뒤집은 다음 String으로 변경
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();

        // equals 로 비교하여 팰린드롬인지 찾는다.
        return s_filtered.equals(s_reversed);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean result = sol.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }
}