package com.example.android_attrape_objet.model.deplaceur;

import com.example.android_attrape_objet.entite.Fruit;
import com.example.android_attrape_objet.model.Plateau;
import com.example.android_attrape_objet.model.collision.Collisionneur;

public class DeplaceurSimple extends Deplaceur {

    public DeplaceurSimple(Collisionneur collisionneur) {
        super(collisionneur);
    }

    /**
     * Permet de déplacer le panier légèrement à droite.
     * @param plateau où joue le joueur.
     */
    @Override
    public void deplacerDroiteLegerement(Plateau plateau) {
        if(collisionneur.canMove(plateau.getPanier().getPosX() + 1f))
            plateau.getPanier().setPosX(plateau.getPanier().getPosX() + 1f);
    }

    /**
     * Permet de déplacer le panier à droite.
     * @param plateau où joue le joueur.
     */
    @Override
    public void deplacerDroite(Plateau plateau) {
        if(collisionneur.canMove(plateau.getPanier().getPosX() + 2.5f))
            plateau.getPanier().setPosX(plateau.getPanier().getPosX() + 2.5f);
    }

    /**
     * Permet de déplacer le panier fortement à droite.
     * @param plateau où joue le joueur.
     */
    @Override
    public void deplacerDroiteFortement(Plateau plateau) {
        if(collisionneur.canMove(plateau.getPanier().getPosX() + 5f))
            plateau.getPanier().setPosX(plateau.getPanier().getPosX() + 5f);
    }

    /**
     * Permet de déplacer le panier légèrement à gauche.
     * @param plateau où joue le joueur.
     */
    @Override
    public void deplacerGaucheLegerement(Plateau plateau) {
        if(collisionneur.canMove(plateau.getPanier().getPosX() - 1f))
            plateau.getPanier().setPosX(plateau.getPanier().getPosX() - 1f);
    }

    /**
     * Permet de déplacer le panier à gauche.
     * @param plateau où joue le joueur.
     */
    @Override
    public void deplacerGauche(Plateau plateau) {
        if(collisionneur.canMove(plateau.getPanier().getPosX() - 2.5f))
            plateau.getPanier().setPosX(plateau.getPanier().getPosX() - 2.5f);
    }

    /**
     * Permet de déplacer le panier fortement à gauche.
     * @param plateau où joue le joueur.
     */
    @Override
    public void deplacerGaucheFortement(Plateau plateau) {
        if(collisionneur.canMove(plateau.getPanier().getPosX() - 5f))
            plateau.getPanier().setPosX(plateau.getPanier().getPosX() - 5f);
    }

    /**
     * Permet de descendre les fruits.
     * @param plateau où joue le joueur.
     */
    @Override
    public void descendreFruit(Plateau plateau) {
        for (Fruit fruit : plateau.getLesFruits()) {
            fruit.setPosY(fruit.getPosY() + 15f);
        }
    }
}
