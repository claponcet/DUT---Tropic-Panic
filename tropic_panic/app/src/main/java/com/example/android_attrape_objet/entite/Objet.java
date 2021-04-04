package com.example.android_attrape_objet.entite;

public class Objet {

    /**
     * Position x de l'objet.
     */
    protected double posX;

    /**
     * Position Y de l'objet.
     */
    protected double posY;

    /**
     * Largeur de l'objet.
     */
    protected double largeur;

    /**
     * Hauteur de l'objet.
     */
    protected double hauteur;

    /**
     * Image de l'objet.
     */
    protected int image;

    /**
     * Récupère la position X de l'objet.
     * @return la position X de l'objet.
     */
    public double getPosX() {
        return posX;
    }

    /**
     * Récupère la position Y de l'objet.
     * @return la position Y de l'objet.
     */
    public double getPosY() {
        return posY;
    }

    /**
     * Permet de modifier la position X de l'objet.
     * @param posX de l'objet.
     */
    public void setPosX(double posX) {
        this.posX = posX;
    }

    /**
     * Permet de modifier la position Y de l'objet.
     * @param posY de l'objet.
     */
    public void setPosY(double posY) {
        this.posY = posY;
    }

    /**
     * Permet de modifier la largeur de l'objet.
     * @param largeur de l'objet.
     */
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    /**
     * Permet de modifier la hauteur de l'objet.
     * @param hauteur de l'objet.
     */
    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * Permet de récupèrer la largeur de l'objet.
     * @return la largeur de l'objet.
     */
    public double getLargeur() {
        return largeur;
    }

    /**
     * Permet de récupèrer la hauteur de l'objet.
     * @return la hauteur de l'objet.
     */
    public double getHauteur() {
        return hauteur;
    }

    /**
     * Permet de récupèrer l'image de l'objet.
     * @return l'image de l'objet.
     */
    public int getImage() {
        return image;
    }
}
