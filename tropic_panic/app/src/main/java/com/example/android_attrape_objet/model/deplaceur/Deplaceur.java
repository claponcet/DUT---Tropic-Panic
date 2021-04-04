package com.example.android_attrape_objet.model.deplaceur;

import com.example.android_attrape_objet.model.Plateau;
import com.example.android_attrape_objet.model.collision.Collisionneur;

public abstract class Deplaceur {

    protected Collisionneur collisionneur;

    public Deplaceur(Collisionneur collisionneur) {
        this.collisionneur = collisionneur;
    }

    public abstract void deplacerDroiteLegerement(Plateau plateau);

    public abstract void deplacerDroite(Plateau plateau);

    public abstract void deplacerDroiteFortement(Plateau plateau);

    public abstract void deplacerGaucheLegerement(Plateau plateau);

    public abstract void deplacerGauche(Plateau plateau);

    public abstract void deplacerGaucheFortement(Plateau plateau);

    public abstract void descendreFruit(Plateau plateau);
}
