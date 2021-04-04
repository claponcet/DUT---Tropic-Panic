package com.example.android_attrape_objet.model;

import com.example.android_attrape_objet.R;
import com.example.android_attrape_objet.entite.Fruit;
import com.example.android_attrape_objet.entite.Objet;
import com.example.android_attrape_objet.entite.Panier;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    /**
     * Largeur du plateau.
     */
    private double largeur;

    /**
     * Hauteur du plateau.
     */
    private double hauteur;

    /**
     * Panier du joueur.
     */
    private Panier panier;

    /**
     * Fruits récupèrer par le joueur.
     */
    private List<Fruit> lesFruits = new ArrayList<Fruit>();

    /**
     * Permet de récupèrer la largeur du plateau.
     * @return la largeur du plateau.
     */
    public double getLargeur() {
        return largeur;
    }

    /**
     * Permet de récupèrer la hauteur du plateau.
     * @return la hauteur du plateau.
     */
    public double getHauteur() {
        return hauteur;
    }

    /**
     * Permet de modifier la largeur du plateau.
     * @param largeur du plateau
     */
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    /**
     * Permet de modifier la hauteur du plateau.
     * @param hauteur du plateau
     */
    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * Permet d'ajouter un fruit à la liste des fruits.
     * @param f le fruit a ajouté.
     */
    public void ajouterFruit(Fruit f){ lesFruits.add(f); }

    /**
     * Permet de retirer un fruit de la liste des fruits.
     * @param f fruit a retiré.
     */
    public void retirerFruit(Fruit f){ lesFruits.remove(f); }

    /**
     * Permet de récupèrer la liste des fruits.
     * @return la liste des fruits.
     */
    public List<Fruit> getLesFruits() {
        return lesFruits;
    }

    /**
     * Permet de récupèrer le panier du joueur.
     * @return le panier du joueur.
     */
    public Panier getPanier() {
        return panier;
    }

    /**
     * Permet d'ajouter au plateau le panier du joueur.
     * @param panier le panier créé.
     */
    public void ajouterPanier(Panier panier) {
        this.panier = panier;
    }
}
