/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.entities;

import java.sql.Date;

/**
 *
 * @author dell
 */
public class Prestations {
    private int id_prestation ;
    private int id_client ;
    private int id_prestataire ;
    private int id_sous_catégorie ;
    private Date date_prestation;
    private int état_prestation ;
    private String nom_prestation ;
    private String description_prestation ;
    private int prix ;

    public int getId_prestation() {
        return id_prestation;
    }

    public void setId_prestation(int id_prestation) {
        this.id_prestation = id_prestation;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_prestataire() {
        return id_prestataire;
    }

    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }

    public int getId_sous_catégorie() {
        return id_sous_catégorie;
    }

    public void setId_sous_catégorie(int id_sous_catégorie) {
        this.id_sous_catégorie = id_sous_catégorie;
    }

    public Date getDate_prestation() {
        return date_prestation;
    }

    public void setDate_prestation(Date date_prestation) {
        this.date_prestation = date_prestation;
    }

    public int getÉtat_prestation() {
        return état_prestation;
    }

    public void setÉtat_prestation(int état_prestation) {
        this.état_prestation = état_prestation;
    }

    public String getNom_prestation() {
        return nom_prestation;
    }

    public void setNom_prestation(String nom_prestation) {
        this.nom_prestation = nom_prestation;
    }

    public String getDescription_prestation() {
        return description_prestation;
    }

    public void setDescription_prestation(String description_prestation) {
        this.description_prestation = description_prestation;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
}
