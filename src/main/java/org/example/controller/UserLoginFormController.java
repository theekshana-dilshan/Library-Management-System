package org.example.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserLoginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

    }

    @FXML
    void lblAdminLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/AdminLoginForm.fxml");
    }

    @FXML
    void lblRegisterOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserRegisterForm.fxml");
    }

    public void setUI (AnchorPane pane, String location) throws IOException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(getClass().getResource(location)));
    }
}