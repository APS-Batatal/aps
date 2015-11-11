package aps.com.aps.components;

/**
 * Created by dihgg on 11/11/15.
 */
public class Score {
    private int score = 0;

    //Todo: criar sistema de highscore
    private int highscore = 0;


    public void add(int qty){
        this.score+=qty;
    }
    public void subtract(int qty){
        if((this.score-qty) <= 0){
            this.score = 0;
        } else {
            this.score -= qty;
        }
    }

    //GETTERS AND SETTERS
    public int getScore(){
        return this.score;
    }
}
