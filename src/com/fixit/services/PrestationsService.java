/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Prestations;
import com.fixit.util.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author dell
 */
public class PrestationsService implements PrestationsServiceInterface {

    @Override
    public void addPrestation(Prestations p) throws SQLException {
         ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
         String query="INSERT INTO `prestations` (`id_prestation` , `id_client`, `id_prestataire` , `id_sous_catégorie` , `date_prestation` , `état_prestation` , `nom_prestation` , `description_prestation` , `prix`) VALUES (?,?,?,?,?,?,?,?,?)";
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, p.getId_prestation());
                st.setInt(2,p.getClient().getId());
                st.setInt(3,p.getPrestataire().getId());
                st.setInt(4,p.getId_sous_catégorie());
                java.sql.Date date = new java.sql.Date(p.getDate_prestation().getTime());
                st.setDate(5,date);
                st.setInt(6,p.getÉtat_prestation());
                st.setString(7,p.getNom_prestation());
                st.setString(8,p.getDescription_prestation());
                st.setInt(9, p.getPrix());
                st.execute();
            
    }
 
     @Override
    public ObservableList<Prestations> listerPrestations(int id) throws SQLException {


                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `prestations`,`fos_users` WHERE ((prestations.id_prestataire=fos_users.id) AND (prestations.id_prestataire="+id+"))";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Prestations> lp = new ArrayList<Prestations>();
                
                userService us = new userService();
                while(rs.next()){
                    Prestations p = new Prestations();
                    p.setId_prestation(rs.getInt("id_prestation"));
                    p.setClient(us.get_user_by_id(rs.getInt("id_client")));
                    p.setPrestataire(us.get_user_by_id(rs.getInt("id_prestataire")));
                    p.setId_sous_catégorie(rs.getInt("id_sous_catégorie"));
                    p.setDate_prestation(rs.getDate("date_prestation"));
                    p.setÉtat_prestation(rs.getInt("état_prestation"));
                    p.setNom_prestation(rs.getString("nom_prestation"));
                    p.setDescription_prestation(rs.getString("description_prestation"));
                    p.setPrix(rs.getInt("prix"));
                    lp.add(p);
                }
                ObservableList lp_final = FXCollections.observableArrayList(lp);
                return lp_final;
    }
    @Override
    public void deletePrestation(int id_prestation) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `prestations` WHERE `id_prestation` = "+id_prestation;
		PreparedStatement st  = cn.prepareStatement(query); 
                st.execute();


    }
    @Override
    public void updatePrestation(Prestations p) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `prestations` SET `id_client`=?,`id_prestataire`=?,`id_sous_catégorie`=?,`date_prestation`=?,`état_prestation`=?,`nom_prestation`=?,`description_prestation`=?,`prix`=? WHERE `id_prestation` = "+p.getId_prestation();
		PreparedStatement st  = cn.prepareStatement(query);
                
                st.setInt(1, p.getClient().getId());
                st.setInt(2, p.getPrestataire().getId());
                st.setInt(3, p.getId_sous_catégorie());
                java.util.Date d1 = new java.util.Date();
                java.sql.Date d2 = new java.sql.Date(d1.getTime());
                st.setDate(4,d2);
                st.setInt(5,p.getÉtat_prestation());
                st.setString(6,p.getNom_prestation());
                st.setString(7,p.getDescription_prestation());
                st.setInt(8, p.getPrix());
                st.execute();

    }


}
