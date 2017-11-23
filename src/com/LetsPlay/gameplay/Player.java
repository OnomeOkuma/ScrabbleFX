package com.LetsPlay.gameplay;

import com.LetsPlay.ui.ScoreBoard;
import javafx.scene.layout.HBox;

public class Player extends AbstractPlayer {
		public HBox player_rack;
		
		public Player(){
			this.player_score = 0;
			this.scoreboard = new ScoreBoard();
			this.scoreboard.setName("New Player");
			
			this.scoreboard.setScore(Integer.toString(this.player_score));
			this.player_rack = new HBox(1.55);
			this.player_rack.setPrefSize(276.85, 36.6);
			this.player_rack.setStyle("-fx-background-color: #f0fff0;");
		}
		
		public void setPlayerName(String name){
			this.scoreboard.setName(name);
		}
		
}
