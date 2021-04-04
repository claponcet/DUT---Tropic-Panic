package com.example.android_attrape_objet.view;

import android.content.Intent;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_attrape_objet.R;
import com.example.android_attrape_objet.boucleur.Boucleur;
import com.example.android_attrape_objet.entite.Fruit;
import com.example.android_attrape_objet.model.Manager;
import com.example.android_attrape_objet.model.Partie;
import com.example.android_attrape_objet.model.Plateau;
import com.example.android_attrape_objet.model.Score;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class ActiviteJouer extends AppCompatActivity implements Observer {

    private static Manager mon_manager = new Manager();

    private SensorManager gyroscopeManager;
    private Sensor gyroscope;
    private SensorEventListener gyroscopeEventListener;
    private List<ImageView> mes_fruits;
    private ImageView mon_panier;
    private float rotationZ;
    private FrameLayout fl;
    private TextView score;
    private ImageView[] lesCoeurs;
    private LinearLayout popupPerdu;
    private TextView scoreFinal;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_jouer);

        mon_manager = new Manager();

        rotationZ = 0;

        mes_fruits = new ArrayList<ImageView>();

        lesCoeurs = new ImageView[3];

        this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mon_son);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        score = findViewById(R.id.textScore);
        scoreFinal = findViewById(R.id.scoreFinal);

        lesCoeurs[0] = findViewById(R.id.vie1);
        lesCoeurs[1] = findViewById(R.id.vie2);
        lesCoeurs[2] = findViewById(R.id.vie3);

        fl = findViewById(R.id.monFrameLayout);
        popupPerdu = findViewById(R.id.layoutPerdu);

        gyroscopeManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscope = gyroscopeManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        mon_panier = findViewById(R.id.imageViewPanier);
        mon_panier.setImageResource(R.drawable.panier);

        mon_manager.getBoucleur().addObserver(this);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mon_manager.getPlateau().setLargeur(size.x);
        mon_manager.getPlateau().setHauteur(size.y);

        gyroscopeEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float valueZ = event.values[2];
                if (rotationZ + valueZ < 130 && rotationZ + valueZ > -130) {
                    rotationZ += valueZ;
                }
                if (rotationZ > 15f) {
                    if (rotationZ > 50f) {
                        if (rotationZ > 100f) {
                            mon_manager.getDeplaceur().deplacerGaucheFortement(mon_manager.getPlateau());
                            mon_panier.setX((float) mon_manager.getPlateau().getPanier().getPosX());
                        } else {
                            mon_manager.getDeplaceur().deplacerGauche(mon_manager.getPlateau());
                            mon_panier.setX((float) mon_manager.getPlateau().getPanier().getPosX());
                        }
                    } else {
                        mon_manager.getDeplaceur().deplacerGaucheLegerement(mon_manager.getPlateau());
                        mon_panier.setX((float) mon_manager.getPlateau().getPanier().getPosX());
                    }
                } else if (rotationZ < -15f) {
                    if (rotationZ < -50f) {
                        if (rotationZ < -100f) {
                            mon_manager.getDeplaceur().deplacerDroiteFortement(mon_manager.getPlateau());
                            mon_panier.setX((float) mon_manager.getPlateau().getPanier().getPosX());
                        } else {
                            mon_manager.getDeplaceur().deplacerDroite(mon_manager.getPlateau());
                            mon_panier.setX((float) mon_manager.getPlateau().getPanier().getPosX());
                        }
                    } else {
                        mon_manager.getDeplaceur().deplacerDroiteLegerement(mon_manager.getPlateau());
                        mon_panier.setX((float) mon_manager.getPlateau().getPanier().getPosX());
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mon_manager.getPlateau().getPanier().setHauteur(mon_panier.getHeight());
        mon_manager.getPlateau().getPanier().setLargeur(mon_panier.getWidth());
        mon_manager.getPlateau().getPanier().setPosX(mon_panier.getX());
        mon_manager.getPlateau().getPanier().setPosY(mon_panier.getY());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
        mon_manager.getBoucleur().setRunning(true);
        gyroscopeManager.registerListener(gyroscopeEventListener, gyroscope, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mon_manager.getBoucleur().setRunning(false);
        gyroscopeManager.unregisterListener(gyroscopeEventListener);
        mediaPlayer.pause();
    }

    @Override
    public void update(Observable o, Object arg) {
        runOnUiThread(() -> {
            int i = 0;
            int index1, index2;

            if (mon_manager.getGenerateur().creerFruit(mon_manager.getPlateau())) {
                creerFruit();
            }

            mon_manager.getDeplaceur().descendreFruit(mon_manager.getPlateau());

            for (ImageView dep_fruit : mes_fruits) {
                dep_fruit.setY((float) mon_manager.getPlateau().getLesFruits().get(i).getPosY());
                i++;
            }

            index1 = mon_manager.getCollisionneur().attrapeFruit();

            if (index1 != -1) {
                mon_manager.getPlateau().getLesFruits().remove(index1);
                ImageView view = mes_fruits.remove(index1);
                fl.removeView(view);
                mon_manager.getPartie().incrementerScore();
            }

            index2 = mon_manager.getCollisionneur().rateFruit();

            if (index2 != -1) {
                mon_manager.getPlateau().getLesFruits().remove(index2);
                ImageView view = mes_fruits.remove(index2);
                fl.removeView(view);
                int indexVie = mon_manager.getPartie().perdreUneVie();
                lesCoeurs[indexVie].setImageResource(R.drawable.coeur_gris);
                if (mon_manager.getPartie().aPerdu()) {
                    perdre();
                }
            }

            score.setText(String.valueOf(mon_manager.getPartie().getScore()));
        });
    }

    /**
     * Permet la création d'un fruit et ajoute l'ImageView au layout.
     */
    public void creerFruit() {
        ImageView nouveau_fruit = new ImageView(this);
        if ((new Random()).nextInt(3) == 2) {
            nouveau_fruit.setImageResource(R.drawable.ananas);
        } else nouveau_fruit.setImageResource(R.drawable.banane);
        Fruit fruit_courant = (Fruit)mon_manager.getPlateau().getLesFruits().get(mon_manager.getPlateau().getLesFruits().size() - 1);
        nouveau_fruit.setX((float) fruit_courant.getPosX());
        nouveau_fruit.setY((float) fruit_courant.getPosY());
        fl.addView(nouveau_fruit);
        nouveau_fruit.getLayoutParams().width = 125;
        nouveau_fruit.getLayoutParams().height = 250;
        mes_fruits.add(nouveau_fruit);
    }

    /**
     * Permet d'afficher une PopUp qui indique au joueur qu'il a perdu et sauvegarde le score.
     */
    public void perdre() {
        String affichageScore = mon_manager.getPartie().getScore() + " points";
        scoreFinal.setText(affichageScore);
        popupPerdu.setVisibility(View.VISIBLE);
        try {
            mon_manager.finPartie(openFileOutput(mon_manager.NAME_FILE, MODE_PRIVATE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mon_manager.getBoucleur().setRunning(false);
        for (ImageView fruit : mes_fruits) {
            fl.removeView(fruit);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mon_manager.getBoucleur().setRunning(false);
        for (ImageView fruit : mes_fruits) {
            fl.removeView(fruit);
        }
        mes_fruits.clear();
    }

    /**
     * Permet de récupèrer le manager.
     * @return le manager.
     */
    public static Manager getMon_manager() {
        return mon_manager;
    }
}
