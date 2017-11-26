package com.LetsPlay;

import com.LetsPlay.ui.Board;
import com.LetsPlay.ui.ScoreBoard;

import javafx.scene.layout.HBox;

public class GameLayout {
	public static Board board;
	public static HBox computerRack;
	public static HBox playerRack;
	public static ScoreBoard playerScore;
	public static ScoreBoard computerScore;
	
	public GameLayout(){
		GameLayout.board = new Board();
		
		GameLayout.computerRack = new HBox(1.55);
		GameLayout.computerRack.setPrefSize(276.85, 36.6);
		GameLayout.computerRack.setStyle("-fx-background-color: #fffacd;");
		
		GameLayout.playerRack = new HBox(1.55);
		GameLayout.playerRack.setStyle("-fx-background-color: #f0fff0;");
		GameLayout.playerRack.setPrefSize(276.85, 36.6);
		
		GameLayout.computerScore = new ScoreBoard();
		GameLayout.computerScore.setName("Computer");
		GameLayout.computerScore.setScore(0);
		
		GameLayout.playerScore = new ScoreBoard();
		GameLayout.playerScore.setName("New Player");
		GameLayout.playerScore.setScore(0);
	}
	
}
