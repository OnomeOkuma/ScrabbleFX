package com.LetsPlay.gameplay;

import com.LetsPlay.ui.ScoreBoard;

import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;

public class Player {
		public ScoreBoard scoreboard;
		public HBox player_rack;
		private int player_score;
		
		public Player(){
			this.player_score = 0;
			this.scoreboard = new ScoreBoard();
			
			TextInputDialog name = new TextInputDialog();
			name.setContentText("Name: ");
			name.setHeaderText("Player Name");
			name.showAndWait();
			
			while(name.getResult() == null || name.getResult().length() == 0){
				name.showAndWait();
			}
			this.scoreboard.setName(name.getResult());
			name.close();
			
			this.scoreboard.setScore(Integer.toString(this.player_score));
			this.player_rack = new HBox(1.55);
			this.player_rack.setPrefSize(276.85, 36.6);
			this.player_rack.setStyle("-fx-background-color: #f0fff0;");
		}
		
		public void setPlayerName(String name){
			this.scoreboard.setName(name);
		}
		
		public void setPlayerScore(int score){
			this.player_score += score;
			this.scoreboard.setScore(Integer.toString(this.player_score));
		}
}
