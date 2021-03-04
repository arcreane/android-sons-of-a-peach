package fr.sons_of_a_peach.masterfruits;

import android.graphics.drawable.Drawable;

public class Fruits {

    private boolean withSeeds;
    private boolean peelable;
    private String nom;
    private int image;

    // Constructeur de la classe Compte
    public Fruits(String nom, boolean withSeeds, boolean peelable, int image){
        this.withSeeds = withSeeds;
        this.peelable = peelable;
        this.nom = nom;
        this.image = image;
    }



    public boolean isWithSeeds() {
        return withSeeds;
    }

    public void setWithSeeds(boolean withSeeds) {
        this.withSeeds = withSeeds;
    }

    public boolean isPeelable() {
        return peelable;
    }

    public void setPeelable(boolean peelable) {
        this.peelable = peelable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "withSeeds=" + withSeeds +
                ", peelable=" + peelable +
                ", nom='" + nom + '\'' +
                ", image " + image +
                '}';
    }
}
