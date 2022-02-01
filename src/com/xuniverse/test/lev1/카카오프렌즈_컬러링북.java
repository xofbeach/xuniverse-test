package com.xuniverse.test.lev1;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 * 코딩테스트 연습
 * 2017 카카오코드 예선
 * 카카오프렌즈 컬러링북

 문제 설명

 카카오 프렌즈 컬러링북
 출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

 [대충 어피치 그림]

 위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

 입력 형식
 입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.

 - 1 <= m, n <= 100
 - picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
 - picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.

 출력 형식
 리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

 예제 입출력
 m	n	picture	                                                                                answer
 6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]

 예제에 대한 설명
 예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.
 
 */

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();
    static boolean[][] visited;
    static int size = 0;
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(solution(m, n, picture));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        // picture[][] 배열을 순회한다.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // picture[i][j] 배열이 0이 아니고 방문한 적이 없다면 아래를 실행한다.
                if (picture[i][j] > 0 && visited[i][j] != true) {
                    size = 1;
                    bfs(picture, i, j, m, n);
                    // bfs 종료 후 처리
                    numberOfArea++; // 숫자가 이어지는 영역의 수 증가
                    // bfs 중에 찾은 가장 큰 영역 갱신
                    if (maxSizeOfOneArea < size) {
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }

    static void bfs(int[][] picture, int x, int y, int m, int n) {
        queue.add(new Node(x, y)); // 큐에 현재 노드 정보를 넣고 시작.
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 순회할 수 있는 위치인지 확인한다.
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    // 사진의 다음 위치가 현재의 위치와 같은 색이고, 방문한적이 없다면 방문한다.
                    if (picture[nx][ny] == picture[x][y] && visited[nx][ny] != true) {
                        // 큐에 현재 방문한 노드를 넣고 현재 위치를 방문표시한다.
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        size++;
                    }
                }
            }
        }
    }
}
