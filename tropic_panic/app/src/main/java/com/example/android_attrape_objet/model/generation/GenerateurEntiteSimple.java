package com.example.android_attrape_objet.model.generation;

import com.example.android_attrape_objet.R;
import com.example.android_attrape_objet.entite.Fruit;
import com.example.android_attrape_objet.entite.Panier;
import com.example.android_attrape_objet.model.Plateau;
import com.example.android_attrape_objet.model.generation.GenerateurEntite;

import java.util.Random;

public class GenerateurEntiteSimple extends GenerateurEntite {

    /**
     * Créé un panier.
     * @param plateau où joue le joueur.
     */
    @Override
    public void creerPanier(Plateau plateau) {
        plateau.ajouterPanier(new Panier(R.drawable.panier));
    }

    /**
     * Créé un fruit.
     * @param plateau où joue le joueur.
     * @return true si l'objet a été créé, false sinon.
     */
    @Override
    public boolean creerFruit(Plateau plateau) {

        Random rand = new Random();
        int randomX = rand.nextInt( (int) plateau.getLargeur()-100);
        int randomY = 200 + rand.nextInt(250 - 200);
        int apparition = rand.nextInt(25);
        if(apparition == 1 ) {
            plateau.ajouterFruit(new Fruit((double) randomX, (double) randomY, 250, 125));
            return true;
        }
        return false;
    }
}
