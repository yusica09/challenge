package tennis;

import static java.lang.Math.abs;

public class Set {
    int [] score;
    boolean isLastSet;
    boolean isTieBreak;

    public Set(boolean isLastSet) {
        score = new int[2];
        this.isTieBreak = false;
        this.isLastSet = isLastSet;
    }

    public void getScore(){
        Game game = new Game(isTieBreak,isLastSet);
        while(!game.hasWinner()){
            game.getPoint();
        }
        score[game.whoIsWinner()]++;
        printScore(game.whoIsWinner());
    }

    public Boolean hasWinner(){
        int s1 = score[0];
        int s2 = score[1];
        int gap = abs(s1 - s2);
        // 게임을 6번이상 이기면서 2점이상 차이날시 세트 승리
        if(s1 >= 6 || s2 >= 6){
            switch(gap){
                case 1: if(isTieBreak) return true;
                        break;
                case 0: isTieBreak = true;
                        System.out.println("** 다음게임 타이브레이크 !! **");
                        break;
                default : return true;
            }
        }
        return false;
    }

    public int whoIsWinner(){
        return score[0] < score[1] ? 1:0;
    }

    public void printScore(int n){
        //if (isTieBreak) System.out.println("***타이브레이크***");
        System.out.printf("> 1game 승자는 %d번째 진영\n", n+1);
        System.out.printf("game %d : %d\n", score[0],score[1]);
    }
}
