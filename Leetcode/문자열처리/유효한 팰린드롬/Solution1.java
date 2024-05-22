public class Solution {
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        // 서로 중앙으로 이동해나가다가 겹치는 지점에 도달하면 종료
        while(start < end){
            // start, end 각각 영숫자인지 판별: 유효하지 않으면 한 칸씩 이동
            System.out.printf("start = " + s.charAt(start) + " end = " + s.charAt(end) + "\n");
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }else {
                // 유효한 문자라면 앞글자와 뒷글자를 모두 소문자로 변경해 비교
                // 하나라도 일치하지 않는 경우 팰린드롬이 아니므로 false return
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    char b = s.charAt(start);
                    char a = s.charAt(end);
                    return false;
                }
                // 앞쪽 문자(start) 한 칸 뒤로, 뒤쪽 문자(end)는 한칸 앞으로 이동
                start++;
                end--;
            }
        }
        // 무사히 종료될 경우, 팰린드롬이므로 true return
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean result = sol.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }
}