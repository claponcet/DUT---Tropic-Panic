package com.example.android_attrape_objet.model.chargement;

import com.example.android_attrape_objet.model.Partie;
import com.example.android_attrape_objet.model.Score;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChargeurScoresBinaire extends ChargeurScores {

    /**
     * Permet charger les scores.
     * @param file fichier dans lequel récupèrer les scores.
     * @return la liste des scores.
     */
    @Override
    public ArrayList<Score> chargerStats(FileInputStream file) {
        return deserialiser(file);
    }

    /**
     * Permet de déserialiser les scores.
     * @param file fichier dans lequel récupèrer les scores.
     * @return la liste des scores.
     */
    private ArrayList<Score> deserialiser(FileInputStream file) {
        ArrayList<Score> historique = new ArrayList<>();
        try {
            ObjectInputStream oin = new ObjectInputStream(file);
            historique = (ArrayList<Score>) oin.readObject();
            Collections.sort(historique);
            oin.close();
        } catch (ClassNotFoundException | IOException nfe) {
            nfe.printStackTrace();
        }
        return historique;
    }
}
