/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.user;
import com.fixit.util.ConnectionDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehdi
 */
public class userService {

    Connection cnx;

    public userService() {
        this.cnx = ConnectionDb.getInstance().getCnx();
    }

    public void ajouterAlaBase(user p) throws SQLException {
        try {
            System.out.println("connexion établie");
            Statement stm = cnx.createStatement();
            String req = "INSERT INTO `fos_users`(`username`,`email`,`password` ,`roles`,`first_name`,`last_name`,`birth_date`,`address`,`phone`) VALUES ('" + p.getUsername() + "','" + p.getEmail() + "','" + p.getPassword() + "','" + p.getRoles() + "','" + p.getFirst_name() + "','" + p.getLast_name() + "','" + p.getBirth_date() + "','" + p.getAddress() + "','" + p.getPhone() + "',)";
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet chercherDansLaBase(String nom, String prenom) throws SQLException {

        Statement stm = cnx.createStatement();
        String req = "select * from fos_users where first_name='" + nom + "'and last_name='" + prenom + "'";
        ResultSet rs = stm.executeQuery(req);
        return rs;
    }

    public void supprimerDeLaBase(int id) throws SQLException {

        try {
            Statement stm = cnx.createStatement();
            String query = "delete from fos_users where id='" + id + "'";

            System.out.println(stm);
            stm.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void modifierNom(int id, String nom) {

        try {
            String query = "UPDATE fos_user SET first_name='" + nom + "' WHERE id='" + id + "'";
            Statement stm = cnx.createStatement();

            System.out.println(stm);
            stm.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
