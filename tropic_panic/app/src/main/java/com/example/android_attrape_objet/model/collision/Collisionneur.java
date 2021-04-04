package com.example.android_attrape_objet.model.collision;

import com.example.android_attrape_objet.model.Plateau;

public abstract class Collisionneur {

    protected Plateau plateau;

    public Collisionneur(Plateau plateau){
        this.plateau = plateau;
    }

    public abstract boolean canMove(double posX);

    public abstract int attrapeFruit();

    public abstract int rateFruit();
}
