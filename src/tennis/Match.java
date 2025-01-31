package tennis;

public class Match {

    int [] score;
    int setNum;
    boolean isLastSet;

    public Match(int setNum) {
        this.setNum = setNum;
        score = new int[2];
        isLastSet = false;
    }

    public void getSetScore(){

        Set set = new Set(isLastSet);
        while(!set.hasWinner()){
            set.getScore();
        }
        score[set.whoIsWinner()]++;
        printScore(set.whoIsWinner());

    }

    public Boolean hasWinner(){
        int s1 = score[0];
        int s2 = score[1];

        int winCount = setNum/2 + 1;

        if(s1 == winCount || s2 == winCount){
            return true;
        }
        else if(s1 == winCount-1 && s2 == winCount-1){
            isLastSet = true;
            System.out.println("***마지막세트***");
            return false;
        }
        else{
            return false;
        }
    }

    public int whoIsWinner(){
        return score[0] < score[1] ? 1:0;
    }

    public void printScore(int n){
        //if (isLastSet) System.out.println("***마지막세트***");
        System.out.printf("> 1set 승자는 %d번째 진영\n", n+1);
        //System.out.printf("set %d : %d\n", score[whoIsWinner()],score[(whoIsWinner()+1)%2]);
        System.out.printf("set %d : %d\n", score[0],score[1]);
    }



}
