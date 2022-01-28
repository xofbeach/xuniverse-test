package com.xuniverse.test.lev1;

import java.util.Arrays;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    /**
     * participant와 completion를 List로 변환하여 removeAll() 함수를 통해 중복항목을 제거한다.
     * 속도이슈가 있음.
     * @param participant
     * @param completion
     * @return
     */
//    public static String solution(String[] participant, String[] completion) {
//        List<String> participantList = new ArrayList<>(Arrays.asList(participant));
//        participantList.removeAll(new ArrayList<>(Arrays.asList(completion)));
//
//        return participantList.get(0);
//    }


    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < participant.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
