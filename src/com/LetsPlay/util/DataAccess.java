package com.LetsPlay.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataAccess {
		private Connection con;
		
		public DataAccess(){
			try {
				
				this.con = DriverManager.getConnection("jdbc:h2:~/Let's Play");
				this.con.setAutoCommit(true);
				Statement statement = this.con.createStatement();
				
				statement.execute("CREATE TABLE IF NOT EXISTS users (username VARCHAR(40), password VARCHAR(40));");
				statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR, "Unable to connect to Database");
				alert.show();
				Platform.exit();
			}
			
		}
		
		public Statement createStatement() throws SQLException{
			return this.con.createStatement();
		}
		
		public boolean close(){
			
			try {
				
				this.con.close();
				return true;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
				
			}
			
		}
}
