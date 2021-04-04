package com.example.android_attrape_objet.model;

import java.io.Serializable;

public class Score implements Comparable, Serializable {

    /**
     * Score de la partie.
     */
    private int score;

    /**
     * date de la partie.
     */
    private String date;

    public Score() {
        score = 0;
        date = "";
    }

    /**
     * Permet de récupèrer le score.
     * @return le score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Permet de récupèrer le score sous forme de string.
     * @return le score sous forme de string.
     */
    public String getScoreString() { return String.valueOf(score); }

    /**
     * Permet de modifier le score.
     * @param score le nouveau score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Permet de récupèrer la date.
     * @return la date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Permet de modifier la date.
     * @param date la nouvelle date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        Score other = (Score)o;
        return other.getScore() - this.score;
    }
}
