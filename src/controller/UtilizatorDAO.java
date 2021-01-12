package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConnectionFactory;
import model.Meciuri;
import model.Utilizator;

public class UtilizatorDAO {

	//*******************************
    //SELECT a user
    //*******************************
	public static Utilizator searchUser(String user) throws SQLException,ClassNotFoundException{
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM utilizator WHERE USERNAME = '"+user+"'";
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsUser = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getUserFromResultSet method and get user object
			Utilizator u = getUserFromResultSet(rsUser);
			
			//Return user object
			return u; 
		}catch(SQLException e){
			System.out.println("While searching an user with " + user + "as username, an error occurred: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Use ResultSet from DB as parameter and set user Object's attributes and return user object.
		private static Utilizator getUserFromResultSet(ResultSet rs) throws SQLException{
			Utilizator u = null;
			if(rs.next()){
				u = new Utilizator();
				u.setName(rs.getString("NUME"));
				u.setUsername(rs.getString("USERNAME"));
				u.setPass(rs.getString("PASS"));
			}
			return u;
		}
		
		 //*************************************
	    //INSERT a user
	    //*************************************
		public static void insertUser (String nume,String username,String password) throws SQLException, ClassNotFoundException{
			//Declare a INSERT statement
			String insertStmt = "INSERT INTO utilizator (NUME,USERNAME,PASS) VALUES ('"+nume+"','"+username+"','"+password+"')";
			//Execute INSERT operation
			try{
				ConnectionFactory.dbExecuteUpdate(insertStmt);
			} catch (SQLException e){
				System.out.print("Error occurred while INSERT operation: " + e);
				throw e;
			}

		}
}
