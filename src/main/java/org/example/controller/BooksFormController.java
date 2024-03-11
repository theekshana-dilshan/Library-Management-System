package org.example.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.example.bo.BOFactory;
import org.example.bo.custom.BooksBO;
import org.example.dto.BooksDTO;
import org.example.entity.Branches;
import org.example.tm.booksTm;

import java.util.ArrayList;
import java.util.List;

public class BooksFormController {

    @FXML
    private JFXComboBox<String> cmbGenre;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colAvailability;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colRemove;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private TableView<?> tblBooks;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtTitle;

    private BooksBO booksBO= (BooksBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.BOOKS);

    private ObservableList<booksTm> obList;

    public void initialize(){
        setCellValue();
        setComboBoxItems();
    }

    private void setCellValue() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if(isEmptyCheck()){
            Image image=new Image("/assests/icons/icons8-cancel-50.png");
            try {
                Notifications notifications=Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Value is empty! Please enter all values");
                notifications.title("Warning");
                notifications.hideAfter(Duration.seconds(5));
                notifications.position(Pos.TOP_RIGHT);
                notifications.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            String value = "Available";
            boolean available;
            if (value.equals("available")){
                available = true;
            }else {
                available=false;
            }

            List<Branches> branches=new ArrayList<>();

            boolean b = booksBO.addBook(new BooksDTO(txtBookId.getText(), txtTitle.getText(), txtAuthor.getText(),
                    cmbGenre.getValue(), available));

            if (b){
                Image image=new Image("/assests/icons/iconsOk.png");
                try {
                    Notifications notifications=Notifications.create();
                    notifications.graphic(new ImageView(image));
                    notifications.text("Book add success");
                    notifications.title("success");
                    notifications.hideAfter(Duration.seconds(5));
                    notifications.position(Pos.TOP_RIGHT);
                    notifications.show();
                }catch (Exception e){
                    e.printStackTrace();
                }

                /*getAllBooks();*/
                clearField();
                System.out.println("book add success");
            }
        }
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

        String romance = "Romance";
        String mystery = "Mystery";
        String fantasy = "Fantasy";
        String science = "Science";
        String thriller = "Thriller";
        String horror = "Horror";
        String youngAdult = "Young Adult";
        String children = "Children's";
        String inspirational = "Inspirational";
        String selfHelp = "Self-help";
        String religious = "Religious";
        String biography = "Biography";
        String autobiography = "Autobiography";
        String memoir = "Memoir";

        obList.add(romance);
        obList.add(mystery);
        obList.add(fantasy);
        obList.add(science);
        obList.add(thriller);
        obList.add(horror);
        obList.add(youngAdult);
        obList.add(children);
        obList.add(inspirational);
        obList.add(selfHelp);
        obList.add(religious);
        obList.add(biography);
        obList.add(autobiography);
        obList.add(memoir);

        cmbGenre.setItems(obList);
    }

    private boolean isEmptyCheck() {

        if(txtTitle.getText().isEmpty()){
            txtTitle.requestFocus();
            txtTitle.setFocusColor(Color.RED);
            System.out.println("Book title field is empty");
            /*Alert alert = new Alert(Alert.AlertType.ERROR, "Fill All fields");
            alert.showAndWait();*/
            return true;
        }
        if(txtAuthor.getText().isEmpty()){
            txtAuthor.requestFocus();
            txtAuthor.setFocusColor(Color.RED);
            System.out.println("Book author field is empty");
            /*Alert alert = new Alert(Alert.AlertType.ERROR, "Fill All fields");
            alert.showAndWait();*/
            return true;
        }
        if (cmbGenre.getValue().isEmpty()){
            cmbGenre.requestFocus();
            cmbGenre.setFocusColor(Color.RED);
            System.out.println("Book genre field is empty");
            /*Alert alert = new Alert(Alert.AlertType.ERROR, "Fill All fields");
            alert.showAndWait();*/
            return true;
        }
        return false;
    }

    public void clearField(){
        txtTitle.clear();
        txtAuthor.clear();
        cmbGenre.setValue("Select genre");
    }

}
