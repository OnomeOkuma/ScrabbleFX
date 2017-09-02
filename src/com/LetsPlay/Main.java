package com.LetsPlay;
	

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.ui.PlayersView;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Layout to arrange all the UI component
			Pane scene_layout = new Pane();
			
			// Initialize the GameSession object
			GameSession.init();

			//Layout for the Scrabble board and setting the Scrabble board properties
			GameSession.board.relocate(80, 90);
			
			//Layout for the player racks
		
			GameSession.player.player_rack.relocate(225, 669); // Vertical = 30 for AI rack.
			
			
			//Creating UI for score and player
			GameSession.player.scoreboard.relocate(700.5, 100);

			
			Button play_button = new Button("Play");
			play_button.setVisible(true);
			play_button.setPrefSize(90, 20);
			play_button.setOnAction(event -> {
				GameSession.checkPlay();
			});
			
			Button pass_button = new Button("Pass");
			pass_button.setVisible(true);
			pass_button.setPrefSize(90, 20);
			pass_button.setOnAction(event -> {
				GameSession.tilebag.returnTile(GameSession.player.player_rack.getChildren());
				GameSession.player.player_rack.getChildren().clear();
				for (int columnindex = 0; columnindex < 7; columnindex++){
					
					GameSession.player.player_rack.getChildren().add(GameSession.tilebag.getTile());
					
				}
				
			});
			
			Button undo_button = new Button("Undo Play");
			undo_button.setVisible(true);
			undo_button.setPrefSize(90, 20);
			undo_button.setOnAction(event -> {
				Hand.undo_play();
				Hand.resetState();
				
			// Add notice to tell players that undo only works when play is made.
			});
			
			Button submit_button = new Button("Submit");
			submit_button.setVisible(true);
			submit_button.setPrefSize(90, 20);
			submit_button.setOnAction(event -> {
			});
			
			//Creating the buttons for gameplay control
			ToolBar button_list = new ToolBar(play_button, pass_button, submit_button, undo_button);
			button_list.relocate(700.5, 300);
			button_list.setOrientation(Orientation.VERTICAL);
			button_list.setOpacity(50.00);
			PlayersView.playerview.relocate(1000, 50);
			//Putting the pieces together
			scene_layout.getChildren().add(GameSession.board);
			scene_layout.getChildren().addAll(GameSession.player.player_rack);
			scene_layout.getChildren().add(button_list);
			scene_layout.getChildren().add(GameSession.player.scoreboard);
			scene_layout.getChildren().add(PlayersView.playerview);
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
