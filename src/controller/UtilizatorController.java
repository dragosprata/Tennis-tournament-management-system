package controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Meciuri;
import model.Utilizator;

public class UtilizatorController {

	@FXML
	private TextField newNameTextField;
	@FXML
	private TextField newUsernameTextField;
	@FXML
	private TextField newPasswordTextField;
	@FXML
	private TextField userTextField;
	
	@FXML
    private TextArea resultArea;
	
	@FXML
    private TableView usersTable;
	
    @FXML
    private TableColumn<Utilizator, String>  numeColumn;
    @FXML
    private TableColumn<Utilizator, String>  usernameColumn;
    
    
  //Search a user
    @FXML
    private void searchUser (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get User information
            Utilizator u = UtilizatorDAO.searchUser(userTextField.getText());
            //Populate User on TableView and Display on TextArea
            populateAndShowUser(u);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting user information from DB.\n" + e);
            throw e;
        }
    }
    
  //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
       
    	numeColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    	usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
    }
    
    //Populate User
    @FXML
    private void populateUser (Utilizator u) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Utilizator> userData = FXCollections.observableArrayList();
        //Add user to the ObservableList
        userData.add(u);
        //Set items to the matchesTable
        usersTable.setItems(userData);
    }
    
    //Set Users information to Text Area
    @FXML
    private void setUserInfoToTextArea (Utilizator u) {
        resultArea.setText("Nume: " + u.getName() + "\n" +"Username: " + u.getUsername() + "\n");
    }
    
    //Populate User for TableView and Display User on TextArea
    @FXML
    private void populateAndShowUser(Utilizator u) throws ClassNotFoundException {
        if (u != null) {
            populateUser(u);
            setUserInfoToTextArea(u);
        } else {
            resultArea.setText("This user does not exist!\n");
        }
    }
    
    //Insert a user to the DB
    @FXML
    private void insertUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
        	UtilizatorDAO.insertUser(newNameTextField.getText(),newUsernameTextField.getText(),newPasswordTextField.getText());
            resultArea.setText("User inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting user " + e);
            throw e;
        }
    }
}
