import java.util.*;
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 에너그램 결과를 담을 Map 선언
        Map<String, List<String>> results = new HashMap<>();

        for(String s : strs){
            // 1. str 배열 속의 각 단어를 정렬시켜 같은 애너그램임을 유추할 수 있는 Key 만든다.
            // 문자열(s)을 문자 배열로 변환
            char[] chars = s.toCharArray();
            // 문자 배열 정렬 ( [e,a,t] -> [a,e,t] )
            Arrays.sort(chars);
            //문자 배열을 키로 하기 위해 다시 문자열로 변환
            String key = String.valueOf(chars);

            // 2. Map 자료구조에 Key와 Key에 해당하는 애너그램목록을 담는다.
            //만약 기존에 없던 키라면 미리 빈 리스트 삽입
            if(!results.containsKey(key)) results.put(key,new ArrayList());
            // 키에 해당하는 Map의 Value 리스트에 문자열(s)추가
            results.get(key).add(s);
        }
        //(3) 문제에서 요구하는 출력값 형태로 변경
        return new ArrayList(results.values());
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = sol.groupAnagrams(strs);
        System.out.println(lists);
    }
}

    //String key2 = chars.toString();
