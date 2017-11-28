package com.LetsPlay.ui;

import java.sql.ResultSet;
import java.sql.Statement;

import com.LetsPlay.gameplay.GameSession;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInDialog extends Stage{
	public static boolean isOpen = false;
	
	public LogInDialog(){
		
			super();
			
			TextField username = new TextField();
			username.setPromptText("Username");
			
			PasswordField password = new PasswordField();
			password.setPromptText("Password");
			
			Button logIn = new Button("Log In");
			logIn.setOnAction(e -> {
				if(username.getText().equals("")){
					Alert alert = new Alert(AlertType.ERROR, "Enter Username");
					alert.showAndWait();
				}else if(password.getText().equals("")){
					Alert alert = new Alert(AlertType.ERROR, "Enter Password");
					alert.showAndWait();
				}else{ 
					try {
					Statement statement = GameSession.dataaccess.createStatement();
					ResultSet result = statement.executeQuery(
							
							"SELECT password FROM users WHERE username = " + "\'" + username.getText() + "\' ;" 
							
							);
					
					if(result.next()){
						
						String passwordvalue = result.getString(1);
						if (passwordvalue.equals(password.getText())){
							
							GameLayout.playerScore.setName(username.getText());
							Buttons.logIn();
							
						}else{
							
							Alert alert = new Alert(AlertType.INFORMATION, "Log In Failed");
							alert.showAndWait();
							
							}
						
						}else{
						
							Alert alert = new Alert(AlertType.INFORMATION, "Log In Failed");
							alert.showAndWait();
						
						}
					} catch (Exception e1) {

						e1.printStackTrace();
					
					}
				
					this.close();
				}
			});
			
			VBox layout = new VBox(10);
			layout.setPadding(new Insets(30, 30, 0, 30));
			layout.getChildren().addAll(username, password, logIn);
			
			Scene scene = new Scene(layout, 300, 150);
			
			super.setScene(scene);
			super.setTitle("Log In");
			super.setResizable(false);
			super.setOnShown(e -> {
				LogInDialog.isOpen = true;
			});
			super.setOnHidden(e -> {
				LogInDialog.isOpen = false;
			});
			
			LogInDialog.isOpen = true;
	}

}
