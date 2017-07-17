package com.LetsPlay.gameplay;

import com.LetsPlay.ui.Board;
import javafx.scene.layout.HBox;

public class GameSession {
		public static Board board;
		public static HBox rack1;
		public static HBox rack2;
		public static TileBag tilebag;
		public static Dawg wordlist;
		public static void gameInit(){
			board = new Board();
			rack1 = new HBox(1.55);
			rack2 = new HBox(1.55);
	
			rack1.setPrefSize(276.85, 36.6);
			rack2.setPrefSize(276.85, 36.6);
			
			rack1.setStyle("-fx-background-color: #f0fff0;");
			rack2.setStyle("-fx-background-color: #f0fff0;");
			
			tilebag = new TileBag();
		}
		
}
