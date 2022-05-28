package com.example.javafxdatabasemaven;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.ICatalogueMetierImpl;
import metier.Produit;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {

    @FXML
    private TextField fieldMC;
    @FXML
    private Button Research;
    @FXML
    private TableView<Produit> productsTable;
    @FXML
    private TableColumn<Produit,Integer> IDcolumn;
    @FXML
    private TableColumn<Produit,String > Namecolumn;
    @FXML
    private TableColumn<Produit,Double> Prixcolumn;
    @FXML
    private TableColumn<Produit,Integer> Quantitecolumn;

    ObservableList<Produit>observableList= FXCollections.observableArrayList();

    private ICatalogueMetierImpl tableProd;

    public void initialize(URL location, ResourceBundle resources)
    {
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
        Namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Prixcolumn.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        Quantitecolumn.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        tableProd=new ICatalogueMetierImpl();
        observableList.addAll(tableProd.AllProduits());
        productsTable.setItems(observableList);
    }

    public void Rechercher() {
        tableProd=new ICatalogueMetierImpl();
        List<Produit> pr=tableProd.ProduitsMC(fieldMC.getText());
        observableList.clear();
        observableList.addAll(pr);
    }
}