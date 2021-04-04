package com.example.android_attrape_objet.view.adaptater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_attrape_objet.R;
import com.example.android_attrape_objet.entite.Fruit;
import com.example.android_attrape_objet.entite.Objet;
import com.example.android_attrape_objet.entite.Panier;
import com.example.android_attrape_objet.model.Score;

import java.util.ArrayList;
import java.util.List;

public class Adaptateur extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Score> lesScores;

    public Adaptateur(ArrayList<Score> scores) {
        lesScores = scores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Score courant = lesScores.get(position);
        holder.getTextDate().setText(courant.getDate());
        String score = "Score : " + courant.getScoreString();
        holder.getTextScore().setText(score);
        String textPos = "n°"+ String.valueOf(position+1);
        holder.getTextPosition().setText(textPos);
    }

    @Override
    public int getItemCount() {
        return lesScores.size();
    }
}
