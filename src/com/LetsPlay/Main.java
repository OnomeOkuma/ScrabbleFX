package com.LetsPlay;
	

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.gameplay.rules.SingleTileScoreCalculator;
import com.LetsPlay.gameplay.rules.TileScoreCalculator;
import com.LetsPlay.ui.CreatePlayerDialog;
import com.LetsPlay.ui.LogInDialog;
import com.LetsPlay.ui.PlayersView;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
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
			GameSession.init();

			//Layout for the Scrabble board and setting the Scrabble board properties
			GameLayout.board.relocate(80, 90);
			
			//Layout for the player racks
		
			GameLayout.playerRack.relocate(225, 669); // Vertical = 30 for AI rack.
			GameLayout.computerRack.relocate(225, 30);
			
			//Creating UI for score and player
			GameLayout.playerScore.relocate(700.5, 100);
			GameLayout.computerScore.relocate(700.5, 170);
			
			Button play_button = new Button("Play");
			play_button.setPrefSize(90, 20);
			play_button.setOnAction(event -> {
				if(GameSession.loggedInBool){
					
					if(GameSession.checkPlay()){
						GameSession.computer.generateMove();
						GameSession.computer.makePlay();
					
						if (Hand.number_of_plays > 1){
							GameLayout.computerScore.setScore(TileScoreCalculator.calculateScore());
							for(int counter = 0; counter < Hand.number_of_plays; counter++){
								if(GameSession.tilebag.getTileTotal() > 0){
									GameSession.computer.fillRack(GameSession.tilebag.getTile());
								}
							}
							Hand.resetState();
						}else if(Hand.number_of_plays == 1){
							GameLayout.computerScore.setScore(SingleTileScoreCalculator.calculateScore());
							for(int counter = 0; counter < Hand.number_of_plays; counter++){
								if(GameSession.tilebag.getTileTotal() > 0){
									GameSession.computer.fillRack(GameSession.tilebag.getTile());
								}
							}
							Hand.resetState();
						}else{
							Alert alert = new Alert(AlertType.INFORMATION, "Computer passed turn");
							alert.showAndWait();
						}
					}
				
					if(GameSession.isRackEmpty()){
						Alert alert = new Alert(AlertType.INFORMATION, "Game Over");
						alert.showAndWait();
					}
					
					
				}else {
					
					Hand.undo_play();
					Hand.resetState();
					Alert alert = new Alert(AlertType.INFORMATION, "Log In or Create Account");
					alert.showAndWait();
					
				}
			});
			
			Button pass_button = new Button("Pass");
			pass_button.setPrefSize(90, 20);
			pass_button.setOnAction(event -> {
				
				GameSession.computer.generateMove();
				GameSession.computer.makePlay();
				
				if (Hand.number_of_plays > 1){
					GameLayout.computerScore.setScore(TileScoreCalculator.calculateScore());
					for(int counter = 0; counter < Hand.number_of_plays; counter++)
						GameSession.computer.fillRack(GameSession.tilebag.getTile());
					Hand.resetState();
				}else if(Hand.number_of_plays == 1){
					GameLayout.computerScore.setScore(SingleTileScoreCalculator.calculateScore());
					for(int counter = 0; counter < Hand.number_of_plays; counter++)
						GameSession.computer.fillRack(GameSession.tilebag.getTile());
					Hand.resetState();
				}else{
					Alert alert = new Alert(AlertType.INFORMATION, "Computer passed turn");
					alert.showAndWait();
				}
				
			});
			
			Button exchange_button = new Button("Exchange");
			exchange_button.setPrefSize(90, 20);
			exchange_button.setOnAction(event -> {
				int tiles = 0;
				TextInputDialog number_of_tiles = new TextInputDialog();
					number_of_tiles.setContentText("Number: ");
					number_of_tiles.setHeaderText("Number of Tiles to return");
					number_of_tiles.showAndWait();
				
				while(number_of_tiles.getResult() == null || number_of_tiles.getResult().length() == 0){
					number_of_tiles.showAndWait();
					}
				
				try {
					tiles = Integer.parseInt(number_of_tiles.getResult());
				}catch(NumberFormatException e){
					Alert alert = new Alert(AlertType.INFORMATION, "Enter a Number");
					alert.showAndWait();
				}
				
				if (tiles <= 7 && tiles < GameSession.tilebag.getTileTotal()){
					
					for (int i = 0; i < tiles; i++){
					
							Node temp = GameLayout.playerRack.getChildren().remove(i);
							GameSession.tilebag.returnTile(temp);
							GameLayout.playerRack.getChildren().add(GameSession.tilebag.getTile());
						
						}
					
					GameSession.computer.generateMove();
					GameSession.computer.makePlay();
					
					if (Hand.number_of_plays > 1){
						GameLayout.computerScore.setScore(TileScoreCalculator.calculateScore());
						for(int counter = 0; counter < Hand.number_of_plays; counter++)
							GameSession.computer.fillRack(GameSession.tilebag.getTile());
						Hand.resetState();
					}else if(Hand.number_of_plays == 1){
						GameLayout.computerScore.setScore(SingleTileScoreCalculator.calculateScore());
						for(int counter = 0; counter < Hand.number_of_plays; counter++)
							GameSession.computer.fillRack(GameSession.tilebag.getTile());
						Hand.resetState();
					}else{
						Alert alert = new Alert(AlertType.INFORMATION, "Computer passed turn");
						alert.showAndWait();
					}
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION, "Number too high for tile total or rack total");
					alert.showAndWait();
					
				}
				
			});
			
			Button undo_button = new Button("Undo Play");
			undo_button.setPrefSize(90, 20);
			undo_button.setOnAction(event -> {
				Hand.undo_play();
				Hand.resetState();
				
			// Add notice to tell players that undo only works when play is made.
			});
			
			// Added the submit functionality
			Button submit_button = new Button("Submit");
			submit_button.setPrefSize(90, 20);
			submit_button.setOnAction(event -> {
				Alert alert = new Alert(AlertType.INFORMATION, "You have admitted defeat");
				alert.showAndWait();
				scene_layout.getChildren().remove(GameLayout.board);
				scene_layout.getChildren().remove(GameLayout.playerRack);
	
				GameSession.restartGame();
				
				GameLayout.board.relocate(80, 90);
				scene_layout.getChildren().add(GameLayout.board);
				
				GameLayout.playerRack.relocate(225, 669);
				scene_layout.getChildren().add(GameLayout.playerRack);
				
			});
			
			Button login_button = new Button("Log In");
			login_button.setPrefSize(90, 20);
			login_button.setOnAction(e -> {
				if(!CreatePlayerDialog.isOpen){
					LogInDialog loginDialog = new LogInDialog();
					loginDialog.showAndWait();
				}
			});
			
			Button logout_button = new Button("Log Out");
			logout_button.setPrefSize(90, 20);
			logout_button.setOnAction(e -> {
				GameLayout.playerScore.setName("New Player");
				GameSession.loggedInBool = false;
				GameSession.loggedIn.setSelected(false);

			});
			
			
			Button create_button = new Button("Create\nPlayer");
			create_button.setPrefSize(90, 45);
			create_button.setOnAction(e -> {
				if(!LogInDialog.isOpen){
					CreatePlayerDialog createPlayer = new CreatePlayerDialog();
					createPlayer.showAndWait();
				}
			});
			
			
			//Creating the buttons for gameplay control
			VBox button_list = new VBox(5);
			button_list.getChildren().addAll(play_button, pass_button, exchange_button, undo_button,
											submit_button, login_button, GameSession.loggedIn, logout_button, create_button);
			button_list.relocate(700.5, 300);
			button_list.setOpacity(50.00);
			PlayersView.playerview.relocate(1000, 50);
			
			//Putting the pieces together
			scene_layout.getChildren().add(GameLayout.board);
			scene_layout.getChildren().add(GameLayout.playerRack);
			scene_layout.getChildren().add(button_list);
			scene_layout.getChildren().add(GameLayout.playerScore);
			scene_layout.getChildren().add(PlayersView.playerview);
			scene_layout.getChildren().add(GameLayout.computerRack);
			scene_layout.getChildren().add(GameLayout.computerScore);
			
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
