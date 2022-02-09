package com.xuniverse.test.lev1;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * 참고 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-124-%EB%82%98%EB%9D%BC%EC%9D%98-%EC%88%AB%EC%9E%90-Java
 * 코딩테스트 연습
 * 연습문제
 * 124 나라의 숫자
 문제 설명
 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

 - 124 나라에는 자연수만 존재합니다.
 - 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.

 예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
 10진법	124 나라	10진법	124 나라
 1	    1	    6	    14
 2	    2	    7	    21
 3	    4	    8	    22
 4	    11	    9	    24
 5	    12	    10	    41

 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

 제한사항
 - n은 500,000,000이하의 자연수 입니다.

 입출력 예
 n	result
 1	1
 2	2
 3	4
 4	11
 */
public class _124_나라의_숫자 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        int num = n;

        // if n = 5 -> 5 % 3 = 1...2 -> 1...2 : 12
        // if n = 6 -> 6 % 3 = 2...0 -> 1...0 : 14
        while (num > 0) {
            int remainder = num % 3;
            num /= 3;
            if (remainder == 0) num--;
            answer = numbers[remainder] + answer;
        }
        return answer;
    }
}
