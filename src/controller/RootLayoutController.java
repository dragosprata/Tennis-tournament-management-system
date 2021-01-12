package controller;

import javafx.event.ActionEvent;
import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RootLayoutController  {
	
	@FXML
	public void initialize() {
		
	}
	//Exit the program
	public void handleExit(ActionEvent actionEvent){
		System.exit(0);
	}
	
	//Help Menu button behavior
	public void handleHelp(ActionEvent actionEvent){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Program Information");
		alert.setHeaderText("Aplicatie PS Dragos!");
		alert.setContentText("You can use this app just if you have an account!");
		alert.show();
	}
	

	public void handleManagerLogin(ActionEvent actionEvent) throws IOException{
		Stage stage1 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/ManagerLogin.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage1.setScene(scene);
		stage1.setTitle("Manager login");
		stage1.show();
	}
	
	public void handleLogout(ActionEvent actionEvent) throws IOException{
		Stage stage2 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
		Scene scene = new Scene(root,685,348);		
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage2.setScene(scene);
		stage2.show();
	}
	
	public void handleRefereeLogin(ActionEvent actionEvent) throws IOException{
		Stage stage3 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/RefereeLogin.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage3.setScene(scene);
		stage3.setTitle("Referee login");
		stage3.show();
	}
	
	public void handleGuestLogin(ActionEvent actionEvent) throws IOException{
		Stage stage4 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/GuestLogin.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage4.setScene(scene);
		stage4.setTitle("Guest login");
		stage4.show();
	}
	
	public void handleCreateAccountView(ActionEvent actionEvent) throws IOException{
		Stage stage5 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/CreateAccountView.fxml"));
		Scene scene = new Scene(root,685,348);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage5.setScene(scene);
		stage5.setTitle("Create Account view");
		stage5.show();
	}
	
	public void handlePlayersViewForGuest(ActionEvent actionEvent) throws IOException{
		Stage stage6 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/PlayersViewForGuest.fxml"));
		Scene scene = new Scene(root,900,450);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage6.setScene(scene);
		stage6.setTitle("Players view");
		stage6.show();
	}
	
	public void handlePlayerView(ActionEvent actionEvent) throws IOException{
		Stage stage7 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/PlayersViewForManager.fxml"));
		Scene scene = new Scene(root,900,450);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage7.setScene(scene);
		stage7.setTitle("Players view");
		stage7.show();
	}
	
	public void handleRefereesView(ActionEvent actionEvent) throws IOException{
		Stage stage8 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/RefereesView.fxml"));
		Scene scene = new Scene(root,900,450);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage8.setScene(scene);
		stage8.setTitle("Referees view");
		stage8.show();
	}
	
	public void handleMatchesViewForManager(ActionEvent actionEvent) throws IOException{
		Stage stage9 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/MatchesViewForManager.fxml"));
		Scene scene = new Scene(root,900,450);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage9.setScene(scene);
		stage9.setTitle("Matches view");
		stage9.show();
	}
	
	public void handleMatchesViewForReferee(ActionEvent actionEvent) throws IOException{
		Stage stage10 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/MatchesViewForReferee.fxml"));
		Scene scene = new Scene(root,900,450);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage10.setScene(scene);
		stage10.setTitle("Matches view");
		stage10.show();
	}
	
	public void handleMatchesViewForGuest(ActionEvent actionEvent) throws IOException{
		Stage stage11 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/MatchesViewForGuest.fxml"));
		Scene scene = new Scene(root,900,450);
		scene.getStylesheets().add(getClass().getResource("/controller/application.css").toExternalForm());
		stage11.setScene(scene);
		stage11.setTitle("Matches view");
		stage11.show();
	}
	
	public void handleTournament(ActionEvent actionEvent){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Tournament Information");
		alert.setHeaderText("Detalii turneu");
		alert.setContentText("Turneul campionilor,cunoscut si sub denumirea de BarclaysATP World Tour Finals face parte din complexul sportiv London Tennis Club.Turneul Campionilor la tenis, competitie care reuneste, in perioada 13-20 noiembrie, la Londra, cei mai buni tenismani din anul curent, ofera premii importante si in acest an. La simplu, doar pentru participarea la Londra, fiecare dintre cei opt jucatori va primi cate 167.000 de dolari. Fiecare victorie va fi recompensata cu cate alti 167.000 de dolari, precum si cu 200 de puncte ATP. Pentru calificarea în finala se mai ofera un premiu de 510.000 de dolari, la care se adauga inca 400 de puncte ATP. Castigatorul editiei din acest an va încasa inca 1.560.000 de dolari si alte 900 de puncte ATP.!\nTurneul ofera castigatorului 1500 de puncte ATP,are in dotare 10 terenuri,pe care se vor disputa 15 meciuri fiecare fiind arbitrat de un alt arbitru");
		alert.show();
	}

}
