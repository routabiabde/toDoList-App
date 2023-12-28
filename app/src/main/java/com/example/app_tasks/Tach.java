package com.example.app_tasks;

import java.io.Serializable;
import java.util.Date;

public class Tach implements Serializable {
    private String title,description;
    private Etat etat = Etat.EnCours;
    private String date;

    public Tach(String title, String description, Etat etat, String date){
        this.title = title;
        this.description = description;
        this.etat = etat;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Etat getEtat() {
        return etat;
    }

    public String getDate() {
        return date;
    }
}
