package com.example.android_attrape_objet.model.chargement;

import com.example.android_attrape_objet.model.Partie;
import com.example.android_attrape_objet.model.Score;

import java.io.FileInputStream;
import java.util.ArrayList;

public abstract class ChargeurScores {

    public abstract ArrayList<Score> chargerStats(FileInputStream file);
}
