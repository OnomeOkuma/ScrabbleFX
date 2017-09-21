package com.LetsPlay.gameplay;

import com.LetsPlay.util.Dawg;
import com.LetsPlay.gameplay.ai.ComPlayer;
import com.LetsPlay.gameplay.rules.PlayChecker;
import com.LetsPlay.gameplay.rules.SingleTilePlayChecker;
import com.LetsPlay.gameplay.rules.SingleTileScoreCalculator;
import com.LetsPlay.gameplay.rules.TileScoreCalculator;
import com.LetsPlay.ui.Board;

import javafx.scene.layout.HBox;

public class GameSession {
		public static Board board;
		public static HBox rack2;
		public static TileBag tilebag;
		public static Dawg wordlist;
		public static boolean first_play;
		public static Player player;
		public static ComPlayer computer;
		
		public static void init(){
			board = new Board();
			rack2 = new HBox(1.55);
			rack2.setPrefSize(276.85, 36.6);
			rack2.setStyle("-fx-background-color: #fffacd;");
			
			tilebag = new TileBag();
			wordlist = new Dawg();
			first_play = true;
			player = new Player();
			computer = new ComPlayer();
			
			SingleTileScoreCalculator.letterScoreInit();
			SingleTileScoreCalculator.wordScoreInit();
			TileScoreCalculator.letterScoreInit();
			TileScoreCalculator.wordScoreInit();
			
			
			for (int columnindex = 0; columnindex < 7; columnindex++){
				
				player.player_rack.getChildren().add(tilebag.getTile());
				computer.fillRack(tilebag.getTile());
			}
			
		}
		
		public static boolean checkPlay(){
			if(first_play == true){
				if(!PlayChecker.isFirstPlayValid() || !PlayChecker.isPlayCorrect() || !PlayChecker.onSameLine()){	
					
					Hand.undo_play();
					Hand.resetState();
					
					return false;
				}else{
					
					player.setPlayerScore(TileScoreCalculator.calculateScore());
					for(int counter = 0; counter < Hand.number_of_plays; counter++){
						if(tilebag.getTileTotal() > 0)
							player.player_rack.getChildren().add(tilebag.getTile());
					}
					first_play = false;
					Hand.resetState();
					return true;
				}			
			
			}else if (PlayChecker.onSameLine() && PlayChecker.isPlayCorrect()){
				
				player.setPlayerScore(TileScoreCalculator.calculateScore());
				for(int counter = 0; counter < Hand.number_of_plays; counter++){
					if(tilebag.getTileTotal() > 0)
						player.player_rack.getChildren().add(tilebag.getTile());
				}
				Hand.resetState();
				return true;
			}else if(SingleTilePlayChecker.isSingleTilePlay() && SingleTilePlayChecker.checkWord()){
				
				player.setPlayerScore(SingleTileScoreCalculator.calculateScore());
				for(int counter = 0; counter < Hand.number_of_plays; counter++){
					if(tilebag.getTileTotal() > 0)
						player.player_rack.getChildren().add(tilebag.getTile());
				}
				Hand.resetState();
				return true;
			}else {
				Hand.undo_play();
				Hand.resetState();
				return false;
			}
				
	}
}