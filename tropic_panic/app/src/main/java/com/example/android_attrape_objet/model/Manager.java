package com.example.android_attrape_objet.model;

import com.example.android_attrape_objet.boucleur.Boucleur;
import com.example.android_attrape_objet.model.chargement.ChargeurScores;
import com.example.android_attrape_objet.model.chargement.ChargeurScoresBinaire;
import com.example.android_attrape_objet.model.collision.Collisionneur;
import com.example.android_attrape_objet.model.collision.CollisionneurSimple;
import com.example.android_attrape_objet.model.deplaceur.Deplaceur;
import com.example.android_attrape_objet.model.deplaceur.DeplaceurSimple;
import com.example.android_attrape_objet.model.generation.GenerateurEntite;
import com.example.android_attrape_objet.model.generation.GenerateurEntiteSimple;
import com.example.android_attrape_objet.model.sauvegarde.SauvegardeScore;
import com.example.android_attrape_objet.model.sauvegarde.SauvegardeScoreBinaire;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public class Manager implements Observer {

    /**
     * Fichier dans lequel sauvegarder les scores.
     */
    public static final String NAME_FILE = "historiqueScores";


    private Boucleur boucleur = new Boucleur();

    private Plateau plateau = new Plateau();

    private Collisionneur collisionneur = new CollisionneurSimple(plateau);

    private Deplaceur deplaceur = new DeplaceurSimple(collisionneur);

    private GenerateurEntite generateur = new GenerateurEntiteSimple();

    private Partie partie = new Partie();

    private SauvegardeScore sauvegarde = new SauvegardeScoreBinaire();

    private ChargeurScores chargeur = new ChargeurScoresBinaire();

    private static ArrayList<Score> list_score = new ArrayList<>();

    public Manager() {
        generateur.creerPanier(plateau);
        boucleur.setRunning(true);
        new Thread(boucleur).start();
    }

    /**
     * Permet de changer les scores.
     * @param file Fichier où récupèrer les scores.
     */
    public void chargement(FileInputStream file) {
        list_score = chargeur.chargerStats(file);
    }

    /**
     * Permet de sauvegarder les scores.
     * @param file Fichier où sauvegarder les scores.
     */
    public void sauvegarderDonnees(FileOutputStream file){
        sauvegarde.sauvegarderStats(list_score, file);
    }

    /**
     * Permet de récupèrer le générateur
     * @return le générateur.
     */
    public GenerateurEntite getGenerateur() {
        return generateur;
    }

    /**
     * Permet de récupèrer le boucleur.
     * @return le boucleur.
     */
    public Boucleur getBoucleur() {
        return boucleur;
    }

    /**
     * Permet de récupèrer le plateau.
     * @return le plateau.
     */
    public Plateau getPlateau() {
        return plateau;
    }

    /**
     * Permet de récupèrer le déplaceur.
     * @return le déplaceur.
     */
    public Deplaceur getDeplaceur() {
        return deplaceur;
    }

    /**
     * Permet de récupèrer le collisionneur.
     * @return le collisionneur.
     */
    public Collisionneur getCollisionneur() {
        return collisionneur;
    }

    public Partie getPartie() {
        return partie;
    }

    /**
     * Permet de mettre fin à une partie.
     * @param file Fichier où sauvegarder les scores.
     */
    public void finPartie(FileOutputStream file) {
        boucleur.setRunning(false);
        partie.setDate();
        list_score.add(partie.getObjetScore());
        sauvegarderDonnees(file);
    }

    /**
     * Permet de récupèrer les scores.
     * @return les scores.
     */
    public ArrayList<Score> getList_score() {
        Collections.sort(list_score);
        return list_score;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
