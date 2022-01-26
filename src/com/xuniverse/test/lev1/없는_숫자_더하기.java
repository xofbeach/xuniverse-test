package com.xuniverse.test.lev1;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 * 코딩테스트 연습
 * 월간 코드 챌린지 시즌3
 * 없는 숫자 더하기
 *
 문제 설명
 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

 제한사항
 - 1 ≤ numbers의 길이 ≤ 9
    - 0 ≤ numbers의 모든 원소 ≤ 9
    - numbers의 모든 원소는 서로 다릅니다.

 입출력 예
 numbers	        result
 [1,2,3,4,6,7,8,0]	14
 [5,8,4,0,6,7,9]	6

 입출력 예 설명
 입출력 예 #1
 5, 9가 numbers에 없으므로, 5 + 9 = 14를 return 해야 합니다.

 입출력 예 #2
 1, 2, 3이 numbers에 없으므로, 1 + 2 + 3 = 6을 return 해야 합니다.

 */

import java.util.Arrays;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

//    public static int solution(int[] numbers) {
//        int answer = 0;
//        int[][] numbersArr = new int[10][1];
//        for (int number : numbers) {
//            numbersArr[number][0] = 1;
//        }
//        for (int i = 0; i <= 9; i++) {
//            if (numbersArr[i][0] != 1) answer += i;
//        }
//        return answer;
//    }

    public static int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

}
