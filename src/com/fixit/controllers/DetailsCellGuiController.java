/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.Prestations;
import com.itextpdf.text.Document;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class DetailsCellGuiController extends ListCell<Prestations> {
  @FXML
    private AnchorPane gridPane;
    @FXML
    private Label nomclient;
    @FXML
    private Label catégorie;
    @FXML
    private Label date;
    @FXML
    private Label etat;
    @FXML
    private Label prix;
    @FXML
    private Label description;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button extraire;
    private FXMLLoader mLLoader;
    private static String FILE = "C:/Users/dell/Desktop/Fixit/testpdf.pdf";
    

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
                mLLoader = new FXMLLoader(getClass().getResource("/com/fixit/gui/DetailsCellGui.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            nomclient.setText(student.getClient().getFirst_name()+" "+ student.getClient().getLast_name());
            date.setText(student.getDate_prestation().toString());
            prix.setText(String.valueOf(student.getPrix()));
            catégorie.setText(String.valueOf(student.getId_sous_catégorie()));
            description.setText(student.getDescription_prestation());
            if(student.getÉtat_prestation()==0)
            {
            etat.setText("Pas encore traitée");
            }
            else
            {
            etat.setText("traitée");
            }    


            

           
            
        };
        
        
 
        setText(null);
        setGraphic(gridPane);
    }

    

    
}
