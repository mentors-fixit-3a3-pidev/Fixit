/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.Message;
import com.fixit.entities.Prestations;
import com.fixit.entities.user;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    @FXML
    private TextField search;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PrestationsService ps = new PrestationsService();
        try {
            data = ps.listerPrestations(LoginController.session.getId());
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

    @FXML
    private void rechercher(ActionEvent event) {
    }
    public void initFilter() {
        FilteredList<Prestations> filteredData = new FilteredList<>(data, p -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(search -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if ((search.getClient().getFirst_name().toLowerCase().contains(lowerCaseFilter)) || (search.getClient().getLast_name().toLowerCase().contains(lowerCaseFilter))) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
        SortedList<Prestations> sortedData = new SortedList<>(filteredData);
        lists.setItems(sortedData);
        long s = filteredData.stream().count();
        search.setText(String.valueOf(s));

    }

    }    
    
    

