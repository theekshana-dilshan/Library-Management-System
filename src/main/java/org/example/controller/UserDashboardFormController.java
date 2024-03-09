package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class UserDashboardFormController {

    @FXML
    private Pane DashBoardIconPane;

    @FXML
    private Pane UsersIconPane1;

    @FXML
    private Pane UsersIconPane11;

    @FXML
    private ImageView imgBarrowBooks;

    @FXML
    private ImageView imgBarrowedBooks;

    @FXML
    private ImageView imgDashBoard;

    @FXML
    private Pane booksPane;

    @FXML
    private Pane helloPane;

    @FXML
    private Label lblBooks;

    @FXML
    private Label lblBooks1;

    @FXML
    private Label lblDashBoard;

    @FXML
    private AnchorPane root;

    @FXML
    private Pane statusPane;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private Pane topReaderPane;

    public void initialize(){
        imgDashBoardFocused();
        setShadowsToPanes();
    }

    public void btnBorrowABookOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        setUI(subRoot,"/view/BorrowBookForm.fxml");

        imgDashBoardDefault();
        imgBooksFocused();
        imgBarrowedBooksDefault();
    }

    @FXML
    void lblBarrowBooksOnAction(MouseEvent event) throws IOException {
        setUI(subRoot,"/view/BorrowBookForm.fxml");

        imgDashBoardDefault();
        imgBooksFocused();
        imgBarrowedBooksDefault();
    }

    @FXML
    void lblBarrowedBooksOnAction(MouseEvent event) throws IOException {
        setUI(subRoot,"/view/BorrowedBooksForm.fxml");

        imgDashBoardDefault();
        imgBooksDefault();
        imgBarrowedBooksFocused();
    }

    @FXML
    void lblDashBoardOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserDashboardForm.fxml");

        imgDashBoardFocused();
        imgBooksDefault();
        imgBarrowedBooksDefault();
    }

    public void setUI (AnchorPane pane, String location) throws IOException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(getClass().getResource(location)));
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

    void imgBooksDefault(){
        lblBooks.setStyle("-fx-text-fill: #000000;");
        setImageToImageView(imgBarrowBooks, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-books-24.png");
    }

    void imgBooksFocused(){
        lblBooks.setStyle("-fx-text-fill: #1479ff;");
        setImageToImageView(imgBarrowBooks, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-books-24 (1).png");
    }

    void imgBarrowedBooksDefault(){
        lblBooks1.setStyle("-fx-text-fill: #000000;");
        setImageToImageView(imgBarrowedBooks, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-books-24.png");
    }

    void imgBarrowedBooksFocused(){
        lblBooks1.setStyle("-fx-text-fill: #1479ff;");
        setImageToImageView(imgBarrowedBooks, "C:\\Users\\ASUS\\Documents\\GitHub\\Library-Management-System\\src\\main\\resources\\assests\\icons8-books-24 (1).png");
    }

    void setShadowsToPanes(){
        booksPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        statusPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        topReaderPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        helloPane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
    }

}
