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
import model.Arbitri;

public class ArbitriController {
	
	@FXML
	private TextField numeText;
	@FXML
	private TextField refereeNameText;
	@FXML
	private TextField courtNumberText;
	@FXML
    private TextArea resultArea;
	
	@FXML
    private TableView refereesTable;
	
    @FXML
    private TableColumn<Arbitri, Integer>  idColumn;
    @FXML
    private TableColumn<Arbitri, String>  numeColumn;
    @FXML
    private TableColumn<Arbitri, Integer> nrTerenColumn;
    
  //Search a referee after name
    @FXML
    private void searchReferee (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Referee information
            Arbitri a = ArbitriDAO.searchReferee(refereeNameText.getText());
            //Populate Referee on TableView and Display on TextArea
            populateAndShowReferee(a);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting show information from DB.\n" + e);
            throw e;
        }
    }
    
    //Search all referees
    @FXML
    private void searchReferees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Referees information
            ObservableList<Arbitri> refereeData = ArbitriDAO.searchReferees();
            //Populate Referees on TableView
            populateReferees(refereeData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting shows information from DB.\n" + e);
            throw e;
        }
    }

    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
       
    	idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
    	numeColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    	nrTerenColumn.setCellValueFactory(cellData -> cellData.getValue().courtNoProperty().asObject());
    }
    
    //Populate Referee
    @FXML
    private void populateReferee (Arbitri a) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Arbitri> refereeData = FXCollections.observableArrayList();
        //Add referee to the ObservableList
        refereeData.add(a);
        //Set items to the refereesTable
        refereesTable.setItems(refereeData);
    }
    
    //Set Referees information to Text Area
    @FXML
    private void setRefereesInfoToTextArea (Arbitri a) {
        resultArea.setText("ID: " + a.getID() + "\n" +"Nume: " + a.getName() + "\n" + "Numar teren: " + a.getCourtNo());
    }
    
    //Populate Referee for TableView and Display Referee on TextArea
    @FXML
    private void populateAndShowReferee(Arbitri a) throws ClassNotFoundException {
        if (a != null) {
            populateReferee(a);
            setRefereesInfoToTextArea(a);
        } else {
            resultArea.setText("This referee does not exist!\n");
        }
    }
    
    //Populate Referees for TableView
    @FXML
    private void populateReferees (ObservableList<Arbitri> refereesData) throws ClassNotFoundException {
        //Set items to the refereesTable
    	refereesTable.setItems(refereesData);
    }
    
    //Insert a referee to the DB
    @FXML
    private void insertReferee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
        	ArbitriDAO.insertReferee(numeText.getText());
            resultArea.setText("Referee inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting referee " + e);
            throw e;
        }
    }
    
    //Distribution of referees on the courts
    @FXML
    private void shareReferees (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
        	ArbitriDAO.updateRefereeCourtNo(refereeNameText.getText(),courtNumberText.getText());
            resultArea.setText("The referee with name: " + refereeNameText.getText() + " was placed on the court number: " + courtNumberText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while share the referee: " + e);
        }
    }
    
    //Remove a referee with a given name from DB
    @FXML
    private void deleteReferee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ArbitriDAO.deleteRefereeWithName(refereeNameText.getText());
            resultArea.setText("Referee removed! Referee name: " + refereeNameText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while removing referee " + e);
            throw e;
        }
    }

}
