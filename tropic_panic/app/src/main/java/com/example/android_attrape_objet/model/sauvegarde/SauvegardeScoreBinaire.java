package com.example.android_attrape_objet.model.sauvegarde;

import com.example.android_attrape_objet.model.Partie;
import com.example.android_attrape_objet.model.Score;
import com.example.android_attrape_objet.model.chargement.ChargeurScores;
import com.example.android_attrape_objet.model.chargement.ChargeurScoresBinaire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class SauvegardeScoreBinaire extends SauvegardeScore {

    /**
     * Permet de sauvegarder les scores.
     * @param listeScore liste des scores.
     * @param file Fichier où l'on doit sauvegarder.
     */
    @Override
    public void sauvegarderStats(ArrayList<Score> listeScore, FileOutputStream file) {
        serialiser(listeScore, file);
    }

    /**
     * Permet de sérialiser les scores.
     * @param listeScore liste des scores.
     * @param file Fichier où l'on doit sauvegarder.
     */
    private void serialiser(ArrayList<Score> listeScore, FileOutputStream file) {
        try {
            ObjectOutputStream oout = new ObjectOutputStream(file);
            oout.writeObject(listeScore);
            oout.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
