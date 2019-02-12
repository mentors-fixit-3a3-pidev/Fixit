/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.entities;

import java.sql.Date;
import java.util.Objects;

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

    public Prestations(int id_client, int id_prestataire, int id_sous_catégorie, Date date_prestation, int état_prestation, String nom_prestation, String description_prestation, int prix) {
        this.id_client = id_client;
        this.id_prestataire = id_prestataire;
        this.id_sous_catégorie = id_sous_catégorie;
        this.date_prestation = date_prestation;
        this.état_prestation = état_prestation;
        this.nom_prestation = nom_prestation;
        this.description_prestation = description_prestation;
        this.prix = prix;
    }

    

    public Prestations(int id_prestation, int id_client, int id_prestataire, int id_sous_catégorie, Date date_prestation, int état_prestation, String nom_prestation, String description_prestation, int prix) {
        this.id_prestation = id_prestation;
        this.id_client = id_client;
        this.id_prestataire = id_prestataire;
        this.id_sous_catégorie = id_sous_catégorie;
        this.date_prestation = date_prestation;
        this.état_prestation = état_prestation;
        this.nom_prestation = nom_prestation;
        this.description_prestation = description_prestation;
        this.prix = prix;
    }

    public Prestations() {
    }

   
    

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

    @Override
    public String toString() {
        return "Prestations{" + "id_prestation=" + id_prestation + ", id_client=" + id_client + ", id_prestataire=" + id_prestataire + ", id_sous_cat\u00e9gorie=" + id_sous_catégorie + ", date_prestation=" + date_prestation + ", \u00e9tat_prestation=" + état_prestation + ", nom_prestation=" + nom_prestation + ", description_prestation=" + description_prestation + ", prix=" + prix + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestations other = (Prestations) obj;
        if (this.id_prestation != other.id_prestation) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (this.id_prestataire != other.id_prestataire) {
            return false;
        }
        if (this.id_sous_catégorie != other.id_sous_catégorie) {
            return false;
        }
        if (this.état_prestation != other.état_prestation) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (!Objects.equals(this.nom_prestation, other.nom_prestation)) {
            return false;
        }
        if (!Objects.equals(this.description_prestation, other.description_prestation)) {
            return false;
        }
        if (!Objects.equals(this.date_prestation, other.date_prestation)) {
            return false;
        }
        return true;
    }
    
    
}
