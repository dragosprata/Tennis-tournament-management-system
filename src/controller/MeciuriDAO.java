package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ConnectionFactory;
import model.Meciuri;

public class MeciuriDAO {
	
	//*******************************
    //SELECT a match
    //*******************************
	public static Meciuri searchMatch(String player1) throws SQLException,ClassNotFoundException{
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM meciuri WHERE NUME_JUCATOR1 = '"+player1+"'" + "OR NUME_JUCATOR2 = '"+player1+"'";
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsMatch = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getMatchFromResultSet method and get match object
			Meciuri match = getMatchFromResultSet(rsMatch);
			
			//Return match object
			return match; 
		}catch(SQLException e){
			System.out.println("While searching a match with " + player1 + "as one of the players, an error occurred: " + e);
			//Return exception
			throw e;
		}
	}
	
	public static Meciuri searchMatch2(String referee) throws SQLException,ClassNotFoundException{
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM meciuri WHERE ARBITRU = '"+referee+"'";
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsMatch = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getMatchFromResultSet method and get match object
			Meciuri match = getMatchFromResultSet(rsMatch);
			
			//Return match object
			return match; 
		}catch(SQLException e){
			System.out.println("While searching a match with " + referee + "as referee, an error occurred: " + e);
			//Return exception
			throw e;
		}
	}
	
	public static ObservableList<Meciuri> searchMatchesForDate (String day) throws SQLException, ClassNotFoundException {
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM meciuri WHERE ziua = '"+day+"'";
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsMatches = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getMatchList method and get match object
			ObservableList<Meciuri> matchList = getMatchList(rsMatches);
			
			//Return match object
			return matchList;
		}catch (SQLException e){
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Use ResultSet from DB as parameter and set match Object's attributes and return match object.
	private static Meciuri getMatchFromResultSet(ResultSet rs) throws SQLException{
		Meciuri m = null;
		if(rs.next()){
			m = new Meciuri();
			m.setMatchNo(rs.getInt("NR_MECI"));
			m.setP1Name(rs.getString("NUME_JUCATOR1"));
			m.setP2Name(rs.getString("NUME_JUCATOR2"));
			m.setPhase(rs.getString("FAZA"));
			m.setDay(rs.getString("ZIUA"));
			m.setCourtNo(rs.getInt("NUMAR_TEREN"));
			m.setReferee(rs.getString("ARBITRU"));
			m.setScore(rs.getString("SCOR"));
		}
		return m;
	}

	//*******************************
    //SELECT matches
    //*******************************
	public static ObservableList<Meciuri> searchMatches () throws SQLException, ClassNotFoundException {
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM meciuri";
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsMatches = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getMatchList method and get match object
			ObservableList<Meciuri> matchList = getMatchList(rsMatches);
			
			//Return match object
			return matchList;
		}catch (SQLException e){
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Select * from matches operation
	private static ObservableList<Meciuri> getMatchList(ResultSet rs) throws SQLException,ClassNotFoundException{
		//Declare a observable List which comprises of match objects
		ObservableList<Meciuri> matchList = FXCollections.observableArrayList();
		
		while (rs.next()){
			Meciuri m = new Meciuri();
			m.setMatchNo(rs.getInt("NR_MECI"));
			m.setP1Name(rs.getString("NUME_JUCATOR1"));
			m.setP2Name(rs.getString("NUME_JUCATOR2"));
			m.setPhase(rs.getString("FAZA"));
			m.setDay(rs.getString("ZIUA"));
			m.setCourtNo(rs.getInt("NUMAR_TEREN"));
			m.setReferee(rs.getString("ARBITRU"));
			m.setScore(rs.getString("SCOR"));
			matchList.add(m);
		}
		//return matchList (ObservableList of matches)
		return matchList;
	}
	
	//*************************************
    //UPDATE for a match day and hour
    //*************************************
	
	public static void updateDayAndHourMatch(String player1,String phase) throws SQLException, ClassNotFoundException {
		//Declare a UPDATE statement
		String updateStmt = "UPDATE meciuri SET FAZA='"+phase+"' WHERE NUME_JUCATOR1 = '"+player1+"'";
		//Execute UPDATE operation
		try{
			ConnectionFactory.dbExecuteUpdate(updateStmt);
		}catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
	
	 //*************************************
    //UPDATE for a match the score
    //*************************************
	
	public static void updateMatchScore(String arbitru,String scor) throws SQLException, ClassNotFoundException {
		//Declare a UPDATE statement
		String updateStmt = "UPDATE meciuri SET SCOR='"+scor+"' WHERE ARBITRU = '"+arbitru+"'";
		//Execute UPDATE operation
		try{
			ConnectionFactory.dbExecuteUpdate(updateStmt);
		}catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}

	 //*************************************
    //INSERT a match
    //*************************************
	public static void insertMatch (String p1,String p2,String faza,String ziua,String teren,String arbitru) throws SQLException, ClassNotFoundException{
		//Declare a INSERT statement
		String insertStmt = "INSERT INTO meciuri (NUME_JUCATOR1,NUME_JUCATOR2,FAZA,ZIUA,NUMAR_TEREN,ARBITRU) VALUES ('"+p1+"','"+p2+"','"+faza+"','"+ziua+"','"+teren+"','"+arbitru+"')";
		//Execute INSERT operation
		try{
			ConnectionFactory.dbExecuteUpdate(insertStmt);
		} catch (SQLException e){
			System.out.print("Error occurred while INSERT operation: " + e);
			throw e;
		}

	}
	

}
