package com.example.android_attrape_objet.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_attrape_objet.R;
import com.example.android_attrape_objet.model.Manager;
import com.example.android_attrape_objet.view.adaptater.Adaptateur;

import java.io.FileNotFoundException;

public class ActivitePrincipale extends AppCompatActivity {

    private Button boutonJouer;
    private Button boutonScores;
    private Manager mon_manager = ActiviteJouer.getMon_manager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_principale);

        try {
            mon_manager.chargement(openFileInput(Manager.NAME_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boutonJouer = findViewById(R.id.buttonJouer);
        boutonJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivitePrincipale.this,ActiviteJouer.class));
            }
        });

        boutonScores = findViewById(R.id.buttonScore);
        boutonScores.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivitePrincipale.this,ActiviteScores.class);
                startActivity(i);
            }
        }));
    }
}
