package com.xuniverse.test.lev1;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 * 코딩테스트 연습
 * 연습문제
 * 문자열 다루기 기본

 문제 설명
 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

 제한 사항
 s는 길이 1 이상, 길이 8 이하인 문자열입니다.

 입출력 예
 s	    return
 "a234"	false
 "1234"	true
 */
public class 문자열_다루기_기본 {
    public static void main(String[] args) {
        System.out.println(solution("1234"));
//        solution("01033334444");
    }

    public static boolean solution(String s) {
        boolean answer = true;
        final String REGEX = "[0-9]+";
        if (s.length() == 4 || s.length() == 6) {
            if (!s.matches(REGEX)) {
                answer = false;
            }
        } else {
            answer = false;
        }
        return answer;
    }
}