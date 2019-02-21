/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.Prestations;
import com.fixit.services.PrestationsService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class PrestationsGuiController implements Initializable {

    @FXML
    private ListView<Prestations> lists;
    ObservableList<Prestations> data;
    @FXML
    private ListView<Prestations> det;
    public static List<Prestations> data_details = new ArrayList<Prestations>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PrestationsService ps = new PrestationsService();
        try {
            data = ps.listerPrestations(1);
        } catch (SQLException ex) {
            Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lists.setItems(data);
        ObservableList<Prestations> li = FXCollections.observableArrayList(data_details);
        det.setItems(li);

        lists.setCellFactory(PrestationsListView -> new PrestationsCellGuiController());
        det.setCellFactory(PrestationsListView -> new DetailsCellGuiController());

        //initFilter();

    }
    }    
    
    

