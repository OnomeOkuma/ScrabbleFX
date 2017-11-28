package com.LetsPlay;
	

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.ui.GameLayout;
import com.LetsPlay.ui.PlayersView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Initialize the GameSession object
			GameSession.init();
			PlayersView.playerview.relocate(1000, 50);
			
			Scene scene = new Scene(GameLayout.sceneLayout, 1366, 768);
			primaryStage.setTitle("Let's Play");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
