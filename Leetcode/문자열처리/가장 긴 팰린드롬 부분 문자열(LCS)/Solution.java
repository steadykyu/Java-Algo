import java.util.*;
public class Solution {
    int left;
    int maxLen;
    public void extendPalindrome(String s, int j, int k){
        // 투 포인터가 유효한 범위 내에 있고, 양쪽 끝 문자가 일치하는 팰린드롬인 경우 양쪽으로 범위를 확장
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }

        // 기존 최대 길이보다 큰 팰린드롬이 나온 경우 값 교체
        if(maxLen < k-j-1){
            left = j+1;
            maxLen = k-j-1;
        }
    }

    public String longestPalindrome(String s) {
        // 문자 길이 저장
        int len = s.length();

        // 길이가 1인 경우 예외 처리
        if(len < 2) return s;

        // 슬라이딩 윈도우 방식으로 탐색을 진행
        // 우측으로 한 칸씩 이동하며 투 포인터 조사
        for(int i=0; i <len-1; i++){
            // 2칸짜리 슬라이딩 윈도우의 투 포인터를 전달
            // 3칸짜리 슬라이딩 윈도우의 투 포인터를 전달
            extendPalindrome(s, i, i+1);
            extendPalindrome(s, i, i+2);
        }

        // 최종 투포인터의 왼쪽과 최대 길이 만큼을 더한 오른쪽 만큼의 문자를 정답으로 리턴
        return s.substring(left, left+maxLen);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String param = "dcbabcdd";
        System.out.println(sol.longestPalindrome(param));

    }
}

    //String key2 = chars.toString();
