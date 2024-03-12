package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class BorrowedBooksFormController {

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBorrowDate;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colReturn;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private Label lblReadingCount;

    @FXML
    private Label lblToReturnCount;

    @FXML
    private Label lblReadCount;

    @FXML
    private Label lblDate;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private TableView<?> tblBorrowedBooks;

    public void initialize(){
        setDate();
    }

    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

}
