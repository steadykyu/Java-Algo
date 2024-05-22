import java.util.*;
public class Solution {
    public String[] reorderLogFiles(String[] logs) {

        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for(String log: logs){
            // 로그 종류 확인 후 숫자 로그라면 숫자 리스트에 삽입
            if(Character.isDigit(log.split(" ")[1].charAt(0))){
                digitList.add(log);
            }else {
                // 숫자 로그가 아니라면 문자 리스트에 삽입
                letterList.add(log);
            }
        }

//         문자 로그는 사전 순으로 정렬한다.
        letterList.sort((s1, s2) -> {
            // 식별자와 식별자 외 나머지 부분, 이렇게 두 부분으로 나눈다.
            String[] s1x = s1.split(" ",2);
            String[] s2x = s2.split(" ",2);

            // 문자 로그 사전순 비교
            int compared = s1x[1].compareTo(s2x[1]);
            // 문자가 동일한 경우 식별자 비교
            if(compared == 0){
                return s1x[0].compareTo(s2x[0]);
            }else{
                return compared;
                // 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 순서가 뒤인 경우 -1을 출력하고, 이를
            }
        });

        // 문자 리스트 뒤로 숫자 리스트를 이어 붙인다.
            // 숫자로그는 입력 순서대로 이므로 따로 정렬하지 않는다.
        letterList.addAll(digitList);

        //리스트를 String 배열로 변환해 리턴한다.
        return letterList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        String[] res = sol.reorderLogFiles(logs);
        System.out.println(Arrays.toString(res));
    }
}