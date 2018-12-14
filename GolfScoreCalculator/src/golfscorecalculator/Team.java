/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfscorecalculator;

/**
 *
 * @author CCannon
 */
public class Team implements Comparable<Team>{
    
    private int teamNumber;
    private int score;
    
    public Team(int teamNumber) {
        this.teamNumber = teamNumber;
        this.score = 0;
    }
    
    public void addScore(int newScore) {
        this.score += newScore;
    }
    
    @Override
    public int compareTo(Team other) {
        if(this.getScore() < other.getScore()) {
            return -1;
        }else if(this.getScore() > other.getScore()) {
            return 1;
        }
        return 0;
    }

    /**
     * @return the teamNumber
     */
    public int getTeamNumber() {
        return teamNumber;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
}
