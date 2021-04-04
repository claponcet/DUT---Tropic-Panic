package com.example.android_attrape_objet.boucleur;

import java.util.Observable;
import java.util.Observer;

public class Boucleur extends Observable implements Runnable{

    /**
     * Créer une variable running indiquant si le boucleur boucle ou pas.
     */
    private boolean running = false;

    /**
     * Cette méthode permet, tant que runing est a true, de boucler.
     */
    public void run(){

        while(running){
            setChanged();
            notifyObservers();
            try{
                Thread.sleep(80);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    /**
     * Peremet de savoir si le boucleur boucle
     * @return true si la boucle tourne, false sinon.
     */
    public boolean isRunning(){
        return running;
    }

    /**
     * permet de modifier l'attribut running du boucleur
     * @param running un booléen indiquant si la boucle doit tourner ou pas.
     */
    public void setRunning(boolean running) {
        this.running = running;
    }
}
