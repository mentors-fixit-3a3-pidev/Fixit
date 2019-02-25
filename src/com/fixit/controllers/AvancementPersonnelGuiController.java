/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AvancementPersonnelGuiController implements Initializable {

    @FXML
    private Button mesprestation;
    @FXML
    private Button mesmessage;
    @FXML
    private Button monavancement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mesmessage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/fixit/gui/MessagesGui.fxml"));
                    Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewOpportunityScene);
                } catch (IOException ex) {
                    Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            mesprestation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/fixit/gui/PrestationsGui.fxml"));
                    Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewOpportunityScene);
                } catch (IOException ex) {
                    Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
              monavancement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/fixit/gui/AvancementPersonnelGui.fxml"));
                    Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewOpportunityScene);
                } catch (IOException ex) {
                    Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }    
    
}
