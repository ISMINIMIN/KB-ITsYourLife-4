package 베열리뷰;

/*
 * 10 x 10 좌표에 10의 임의의 위치에 지뢰를 매설
 * 사용자는 행, 열 좌표를 입력 (1~10, 1~10)
 * 해당 좌표를 찾으면 : X 출력
 * 아니면 주위 8간 내 지뢰개수 출력
 * 열지 않은 좌표는 + 표시
 
 작성순서(초기화)
 1. 12x12 정수배열 생성
 2. 중복되지 않는 10개 좌표 생성
 3. 각 좌표에 9 저장, 주위 8개 1씩 증가
 4. (반복)
 5. 사용자로부터 좌표 입력(행, 열)
 6. 해당 좌표의 값이 9 이상이면 "지뢰찾음" 출력
 7. 해당 좌표의 값이 9 미만이면 "지뢰아님" 출력
 8. 전체 배열 출력(+ : 오픈 안 한 좌표. 숫자 : 지뢰 아닌 곳, X : 지뢰)
 9. 지뢰 10개를 다 찾으면 종료. 아니면 5번부터 반복
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class 지뢰빨리찾기 {
    public static void main(String[] args) {
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        int[][] map = new int[12][12];
        boolean[][] open = new boolean[12][12];
        int find = 0;
        
//        HashSet<Integer> set = new HashSet<>();
//        while(set.size() < 10) {
//        	int r = (int)(Math.random()*100+1);
//        	set.add(r);
//        	int r_num = r / 10 + 1;
//            int c_num = r % 10 + 1;
//            
//            map[r_num][c_num] = 9;
//            
//            for(int j=0; j<8; j++) {
//                int nr = r_num + dr[j];
//                int nc = c_num + dc[j];
//                map[nr][nc]++;
//            }
//        }
        
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0; i<100; i++) {
            nums.add(i+1);
        }
        
        for(int i=0; i<10; i++) {
            int r = (int)(Math.random()*nums.size()+1);
            int r_num = nums.remove(r);
            int row = r_num / 10 + 1;
            int col = r_num % 10 + 1;
            
            map[row][col] = 9;
            
            for(int j=0; j<8; j++) {
                int nr = row + dr[j];
                int nc = col + dc[j];
                map[nr][nc]++;
            }
        }
        
//      정답
        for(int i=0; i<12; i++) {
            for(int j=0; j<12; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        Scanner sc = new Scanner(System.in);
        
        while(find < 10) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(map[row][col] >= 9) {
                find++;
                System.out.println("지뢰 찾음, 남은 지뢰 : " + (10-find));
            } else {
                System.out.println("지뢰 아님, 남은 지뢰 : " + (10-find));
            }
            
            open[row][col] = true;
            
            for(int i=1; i<11; i++) {
                for(int j=1; j<11; j++) {
                    if(open[i][j] == true) {
                        if(map[i][j] >= 9) System.out.print("X" + " ");
                        else System.out.print(map[i][j] + " ");
                    } else System.out.print("+" + " ");
                }
                System.out.println();
            }
        }
        
        System.out.println("모두 찾음");
    }
}