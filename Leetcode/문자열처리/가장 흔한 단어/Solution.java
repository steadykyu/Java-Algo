import java.util.*;
public class Solution {
    public String mostCommonWord(String p, String[] banned){
        // 금지어 목록이 String 배열이므로. 비교 메소드가 존재하는 Set으로 변경한다.
        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        // 각 단어별 개수가 저장할 키-값 맵을 만든다.
        Map<String, Integer> counts = new HashMap<>();

        // 전처리 작업 후 단어 목록을 배열로 저장
        String[] words = p.replaceAll("\\W+"," ").toLowerCase().split(" ");

        for(String w : words){
            // 금지된 단어가 아닌 경우만 개수 처리
            if(!ban.contains(w)){
                // 기본적으로는 단어에 해당하는 횟수(value) 값에 +1 하여 저장
                // 존재하지 않는 단어라면 기본값을 0으로 지정하여 개수를 +1로 설정
                counts.put(w, counts.getOrDefault(w,0) + 1);
            }
        }
        // counts를 탐색하며 가장 흔하게 등장하는 단어 추출
        String result = Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] ban = {"hit"};

        String res = sol.mostCommonWord(p, ban);
        System.out.println(res);
    }
}