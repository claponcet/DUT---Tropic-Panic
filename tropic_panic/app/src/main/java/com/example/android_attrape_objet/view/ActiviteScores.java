package com.example.android_attrape_objet.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_attrape_objet.R;
import com.example.android_attrape_objet.model.Manager;
import com.example.android_attrape_objet.view.adaptater.Adaptateur;
import com.example.android_attrape_objet.model.Score;

import java.util.ArrayList;

public class ActiviteScores extends AppCompatActivity {

    private RecyclerView recylerView;
    private RecyclerView.Adapter adaptateur;
    private RecyclerView.LayoutManager layoutManager;
    private final Manager mon_manager = ActiviteJouer.getMon_manager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_scores);

        ArrayList<Score> listeScores = mon_manager.getList_score();

        recylerView = findViewById(R.id.recyclerView);
        recylerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adaptateur = new Adaptateur(listeScores);

        recylerView.setLayoutManager(layoutManager);
        recylerView.setAdapter(adaptateur);

    }
}
