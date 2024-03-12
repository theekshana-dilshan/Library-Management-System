package org.example.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;
import org.example.bo.BOFactory;
import org.example.bo.custom.BooksBO;
import org.example.bo.custom.BranchesBO;
import org.example.dto.BooksDTO;
import org.example.dto.BranchesDTO;
import org.example.entity.Branches;
import org.example.tm.BooksTm;
import org.example.tm.BorrowBookTm;
import org.example.tm.BranchesTm;
import org.example.tm.OurBooksTm;

import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookFormController {

    public CheckBox checkBoxAcceptTerms;
    public Label lblTodayDate;
    public DatePicker datePickerReturnDate;
    public JFXComboBox cmbBranchSelect;
    public Label lblAuthorOnBorrowBook;
    public Label lblgenreOnBorrowBook;
    public Label lblBookNameOnBorrowBook;
    @FXML
    private Pane BooksDetailsPane;

    @FXML
    private Pane BorrowBookPane;

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private JFXButton btnComfirm;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private Pane bookDetailsPaneParent;

    @FXML
    private Pane borrowBookPaneParent;

    @FXML
    private AnchorPane subRoot;

    @FXML
    private Pane tablePane;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblAvailableOrNot;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblGenre;

    @FXML
    private Label lblDate;

    @FXML
    private TableView<BorrowBookTm> tblBorrowBook;

    private BooksBO booksBO= (BooksBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.BOOKS);

    private ObservableList<BorrowBookTm> obList;

    private BranchesBO branchesBO= (BranchesBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.BRANCHES);

    public void initialize(){
        setShadowsToPanes();
        setDate();
        setCellValue();
        loadAllBooks();
        setCmbBranchSelect();
    }

    private void setCellValue() {
        colName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    }

    public void loadAllBooks() {
        obList = FXCollections.observableArrayList();
        List<BooksDTO> allBooks = booksBO.getAllBooks();
        List<String> suggestionList = new ArrayList<>();

        for (BooksDTO dto : allBooks) {
            suggestionList.add(String.valueOf(dto.getId()));


            obList.add(new BorrowBookTm(
                    dto.getTitle(),
                    dto.getGenre()
            ));
        }

        tblBorrowBook.setItems(obList);
    }

    public void selectBookOnAction(javafx.scene.input.MouseEvent mouseEvent) {
        int focusedIndex = tblBorrowBook.getSelectionModel().getSelectedIndex();
        BorrowBookTm borrowBookTm = (BorrowBookTm) tblBorrowBook.getSelectionModel().getSelectedItem();

        if (borrowBookTm != null) {
            String bookName = borrowBookTm.getBookName();
            BooksDTO booksDTO = new BooksDTO();
            booksDTO = booksBO.getBookByTitle(bookName);

            lblBookName.setText(booksDTO.getTitle());
            lblGenre.setText(booksDTO.getGenre());
            lblAuthor.setText(booksDTO.getAuthor());

            boolean availability = booksDTO.isAvailability();
            String available = null;
            if (availability){
                available = "Available";
                lblAvailableOrNot.setText(available);
                lblAvailableOrNot.setStyle("-fx-text-fill: #00ff00");
                btnBorrow.setDisable(false);

            }else {
                available = "Not Available";
                lblAvailableOrNot.setText(available);
                lblAvailableOrNot.setStyle("-fx-text-fill: red");
                btnBorrow.setDisable(true);
            }
            BooksDetailsPane.setVisible(false);
            BorrowBookPane.setVisible(true);
        }
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {
        BorrowBookPane.setVisible(false);

        lblBookNameOnBorrowBook.setText(lblBookName.getText());
        lblgenreOnBorrowBook.setText(lblGenre.getText());
        lblAuthorOnBorrowBook.setText(lblAuthor.getText());
        lblTodayDate.setText(lblDate.getText());
    }

    void setShadowsToPanes(){
        tablePane.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        bookDetailsPaneParent.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
        borrowBookPaneParent.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, #a9cdfa, 10, 0, 0, 6); -fx-background-radius: 10px;");
    }

    public void btnComfirmOnAction(ActionEvent actionEvent) {

    }

    public void setCmbBranchSelect(){
        ObservableList<String> branchlist;
        branchlist= FXCollections.observableArrayList();
        List<BranchesDTO> allBranch = branchesBO.getAllBranch();

        for (BranchesDTO dto: allBranch){
            branchlist.add(dto.getLocation());
        }

        cmbBranchSelect.setItems(branchlist);
    }

    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }
}


