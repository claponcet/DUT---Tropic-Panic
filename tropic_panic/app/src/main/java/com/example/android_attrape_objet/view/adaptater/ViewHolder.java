package com.example.android_attrape_objet.view.adaptater;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_attrape_objet.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textScore;
    private TextView textDate;
    private TextView textPosition;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textScore = itemView.findViewById(R.id.textScore);
        textDate = itemView.findViewById(R.id.dateScore);
        textPosition = itemView.findViewById(R.id.textPosition);
    }

    /**
     * Permet de récupèrer la TextView date.
     * @return la TextView texteDate
     */
    public TextView getTextDate() {
        return textDate;
    }

    /**
     * Permet de récupèrer la TextView score.
     * @return la TextView textScore
     */
    public TextView getTextScore() {
        return textScore;
    }

    /**
     * Permet de récupèrer la TextView position.
     * @return la TextView textPosition.
     */
    public TextView getTextPosition() {
        return textPosition;
    }
}

