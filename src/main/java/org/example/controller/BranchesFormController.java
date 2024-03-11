package org.example.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class BranchesFormController {

    @FXML
    private JFXComboBox<String> cmbStatus;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colRemove;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private TableView<?> tblBranches;

    @FXML
    private JFXTextField txtBranchCode;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtLocation;

    @FXML
    private JFXTextField txtSearch;

    public void initialize(){
        setComboBoxItems();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    void setComboBoxItems(){
        ObservableList<String> obList = FXCollections.observableArrayList();

        String open = "Open";
        String close = "Close";

        obList.add(open);
        obList.add(close);

        cmbStatus.setItems(obList);
    }

}

