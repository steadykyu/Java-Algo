public class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        // 서로 중앙을 향해 이동하다, 겹치는 지점에 도달시 루프 종료
        while(start<end){
            // 임시 변수를 통해 스왑
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한 칸 앞으로
            start++;
            end--;
        }
    }
}