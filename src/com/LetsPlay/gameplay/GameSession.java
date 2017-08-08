package com.LetsPlay.gameplay;

import com.LetsPlay.util.Dawg;
import com.LetsPlay.gameplay.rules.PlayChecker;
import com.LetsPlay.gameplay.rules.SingleTilePlayChecker;
//import com.LetsPlay.gameplay.rules.SingleTilePlayChecker;
import com.LetsPlay.ui.Board;
import javafx.scene.layout.HBox;

public class GameSession {
		public static Board board;
		public static HBox rack1;
		public static HBox rack2;
		public static TileBag tilebag;
		public static Dawg wordlist;
		public static boolean first_play;
		public static void init(){
			board = new Board();
			rack1 = new HBox(1.55);
			rack2 = new HBox(1.55);
	
			rack1.setPrefSize(276.85, 36.6);
			rack2.setPrefSize(276.85, 36.6);
			
			rack1.setStyle("-fx-background-color: #f0fff0;");
			rack2.setStyle("-fx-background-color: #f0fff0;");
			
			tilebag = new TileBag();
			wordlist = new Dawg();
			first_play = true;
			
			
			for (int columnindex = 0; columnindex < 7; columnindex++){
				
				GameSession.rack1.getChildren().add(GameSession.tilebag.getTile());
				
			}
		}
		
		public static void checkPlay(){
			if(first_play == true){
				if(!PlayChecker.isFirstPlayValid() || !PlayChecker.isPlayCorrect() || !PlayChecker.onSameLine()){	
					
					Hand.undo_play();
					Hand.resetState();

				}else{
					for(int counter = 0; counter < Hand.number_of_plays; counter++)
						rack1.getChildren().add(tilebag.getTile());
					first_play = false;
					Hand.resetState();
				}			
			
			}else if (PlayChecker.onSameLine() && PlayChecker.isPlayCorrect()){
				for(int counter = 0; counter < Hand.number_of_plays; counter++)
					rack1.getChildren().add(tilebag.getTile());
				Hand.resetState();
			}else if(SingleTilePlayChecker.isSingleTilePlay() && SingleTilePlayChecker.checkWord()){
				for(int counter = 0; counter < Hand.number_of_plays; counter++)
					rack1.getChildren().add(tilebag.getTile());
				Hand.resetState();
			}else {
				Hand.undo_play();
				Hand.resetState();
			}
				
	}
}