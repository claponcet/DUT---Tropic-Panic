package com.example.android_attrape_objet.model.sauvegarde;

import com.example.android_attrape_objet.model.Partie;
import com.example.android_attrape_objet.model.Score;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class SauvegardeScore {

    public abstract void sauvegarderStats(ArrayList<Score> historique, FileOutputStream file);
}
