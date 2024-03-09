package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class UserFormController {

    @FXML
    private Pane bookDetailsPane;

    @FXML
    private Pane selectUserFromTablePane01;

    @FXML
    private Pane selectUserFromTablePane02;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private Pane userDetailsPane;

    public void initialize(){
        setShadowsToPanes();

        selectUserFromTablePane01.setVisible(false);
        selectUserFromTablePane02.setVisible(false);
    }

    void setShadowsToPanes(){
        userDetailsPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        bookDetailsPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
    }

}

