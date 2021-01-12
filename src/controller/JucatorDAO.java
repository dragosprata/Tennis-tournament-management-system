package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Jucator;
import model.ConnectionFactory;

public class JucatorDAO {
	
	//*******************************
    //SELECT a player
    //*******************************
	public static Jucator searchPlayer(String nume) throws SQLException,ClassNotFoundException{
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM jucator WHERE NUME = '"+nume+"'" ;
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsPlayer = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getPlayerFromResultSet method and get referee object
			Jucator j = getPlayerFromResultSet(rsPlayer);
			
			//Return player object
			return j; 
		}catch(SQLException e){
			System.out.println("While searching a player with " + nume + " name, an error occurred: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Use ResultSet from DB as parameter and set Player Object's attributes and return player object.
	private static Jucator getPlayerFromResultSet(ResultSet rs) throws SQLException{
		Jucator j = null;
		if(rs.next()){
			j = new Jucator();
			j.setPlayerID(rs.getInt("ID"));
			j.setName(rs.getString("NUME"));
			j.setPrenume(rs.getString("PRENUME"));
			j.setResidence(rs.getString("DOMICILIU"));
			j.setEquipment(rs.getString("ECHIPAMENT"));
			j.setRank(rs.getInt("CLASAMENT"));
			j.setMatches(rs.getInt("MECIURI"));
			j.setPoints(rs.getInt("PUNCTE"));
			j.setRecord(rs.getString("PALMARES"));
		}
		return j;
	}
	
	//*******************************
    //SELECT players
    //*******************************
	public static ObservableList<Jucator> searchPlayers () throws SQLException, ClassNotFoundException {
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM jucator";
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsPlayers = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getPlayerList method and get player object
			ObservableList<Jucator> playerList = getPlayerList(rsPlayers);
			
			//Return player object
			return playerList;
		}catch (SQLException e){
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Select * from players operation
	private static ObservableList<Jucator> getPlayerList(ResultSet rs) throws SQLException,ClassNotFoundException{
		//Declare a observable List which comprises of player objects
		ObservableList<Jucator> playerList = FXCollections.observableArrayList();
		
		while (rs.next()){
			Jucator j = new Jucator();
			j.setPlayerID(rs.getInt("ID"));
			j.setName(rs.getString("NUME"));
			j.setPrenume(rs.getString("PRENUME"));
			j.setResidence(rs.getString("DOMICILIU"));
			j.setEquipment(rs.getString("ECHIPAMENT"));
			j.setRank(rs.getInt("CLASAMENT"));
			j.setMatches(rs.getInt("MECIURI"));
			j.setPoints(rs.getInt("PUNCTE"));
			j.setRecord(rs.getString("PALMARES"));
			playerList.add(j);
		}
		//return playerList (ObservableList of players)
		return playerList;
	}
	
	 //*************************************
    //INSERT a player
    //*************************************
	
	public static void insertPlayer (String nume,String prenume,String domiciliu,String echipament,String clasament,String meciuri,String puncte,String palmares) throws SQLException, ClassNotFoundException{
		//Declare a INSERT statement
		String insertStmt = "INSERT INTO jucator (NUME,PRENUME,DOMICILIU,ECHIPAMENT,CLASAMENT,MECIURI,PUNCTE,PALMARES) VALUES ('"+nume+"','"+prenume+"','"+domiciliu+"','"+echipament+"','"+clasament+"','"+meciuri+"','"+puncte+"','"+palmares+"')";
		//Execute INSERT operation
		try{
			ConnectionFactory.dbExecuteUpdate(insertStmt);
		} catch (SQLException e){
			System.out.print("Error occurred while INSERT operation: " + e);
			throw e;
		}

	}
}
