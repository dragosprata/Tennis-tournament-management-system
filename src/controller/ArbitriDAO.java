package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ConnectionFactory;
import model.Arbitri;

public class ArbitriDAO {
	
	//*******************************
    //SELECT a referee
    //*******************************
	public static Arbitri searchReferee(String nume) throws SQLException,ClassNotFoundException{
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM arbitri WHERE NUME = '"+nume+"'" ;
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsReferee = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getRefereeFromResultSet method and get referee object
			Arbitri a = getRefereeFromResultSet(rsReferee);
			
			//Return referee object
			return a; 
		}catch(SQLException e){
			System.out.println("While searching a referee with " + nume + " name, an error occurred: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Use ResultSet from DB as parameter and set Referee Object's attributes and return referee object.
	private static Arbitri getRefereeFromResultSet(ResultSet rs) throws SQLException{
		Arbitri a = null;
		if(rs.next()){
			a = new Arbitri();
			a.setID(rs.getInt("ID"));
			a.setName(rs.getString("NUME"));
			a.setCourtNo(rs.getInt("NUMAR_TEREN"));
		}
		return a;
	}

	//*******************************
    //SELECT referees
    //*******************************
	public static ObservableList<Arbitri> searchReferees () throws SQLException, ClassNotFoundException {
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM arbitri";
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsReferees = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getRefereeList method and get referee object
			ObservableList<Arbitri> refereeList = getRefereeList(rsReferees);
			
			//Return referee object
			return refereeList;
		}catch (SQLException e){
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Select * from referees operation
	private static ObservableList<Arbitri> getRefereeList(ResultSet rs) throws SQLException,ClassNotFoundException{
		//Declare a observable List which comprises of referee objects
		ObservableList<Arbitri> refereeList = FXCollections.observableArrayList();
		
		while (rs.next()){
			Arbitri a = new Arbitri();
			a.setID(rs.getInt("ID"));
			a.setName(rs.getString("NUME"));
			a.setCourtNo(rs.getInt("NUMAR_TEREN"));
			refereeList.add(a);
		}
		//return refereeList (ObservableList of referees)
		return refereeList;
	}
	
	 //*************************************
    //INSERT a referee
    //*************************************
	
	public static void insertReferee (String nume) throws SQLException, ClassNotFoundException{
		//Declare a INSERT statement
		String insertStmt = "INSERT INTO arbitri (NUME) VALUES ('"+nume+"')";
		//Execute INSERT operation
		try{
			ConnectionFactory.dbExecuteUpdate(insertStmt);
		} catch (SQLException e){
			System.out.print("Error occurred while INSERT operation: " + e);
			throw e;
		}

	}
	
	 //*************************************
    //Distribution referees at matches
    //*************************************
	
	public static void updateRefereeCourtNo(String nume,String numar_teren) throws SQLException, ClassNotFoundException {
		//Declare a UPDATE statement
		String updateStmt = "UPDATE arbitri SET NUMAR_TEREN='"+numar_teren+"' WHERE NUME = '"+nume+"'";
		//Execute UPDATE operation
		try{
			ConnectionFactory.dbExecuteUpdate(updateStmt);
		}catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
	
	//*************************************
    //DELETE a referee
    //*************************************
	public static void deleteRefereeWithName(String nume) throws SQLException, ClassNotFoundException {
		//Declare a DELETE statement
		String deleteStmt = "DELETE FROM arbitri WHERE nume ='"+nume+"'";
		//Execute DELETE operation
		try{
			ConnectionFactory.dbExecuteUpdate(deleteStmt);
		} catch (SQLException e){
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}
}
