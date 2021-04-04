package com.example.android_attrape_objet.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Partie {

    /**
     * Score de la partie en cours.
     */
    private Score score = new Score();

    /**
     * Vies du joueur.
     */
    private int [] lesVies = new int[3];

    /**
     * Indique si le joueur a perdu ou pas.
     */
    private boolean perdu = false;

    public Partie() {
        for (int i = 0; i < 3; i++) {
            lesVies[i] = 1;
        }
    }

    /**
     * Permet de retirer une vie.
     * @return l'index de la vie perdue.
     */
    public int perdreUneVie() {
        int i;
        for ( i = 0 ; i < 3 ; i++) {
            if (lesVies[i] == 1) {
                lesVies[i] = 0;
                break;
            }
        }

        if (i == 2) {
            perdu = true;
        }

        return i;
    }

    /**
     * Permet de savoir si le joueur à perdu.
     * @return true si le joueur a perdu, false sinon.
     */
    public boolean aPerdu() { return perdu; }

    /**
     * Permet d'incrémenter le score de la partie.
     */
    public void incrementerScore() {
        score.setScore(score.getScore()+1);
    }

    /**
     * Permet de récupèrer le score de la partie.
     * @return le score de la partie.
     */
    public int getScore() { return score.getScore(); }

    /**
     * Permet de récupèrer l'objet Score de la partie.
     * @return l'objet Score de la partie.
     */
    public Score getObjetScore() { return score; }

    /**
     * Permet de définir la date de la partie.
     */
    public void setDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = Calendar.getInstance().getTime();
        score.setDate(formatter.format(date));
    }


}
