package S2806_NQueen;

import java.util.Scanner;

public class Solution {
    static int answer;
    static int N;
    static int[] board;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        
        for(int t=1; t<=TC; t++) {
            answer = 0;
            N = sc.nextInt();
            board = new int[N];
            setQueens(0);
            System.out.println("#" + t + " " + answer);
        }
    }

    public static void setQueens(int rowNum){
         if(rowNum == N) { // 끝까지 다 놓은 경우
            answer++;
            return;
        }
         
        for(int colNum=0; colNum<=N; colNum++){ // 해당 행의 0열부터 N-1열까지 퀸 놓는 시도
        	board[rowNum] = colNum; 
            if(checking(rowNum)){ 
                setQueens(rowNum+1); 
            }
        }
    }

    // rowNum 행에 퀸을 놓을수 있는지 rowNum-1 행까지 rowNum 행과 비교하며 체크
    public static boolean checking(int rowNum){
        for(int beforeRowNum=0; beforeRowNum<rowNum; beforeRowNum++){ // 현재 행의 이전까지만 확인하면 됨
            if(board[rowNum] == board[beforeRowNum] || Math.abs(board[rowNum]-board[beforeRowNum]) == rowNum-beforeRowNum){ // 행 번호의 차이와 열 번호의 차이가 같으면 대각선
                return false;
            }
        }
        return true;
    }
}