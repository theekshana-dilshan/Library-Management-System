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
    private Pane bookDetailsPaneParent;

    @FXML
    private Pane borrowBookPaneParent;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private Pane tablePane;

    public void initialize(){
        setShadowsToPanes();

        BooksDetailsPane.setVisible(false);
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {
        BorrowBookPane.setVisible(false);
    }

    void setShadowsToPanes(){
        tablePane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        bookDetailsPaneParent.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        borrowBookPaneParent.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
    }

}


