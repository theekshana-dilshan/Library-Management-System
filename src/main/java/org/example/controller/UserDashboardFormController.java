package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.example.bo.BOFactory;
import org.example.bo.custom.BooksBO;
import org.example.dto.BooksDTO;
import org.example.tm.OurBooksTm;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private Label lblDate;

    @FXML
    private AnchorPane root;

    @FXML
    private Pane statusPane;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private TableView<OurBooksTm> tblBooks;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private Pane topReaderPane;

    private BooksBO booksBO= (BooksBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.BOOKS);

    private ObservableList<OurBooksTm> obList;

    public void initialize(){
        imgDashBoardFocused();
        setShadowsToPanes();
        setDate();
        setCellValue();
        loadAllBooks();
    }

    private void setCellValue() {
        colBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
    }

    public void loadAllBooks(){
        obList= FXCollections.observableArrayList();
        List<BooksDTO> allBooks = booksBO.getAllBooks();
        List<String> suggestionList = new ArrayList<>();

        for (BooksDTO dto: allBooks){
            suggestionList.add(String.valueOf(dto.getId()));


            obList.add(new OurBooksTm(
                    dto.getTitle()
            ));
        }

        tblBooks.setItems(obList);
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

    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

}
