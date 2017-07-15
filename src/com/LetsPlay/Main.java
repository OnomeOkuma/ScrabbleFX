package com.LetsPlay;
	

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.GameplayChecker;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.ui.ScoreBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Layout to arrange all the UI component
			Pane scene_layout = new Pane();
			
			// Initialize the GameSession object
			GameSession.gameInit();

			//Layout for the Scrabble board and setting the Scrabble board properties
			GameSession.board.relocate(80, 90);
			
			//Layout for the player racks
		
			GameSession.rack1.relocate(225, 30);
			
			GameSession.rack2.relocate(225, 669);
			
			
			//Creating UI for score and player
			ScoreBoard scoreboard = new ScoreBoard();
			scoreboard.set_player_name("Celebrimbor", true);
			scoreboard.set_player_name("Maxwell", false);
			scoreboard.set_score("180", true);
			scoreboard.set_score("200", false);
			scoreboard.relocate(700.5, 100);
			
			
			//Creating the buttons for gameplay control
			VBox button_list = new VBox(10);
			button_list.relocate(700.5, 300);
			
			Button play_button = new Button("Play");
			play_button.setVisible(true);
			play_button.setPrefSize(90, 20);
			play_button.setOnAction(event -> {
				
				if (GameplayChecker.onSameIndex()){
					for (int counter = 0; counter < Hand.tiles_played.size(); counter++){
						if (GameSession.tilebag.getTileTotal() > 0)
							GameSession.rack1.getChildren().add(GameSession.tilebag.getTile());
						
					}
					Hand.resetState();
				} else Hand.undo_play();
				
			});
			
			Button pass_button = new Button("Pass");
			pass_button.setVisible(true);
			pass_button.setPrefSize(90, 20);
			
			Button undo_button = new Button("Undo Play");
			undo_button.setVisible(true);
			undo_button.setPrefSize(90, 20);
			undo_button.setOnAction(event -> {
				Hand.undo_play();
			});
			
			Button submit_button = new Button("Submit");
			submit_button.setVisible(true);
			submit_button.setPrefSize(90, 20);
			
			button_list.getChildren().add(play_button);
			button_list.getChildren().add(pass_button);
			button_list.getChildren().add(submit_button);
			button_list.getChildren().add(undo_button);
			
			for (int columnindex = 0; columnindex < 7; columnindex++){
			
				GameSession.rack1.getChildren().add(GameSession.tilebag.getTile());
				
				GameSession.rack2.getChildren().add(GameSession.tilebag.getTile());
			}
			
			//Putting the pieces together
			scene_layout.getChildren().add(GameSession.board);
			scene_layout.getChildren().addAll(GameSession.rack1, GameSession.rack2);
			scene_layout.getChildren().add(button_list);
			scene_layout.getChildren().add(scoreboard);
			Scene scene = new Scene(scene_layout, 1366, 768);
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
