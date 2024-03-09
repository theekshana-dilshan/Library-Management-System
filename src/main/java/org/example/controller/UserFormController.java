/*package org.example.controller;

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

}*/

package org.example.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class UserFormController {

    @FXML
    private Pane bookDetailsPane;

    @FXML
    private CheckBox checkBoxNotify;

    @FXML
    private JFXComboBox<String> cmbBookName;

    @FXML
    private TableColumn<?, ?> colBooksToReturn;

    @FXML
    private TableColumn<?, ?> colBorrowedBooks;

    @FXML
    private TableColumn<?, ?> colDeleteUser;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private Label lblSetBooksToReturn;

    @FXML
    private Label lblSetDueDate;

    @FXML
    private Label lblSetEmail;

    @FXML
    private Label lblSetUserName;

    @FXML
    private Label lblSetUserNameOnBooksDetailsPane;

    @FXML
    private Pane selectUserFromTablePane01;

    @FXML
    private Pane selectUserFromTablePane02;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private TableView<?> tblUser;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private Pane userDetailsPane;

    public void initialize(){
        setShadowsToPanes();

        selectUserFromTablePane01.setVisible(false);
        selectUserFromTablePane02.setVisible(false);
    }

    @FXML
    void btnNotifyViaEmailOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveUserOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    void setShadowsToPanes(){
        userDetailsPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        bookDetailsPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
    }

}


