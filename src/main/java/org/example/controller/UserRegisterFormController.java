package org.example.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserRegisterFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtPasswordReEnter;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void btnSignupOnAction(ActionEvent event) {

    }

    @FXML
    void lblAdminLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/AdminLoginForm.fxml");
    }

    @FXML
    void lblLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserLoginForm.fxml");
    }

    @FXML
    void lblReaderLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserLoginForm.fxml");
    }

    public void setUI (AnchorPane pane, String location) throws IOException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(getClass().getResource(location)));
    }

}
