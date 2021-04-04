package com.example.android_attrape_objet.entite;

import com.example.android_attrape_objet.entite.Objet;

import java.util.ArrayList;
import java.util.List;

public class Panier extends Objet{

    /**
     * Cette liste contient les objets obtenus par le joueur.
     */
    private List<Objet> lesObjetsObtenus = new ArrayList<Objet>();

    public Panier(int image){
        this.image = image;
        this.hauteur = 200;
    }

    /**
     * Ajoute un objet à la liste d'objet.
     * @param o l'objet à ajouter
     */
    public void ajouterObjet(Objet o){
        lesObjetsObtenus.add(o);
    }

    /**
     * retire un objet de la liste d'objet.
     * @param o l'objet à retirer.
     */
    public void retirerObjet(Objet o){
        lesObjetsObtenus.remove(o);
    }

    /**
     * Permet de savoir le nombre d'objet dans la liste d'objet.
     * @return la liste d'objets.
     */
    public int getNbObjet(){
        return lesObjetsObtenus.size();
    }
}
