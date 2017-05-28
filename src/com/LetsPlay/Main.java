package com.LetsPlay;
	
import com.LetsPlay.ui.BoardLayout;
import com.LetsPlay.ui.RackLayout;
import com.LetsPlay.ui.ScoreBoard;
import com.LetsPlay.ui.ScrabbleTiles;

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
			

			//Layout for the Scrabble board and setting the Scrabble board properties
			BoardLayout board = new BoardLayout();
			board.relocate(80, 90);
			
			
			
			//Layout for the player racks
			RackLayout rack1 = new RackLayout();
			rack1.relocate(225, 30);
			
			RackLayout rack2 = new RackLayout();
			rack2.relocate(225, 669);

			
			
			//Creating UI for score and player
			ScoreBoard scoreboard = new ScoreBoard();
			scoreboard.set_player_name("Maxwell", false);
			scoreboard.set_score("180", true);
			scoreboard.relocate(700.5, 100);
			
			
			//Creating the buttons for gameplay control
			VBox button_list = new VBox(10);
			button_list.relocate(700.5, 300);
			
			Button play_button = new Button("Play");
			play_button.setVisible(true);
			play_button.setPrefSize(90, 20);
			
			Button pass_button = new Button("Pass");
			pass_button.setVisible(true);
			pass_button.setPrefSize(90, 20);
			
			Button submit_button = new Button("Submit");
			submit_button.setVisible(true);
			submit_button.setPrefSize(90, 20);
			
			button_list.getChildren().add(play_button);
			button_list.getChildren().add(pass_button);
			button_list.getChildren().add(submit_button);
			
			ScrabbleTiles tiles = new ScrabbleTiles();
			for (int columnindex = 0; columnindex < 7; columnindex++){
				rack1.getChildren().add(tiles.TileA());
				rack2.getChildren().add(tiles.TileA());
			}
			
			
			
			//Putting the pieces together
			scene_layout.getChildren().add(board);
			scene_layout.getChildren().addAll(rack1, rack2);
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
