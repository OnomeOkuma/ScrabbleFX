package com.LetsPlay;
	

import com.LetsPlay.gameplay.Dawg;
import com.LetsPlay.gameplay.TileBag;
import com.LetsPlay.ui.Board;
import com.LetsPlay.ui.ScoreBoard;
import com.LetsPlay.ui.TilesFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
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
			Board board = new Board();
			board.relocate(80, 90);
			
			//Create the dictionary used at runtime.
			Dawg dawg = new Dawg();
			dawg.getClass();
			
			//Layout for the player racks
			HBox rack1 = new HBox(3);
			rack1.relocate(225, 30);
			rack1.setPrefSize(276.85, 36.6);
			
			HBox rack2 = new HBox(3);
			rack2.relocate(225, 669);
			rack2.setPrefSize(276.85, 36.6);

			
			
			//Creating UI for score and player
			ScoreBoard scoreboard = new ScoreBoard();
			scoreboard.set_player_name("Okuma", true);
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
			
			TilesFactory tiles = new TilesFactory();
				 TileBag bag = new TileBag();
			for (int columnindex = 0; columnindex < 7; columnindex++){
				String temp = bag.getTile();
				int tempweight = bag.getTileWeight(temp);
				rack1.getChildren().add(tiles.createGameTile(temp, tempweight));
				
				
				temp = bag.getTile();
				tempweight = bag.getTileWeight(temp);
				rack2.getChildren().add(tiles.createGameTile(temp, tempweight));
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
			board.placeTile(tiles.createGameTile(bag.getTile(), 7), board.getChildren().get(100));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
