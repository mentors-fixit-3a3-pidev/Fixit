/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.Prestations;
import com.fixit.services.Sendingmail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class PrestationsCellGuiController extends ListCell<Prestations> {

    @FXML
    private AnchorPane gridPane;
   
    private FXMLLoader mLLoader;
    @FXML
    private Label dateprestation;
    @FXML
    private Label nomclient;
    @FXML
    private Label prix;
    @FXML
    private Label titles;
    @FXML
    private Button contacter;
    @FXML
    private Button details;

    /**
     * Initializes the controller class.
     */
    @Override
    protected void updateItem(Prestations student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/com/fixit/gui/PrestationsCellGui.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            nomclient.setText(student.getClient().getFirst_name()+" "+ student.getClient().getLast_name());
            dateprestation.setText(student.getDate_prestation().toString());
            prix.setText(String.valueOf(student.getPrix()));

            

            details.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                   
                    PrestationsGuiController.data_details.removeAll(PrestationsGuiController.data_details);
                    PrestationsGuiController.data_details.add(student);
                    Parent tableViewPrestations;
                        try {
                            tableViewPrestations = FXMLLoader.load(getClass().getResource("/com/fixit/gui/PrestationsGui.fxml"));
                            Scene tableViewContractScene = new Scene(tableViewPrestations);
                            Stage window = (Stage) ((Node) t.getSource()).getScene().getWindow();
                            window.setScene(tableViewContractScene);
                        } catch (IOException ex) {
                            
                        }
                    

                    
                    

                }

            }
                    
            );
            
            
        };
    
        setText(null);
        setGraphic(gridPane);
    }

    

    
}
