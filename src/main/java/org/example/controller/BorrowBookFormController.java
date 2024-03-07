package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class BorrowBookFormController {

    @FXML
    private Pane BooksDetailsPane;

    @FXML
    private Pane BorrowBookPane;

    @FXML
    private AnchorPane subRoot;

    public void initialize(){
        BooksDetailsPane.setVisible(false);
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {
        BorrowBookPane.setVisible(false);
    }

}


