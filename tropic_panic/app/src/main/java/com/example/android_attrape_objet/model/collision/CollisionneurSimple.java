package com.example.android_attrape_objet.model.collision;

import android.util.Log;

import com.example.android_attrape_objet.entite.Fruit;
import com.example.android_attrape_objet.entite.Panier;
import com.example.android_attrape_objet.model.Plateau;
import com.example.android_attrape_objet.model.collision.Collisionneur;

public class CollisionneurSimple extends Collisionneur {

    public CollisionneurSimple(Plateau plateau) {
        super(plateau);
    }

    /**
     * Permet de savoir si le joueur peut se deplacer
     * @param posX du panier
     * @return true si le panier peut bouger, false sinon.
     */
    @Override
    public boolean canMove(double posX) {
        return (posX < plateau.getLargeur() - plateau.getPanier().getLargeur() && posX > 0);
    }

    /**
     * Permet d'attraper un fruit si le joueur est en collision avec.
     * @return l'indexe de l'objet attrapé.
     */
    public int attrapeFruit() {
        Panier panier = plateau.getPanier();
        int i = 0;
//        Log.d("panier","X : " + panier.getPosX());
//        Log.d("panier","Y : " + panier.getPosY());
        for (Fruit f : plateau.getLesFruits()) {
//            if (f.getPosY() >= plateau.getHauteur()-150) {
//                Log.d("fruit","raté");
//                return false;
//            }
            if ((f.getPosX() + f.getLargeur()) > panier.getPosX() && f.getPosX() < (panier.getPosX() + panier.getLargeur())) {
                if (f.getPosY() + f.getHauteur()-100f > panier.getPosY() && f.getPosY() < panier.getPosY() + panier.getHauteur()) {
                    plateau.getPanier().ajouterObjet(f);
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    /**
     * Permet de savoir si un fruit est sorti de l'ecran.
     * @return l'index de l'objet qui est sorti de l'ecran
     */
    public int rateFruit() {
        Panier panier = plateau.getPanier();
        int i = 0;
        for (Fruit f : plateau.getLesFruits()) {
            if (f.getPosY() + 100>= plateau.getHauteur()) {
                Log.d("fruit", "raté");
                return i;
            }
            i++;
        }
        return -1;
    }
}
