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

public class MeciuriController2 {

	@FXML
	private TextField refereeNameText;
	@FXML
	private TextField scoreText;
	
	@FXML
    private TextArea resultArea;
	
	@FXML
    private TableView matchesTable;
	
    @FXML
    private TableColumn<Meciuri, Integer>  nrMeciColumn;
    @FXML
    private TableColumn<Meciuri, String>  p1Column;
    @FXML
    private TableColumn<Meciuri, String> p2Column;
    @FXML
    private TableColumn<Meciuri, String> fazaColumn;
    @FXML
    private TableColumn<Meciuri, String> ziuaColumn;
    @FXML
    private TableColumn<Meciuri, Integer> terenColumn;
    @FXML
    private TableColumn<Meciuri, String> arbitruColumn;
    @FXML
    private TableColumn<Meciuri, String> scorColumn;
    
  //Search a match 
    @FXML
    private void searchMatch (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Match information
            Meciuri m = MeciuriDAO.searchMatch2(refereeNameText.getText());
            //Populate Match on TableView and Display on TextArea
            populateAndShowMatch(m);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting show information from DB.\n" + e);
            throw e;
        }
    }

    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
       
    	nrMeciColumn.setCellValueFactory(cellData -> cellData.getValue().matchNoProperty().asObject());
    	p1Column.setCellValueFactory(cellData -> cellData.getValue().p1NameProperty());
    	p2Column.setCellValueFactory(cellData -> cellData.getValue().p2NameProperty());
    	fazaColumn.setCellValueFactory(cellData -> cellData.getValue().phaseProperty());
    	ziuaColumn.setCellValueFactory(cellData -> cellData.getValue().dayProperty());
    	terenColumn.setCellValueFactory(cellData -> cellData.getValue().courtNoProperty().asObject());
    	arbitruColumn.setCellValueFactory(cellData -> cellData.getValue().refereeProperty());
    	scorColumn.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());
    }
    
    //Populate Match
    @FXML
    private void populateMatch (Meciuri m) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Meciuri> matchData = FXCollections.observableArrayList();
        //Add match to the ObservableList
        matchData.add(m);
        //Set items to the matchesTable
        matchesTable.setItems(matchData);
    }
    
    //Set Matches information to Text Area
    @FXML
    private void setMatchInfoToTextArea (Meciuri m) {
        resultArea.setText("Nr_meci: " + m.getMatchNo() + "\n" +"Jucator1: " + m.getP1Name() + "\n" + "Jucator2: " + m.getP2Name() + "\n" + "Faza: " + m.getPhase() + "\n" + "Ziua: " + m.getDay() + "\n" + "Teren: " + m.getCourtNo() + "\n" + "Arbitru: " + m.getReferee() + "\n" + "Scor:" + m.getScore());
    }
    
    //Populate Match for TableView and Display Match on TextArea
    @FXML
    private void populateAndShowMatch(Meciuri m) throws ClassNotFoundException {
        if (m != null) {
            populateMatch(m);
            setMatchInfoToTextArea(m);
        } else {
            resultArea.setText("This match does not exist!\n");
        }
    }
    
    //Populate Matches for TableView
    @FXML
    private void populateMatches (ObservableList<Meciuri> matchData) throws ClassNotFoundException {
        //Set items to the matchesTable
    	matchesTable.setItems(matchData);
    }
    
    //Modify score
    @FXML
    private void modifyScore (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
        	MeciuriDAO.updateMatchScore(refereeNameText.getText(),scoreText.getText());
            resultArea.setText("The score was modified: " + scoreText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while modify the score: " + e);
        }
    }
}
