package tennis;

import static java.lang.Math.*;

public class Game {
    // 필드
    int [] score;
    boolean isTieBreak;
    boolean isDeuce;
    boolean hasAD;
    boolean isLastSet;

    // 생성자
    public Game(boolean isTieBreak, boolean isLastSet) {
        this.score = new int[2];
        this.isTieBreak = isTieBreak;
        this.isDeuce = false;
        this.hasAD = false;
        this.isLastSet = isLastSet;
    }

    // 메서드
    public void getPoint(){
        // n = 0 or 1
        int n = (int)(Math.random()*2);
        score[n]++;

        printScore(n);
    }

    public Boolean hasWinner(){
        int countNum = !isTieBreak? 4 : isLastSet? 10 : 7;

        int s1 = score[0];
        int s2 = score[1];
        int gap = abs(s1 - s2);
        // 4포인트 이상 획득하면서 2점이상일 경우 게임 승리
        if(s1 >= countNum || s2 >= countNum){
            switch(gap){
                case 1: if(isDeuce) hasAD = true;
                        break;
                case 0: if(hasAD) hasAD = false;
                        isDeuce = true;
                        System.out.println("** 듀스 시작 **");
                        break;
                default : return true;

            }
        }
        return false;
    }

    public int whoIsWinner(){
        return (score[0] < score[1]) ? 1:0;
    }

    public void printScore(int n){ // 포인트에 따른 점수변환 필요 15 30 40 AD
        //if (isDeuce) System.out.println("*** 듀 스 ***");
        System.out.printf("> 1포인트 승자는 %d번째 진영\n", n+1);
        System.out.printf("%d point : %d point\n", score[0],score[1]);
    }

}
