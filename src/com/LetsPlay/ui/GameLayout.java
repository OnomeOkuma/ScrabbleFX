package com.LetsPlay.ui;

import com.LetsPlay.gameplay.GameSession;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GameLayout {
	public static Board board;
	public static HBox computerRack;
	public static HBox playerRack;
	public static ScoreBoard playerScore;
	public static ScoreBoard computerScore;
	public static Pane sceneLayout;
	
	public static void init(){
		
		Buttons.initializeButtons();
		
		GameLayout.sceneLayout = new Pane();
		
		//Layout for the Scrabble board and setting the Scrabble board properties
		GameLayout.board = new Board();
		GameLayout.board.relocate(80, 90);
		
		
		GameLayout.computerRack = new HBox(1.55);
		GameLayout.computerRack.setPrefSize(276.85, 36.6);
		GameLayout.computerRack.setStyle("-fx-background-color: #fffacd;");
		
		GameLayout.playerRack = new HBox(1.55);
		GameLayout.playerRack.setStyle("-fx-background-color: #f0fff0;");
		GameLayout.playerRack.setPrefSize(276.85, 36.6);
		
		//Layout for the player racks
		GameLayout.playerRack.relocate(225, 669); // Vertical = 30 for AI rack.
		GameLayout.computerRack.relocate(225, 30);
		
		
		GameLayout.computerScore = new ScoreBoard();
		GameLayout.computerScore.setName("Computer");
		GameLayout.computerScore.setScore(0);
		
		GameLayout.playerScore = new ScoreBoard();
		GameLayout.playerScore.setName("New Player");
		GameLayout.playerScore.setScore(0);
		
		//Creating UI for score and player
		GameLayout.playerScore.relocate(700.5, 100);
		GameLayout.computerScore.relocate(700.5, 170);
		
		//Putting the pieces together
		GameLayout.sceneLayout.getChildren().add(GameLayout.board);
		GameLayout.sceneLayout.getChildren().add(GameLayout.playerRack);
		GameLayout.sceneLayout.getChildren().add(GameLayout.playerScore);
		GameLayout.sceneLayout.getChildren().add(PlayersView.playerview);
		GameLayout.sceneLayout.getChildren().add(GameLayout.computerRack);
		GameLayout.sceneLayout.getChildren().add(GameLayout.computerScore);
		GameLayout.sceneLayout.getChildren().add(Buttons.buttonList);
		
	}
	
	public static boolean isRackEmpty(){
		return (GameLayout.playerRack.getChildren().size() == 0 || GameSession.computer.tiles.size() == 0);
	}
	
	public static void resetLayout(){
		
		GameLayout.sceneLayout.getChildren().remove(GameLayout.board);
		GameLayout.sceneLayout.getChildren().remove(GameLayout.playerRack);
		
		GameLayout.board = new Board();
		GameLayout.board.relocate(80, 90);
		GameLayout.sceneLayout.getChildren().add(GameLayout.board);
		
		
		GameLayout.playerRack = new HBox(1.55);
		GameLayout.playerRack.setStyle("-fx-background-color: #f0fff0;");
		GameLayout.playerRack.setPrefSize(276.85, 36.6);
		GameLayout.playerRack.relocate(225, 669);
		GameLayout.sceneLayout.getChildren().add(GameLayout.playerRack);
		
		GameLayout.playerScore.restart();
		GameLayout.computerScore.restart();
		
	}

}
