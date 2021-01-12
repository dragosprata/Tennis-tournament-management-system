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
import model.Jucator;

public class JucatorController {

	@FXML
	private TextField numeText;
	@FXML
	private TextField prenumeText;
	@FXML
	private TextField domiciliuText;
	@FXML
	private TextField echipamentText;
	@FXML
	private TextField clasamentText;
	@FXML
	private TextField meciuriText;
	@FXML
	private TextField puncteText;
	@FXML
	private TextField palmaresText;
	@FXML
	private TextField playerNameText;
	
	@FXML
    private TextArea resultArea;
	
	@FXML
    private TableView playersTable;
	
    @FXML
    private TableColumn<Jucator, Integer>  idColumn;
    @FXML
    private TableColumn<Jucator, String>  numeColumn;
    @FXML
    private TableColumn<Jucator, String> prenumeColumn;
    @FXML
    private TableColumn<Jucator, String> domiciliuColumn;
    @FXML
    private TableColumn<Jucator, String> echipamentColumn;
    @FXML
    private TableColumn<Jucator, Integer> clasamentColumn;
    @FXML
    private TableColumn<Jucator, Integer> meciuriColumn;
    @FXML
    private TableColumn<Jucator, Integer> puncteColumn;
    @FXML
    private TableColumn<Jucator, String> palmaresColumn;
    
    
  //Search a player after name
    @FXML
    private void searchPlayer (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Player information
            Jucator player = JucatorDAO.searchPlayer(playerNameText.getText());
            //Populate Player on TableView and Display on TextArea
            populateAndShowPlayer(player);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting show information from DB.\n" + e);
            throw e;
        }
    }
    
    //Search all players
    @FXML
    private void searchPlayers(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Players information
            ObservableList<Jucator> playerData = JucatorDAO.searchPlayers();
            //Populate Players on TableView
            populatePlayers(playerData);
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
    	prenumeColumn.setCellValueFactory(cellData -> cellData.getValue().prenumeProperty());
    	domiciliuColumn.setCellValueFactory(cellData -> cellData.getValue().residenceProperty());
    	echipamentColumn.setCellValueFactory(cellData -> cellData.getValue().equipmentProperty());
    	clasamentColumn.setCellValueFactory(cellData -> cellData.getValue().rankProperty().asObject());
    	meciuriColumn.setCellValueFactory(cellData -> cellData.getValue().matchesProperty().asObject());
    	puncteColumn.setCellValueFactory(cellData -> cellData.getValue().pointsProperty().asObject());
    	palmaresColumn.setCellValueFactory(cellData -> cellData.getValue().recordProperty());
    }
    
    //Populate Player
    @FXML
    private void populatePlayer (Jucator j) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Jucator> playerData = FXCollections.observableArrayList();
        //Add player to the ObservableList
        playerData.add(j);
        //Set items to the playersTable
        playersTable.setItems(playerData);
    }
    
    //Set Players information to Text Area
    @FXML
    private void setPlayerInfoToTextArea (Jucator j) {
        resultArea.setText("ID: " + j.getPlayerID() + "\n" +"Nume: " + j.getName() + "\n" + "Prenume: " + j.getPrenume() + "\n" + "Domiciliu: " + j.getResidence() + "\n" + "Echipament: " + j.getEquipment() + "\n" + "Clasament: " + j.getRank() + "\n" + "Meciuri: " + j.getMatches() + "\n" + "Puncte: " + j.getPoints() + "\n" + "Palmares(V/I): " + j.getRecord());
    }
    
    //Populate Player for TableView and Display Player on TextArea
    @FXML
    private void populateAndShowPlayer(Jucator j) throws ClassNotFoundException {
        if (j != null) {
            populatePlayer(j);
            setPlayerInfoToTextArea(j);
        } else {
            resultArea.setText("This player does not exist!\n");
        }
    }
    
    //Populate Players for TableView
    @FXML
    private void populatePlayers (ObservableList<Jucator> playerData) throws ClassNotFoundException {
        //Set items to the playersTable
    	playersTable.setItems(playerData);
    }
    
    //Insert a player to the DB
    @FXML
    private void insertPlayer (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
        	JucatorDAO.insertPlayer(numeText.getText(),prenumeText.getText(),domiciliuText.getText(),echipamentText.getText(),clasamentText.getText(),meciuriText.getText(),puncteText.getText(),palmaresText.getText());
            resultArea.setText("Player inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting player " + e);
            throw e;
        }
    }
}
