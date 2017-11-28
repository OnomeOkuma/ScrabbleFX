package com.LetsPlay.ui;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.gameplay.rules.SingleTileScoreCalculator;
import com.LetsPlay.gameplay.rules.TileScoreCalculator;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class Buttons {
	public static VBox buttonList;
	private static Button playButton;
	private static Button passButton;
	private static Button exchangeButton;
	private static Button undoButton;
	private static Button submitButton;
	private static Button loginButton;
	private static CheckBox loggedIn;
	private static boolean isLoggedIn = false;
	private static Button logoutButton;
	private static Button createPlayerButton;
	
	/*
	 * for Internet play.
	 *  
	private static Button playRemoteButton;
	private static Button passRemoteButton;
	private static Button exchangeRemoteButton;
	private static Button submitRemoteButton;
	*/
	
	public static void logIn(){
		isLoggedIn = true;
		loggedIn.setSelected(isLoggedIn);
	}
	
	
	public static void logOut(){
		isLoggedIn = false;
		loggedIn.setSelected(isLoggedIn);
	}
	
	
	public static boolean isLoggedIn(){
		return isLoggedIn;
	}
	
	
	public static void initializeButtons(){
		playButton  = new Button("Play");
		playButton.setPrefSize(90, 20);
		playButton.setOnAction(event -> {
			if(Buttons.isLoggedIn()){
				
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
						
						if(GameSession.isTileBagEmpty())
							GameSession.scoreless++;
						
					}
				}
			
				if(GameLayout.isRackEmpty()){
					Alert alert = new Alert(AlertType.INFORMATION, "Game Over");
					alert.showAndWait();
				}		
				
			}else {
				
				Hand.undo_play();
				Hand.resetState();
				Alert alert = new Alert(AlertType.INFORMATION, "Log In or Create Account");
				alert.showAndWait();
				
			}
			
			if(GameSession.scoreless == 6){
				Alert alert = new Alert(AlertType.INFORMATION, "Game Over");
				alert.showAndWait();
				GameSession.restartGame();
			}
		});
		
		
		passButton = new Button("Pass");
		passButton.setPrefSize(90, 20);
		passButton.setOnAction(event -> {
			
			if(GameSession.isTileBagEmpty())
				GameSession.scoreless++;
			
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
				
				if(GameSession.isTileBagEmpty())
					GameSession.scoreless++;
			}
			
			if(GameSession.scoreless == 6){
				Alert alert = new Alert(AlertType.INFORMATION, "Game Over");
				alert.showAndWait();
				GameSession.restartGame();
			}
		});
		
		
		exchangeButton = new Button("Exchange");
		exchangeButton.setPrefSize(90, 20);
		exchangeButton.setOnAction(event -> {
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
					
					if(GameSession.isTileBagEmpty())
						GameSession.scoreless++;
				}
				
			}else{
				
				Alert alert = new Alert(AlertType.INFORMATION, "Number too high for tile total or rack total");
				alert.showAndWait();
				
			}
			
			if(GameSession.scoreless == 6){
				Alert alert = new Alert(AlertType.INFORMATION, "Game Over. Endgame Scoreless turn exceeded.");
				alert.showAndWait();
				GameSession.restartGame();
			}
			
		});
		
		undoButton = new Button("Undo Play");
		undoButton.setPrefSize(90, 20);
		undoButton.setOnAction(event -> {
			Hand.undo_play();
			Hand.resetState();
			
		// Add notice to tell players that undo only works when play is made.
		});
		
		
		// Added the submit functionality
		submitButton = new Button("Submit");
		submitButton.setPrefSize(90, 20);
		submitButton.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION, "You have admitted defeat");
			alert.showAndWait();
			GameSession.restartGame();
		});
		
		loginButton = new Button("Log In");
		loginButton.setPrefSize(90, 20);
		loginButton.setOnAction(e -> {
			if(!CreatePlayerDialog.isOpen){
				LogInDialog loginDialog = new LogInDialog();
				loginDialog.showAndWait();
			}
		});

		loggedIn = new CheckBox("Logged In");
		loggedIn.setPadding(new Insets(5,5,5,5));
		loggedIn.setOnAction(e -> {
			loggedIn.setSelected(isLoggedIn);
		});
		
		logoutButton = new Button("Log Out");
		logoutButton.setPrefSize(90, 20);
		logoutButton.setOnAction(e -> {
			GameLayout.playerScore.setName("New Player");
			Buttons.logOut();
		});
		
		createPlayerButton = new Button("Create\nPlayer");
		createPlayerButton.setPrefSize(90, 45);
		createPlayerButton.setOnAction(e -> {
			if(!LogInDialog.isOpen){
				CreatePlayerDialog createPlayer = new CreatePlayerDialog();
				createPlayer.showAndWait();
			}
		});
	
		//Creating the buttons for gameplay control
		buttonList = new VBox(5);
		buttonList.getChildren().addAll(playButton, passButton, exchangeButton, undoButton,
										submitButton, loginButton, loggedIn, logoutButton, createPlayerButton);
		buttonList.relocate(700.5, 300);
		buttonList.setOpacity(50.00);
		
	}
	
}
