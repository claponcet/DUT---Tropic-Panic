package com.example.android_attrape_objet.model.generation;

import com.example.android_attrape_objet.entite.Fruit;
import com.example.android_attrape_objet.model.Plateau;

public abstract class GenerateurEntite {

    public abstract boolean creerFruit(Plateau plateau);

    public abstract void creerPanier(Plateau plateau);
}
