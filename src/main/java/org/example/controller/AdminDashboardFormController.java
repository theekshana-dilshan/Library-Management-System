package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.File;

import static java.awt.Color.blue;

public class AdminDashboardFormController {

    @FXML
    private Pane DashBoardIconPane;

    @FXML
    private Pane UsersIconPane;

    @FXML
    private Pane booksIconPane;

    @FXML
    private Pane branchesIconPane;

    @FXML
    private ImageView imgBooks;

    @FXML
    private ImageView imgBranches;

    @FXML
    private ImageView imgDashBoard;

    @FXML
    private ImageView imgUsers;

    @FXML
    private Label lblBooks;

    @FXML
    private Label lblBranches;

    @FXML
    private Label lblDashBoard;

    @FXML
    private Label lblUsers;

    public void initialize(){
        imgDashBoardFocused();
    }

    @FXML
    void lblBooksOnAction(MouseEvent event) {
        imgBooksFocused();
        imgUsersDefault();
        imgDashBoardDefault();
        imgBranchesDefault();
    }

    @FXML
    void lblBranchesOnAction(MouseEvent event) {
        imgBranchesFocused();
        imgDashBoardDefault();
        imgUsersDefault();
        imgBooksDefault();
    }

    @FXML
    void lblDashBoardOnAction(MouseEvent event) {
        imgDashBoardFocused();
        imgUsersDefault();
        imgBooksDefault();
        imgBranchesDefault();
    }

    @FXML
    void lblUsersOnAction(MouseEvent event) {
        imgDashBoardDefault();
        imgUsersFocused();
        imgBooksDefault();
        imgBranchesDefault();
    }

    void setImageToImageView(ImageView imageView, String imagePath) {
        File file = new File(imagePath);

        if (file.exists()) {
            Image image = new Image(file.toURI().toString());

            imageView.setImage(image);
        } else {
            System.out.println("Image file not found: " + imagePath);
        }
    }

    void imgDashBoardDefault (){
        lblDashBoard.setStyle("-fx-text-fill: #000000;");

        setImageToImageView(imgDashBoard, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-dashboard-48 (2).png");
    }

    void imgDashBoardFocused (){
        lblDashBoard.setStyle("-fx-text-fill: #1479ff;");

        setImageToImageView(imgDashBoard, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-dashboard-48 (3).png");
    }

    void imgUsersDefault(){
        lblUsers.setStyle("-fx-text-fill: #000000;");
        setImageToImageView(imgUsers, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-users-30.png");
    }

    void imgUsersFocused(){
        lblUsers.setStyle("-fx-text-fill: #1479ff;");
        setImageToImageView(imgUsers, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-users-30 (1).png");
    }

    void imgBooksDefault(){
        lblBooks.setStyle("-fx-text-fill: #000000;");
        setImageToImageView(imgBooks, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-books-24.png");
    }

    void imgBooksFocused(){
        lblBooks.setStyle("-fx-text-fill: #1479ff;");
        setImageToImageView(imgBooks, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-books-24 (1).png");
    }

    void imgBranchesDefault(){
        lblBranches.setStyle("-fx-text-fill: #000000;");
        setImageToImageView(imgBranches, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-houses-50.png");
    }

    void imgBranchesFocused(){
        lblBranches.setStyle("-fx-text-fill: #1479ff;");
        setImageToImageView(imgBranches, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-houses-50 (1).png");
    }
}