package com.LetsPlay.gameplay;

import com.LetsPlay.util.DataAccess;
import com.LetsPlay.util.Dawg;
import com.LetsPlay.gameplay.ai.ComPlayer;
import com.LetsPlay.gameplay.rules.PlayChecker;
import com.LetsPlay.gameplay.rules.SingleTilePlayChecker;
import com.LetsPlay.gameplay.rules.SingleTileScoreCalculator;
import com.LetsPlay.gameplay.rules.TileScoreCalculator;
import com.LetsPlay.ui.GameLayout;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;

public class GameSession {
		
		public static TileBag tilebag;
		public static Dawg wordlist;
		public static boolean first_play;	
		public static ComPlayer computer;
		public static DataAccess dataaccess;
		public static CheckBox loggedIn;
		public static Boolean loggedInBool;
		public static int scoreless;
		
		public static void init(){
			
			GameLayout.init();
			
			scoreless = 0;
			
			tilebag = new TileBag();
			wordlist = new Dawg();
			first_play = true;
			
			computer = new ComPlayer();
			dataaccess = new DataAccess();
			loggedInBool = false;
			loggedIn = new CheckBox("Logged In");
			loggedIn.setPadding(new Insets(5,5,5,5));
			loggedIn.setOnAction(e -> {
				loggedIn.setSelected(GameSession.loggedInBool);
			});
			
			
			TileScoreCalculator.letterScoreInit();
			TileScoreCalculator.wordScoreInit();
			
			
			for (int columnindex = 0; columnindex < 7; columnindex++){
				
				GameLayout.playerRack.getChildren().add(tilebag.getTile());
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
					
					GameLayout.playerScore.setScore(TileScoreCalculator.calculateScore());
					for(int counter = 0; counter < Hand.number_of_plays; counter++){
						if(tilebag.getTileTotal() > 0)
							GameLayout.playerRack.getChildren().add(tilebag.getTile());
					}
					first_play = false;
					Hand.resetState();
					return true;
				}			
			
			}else if (PlayChecker.onSameLine() && PlayChecker.isPlayCorrect()){
				
				GameLayout.playerScore.setScore(TileScoreCalculator.calculateScore());
				for(int counter = 0; counter < Hand.number_of_plays; counter++){
					if(tilebag.getTileTotal() > 0)
						GameLayout.playerRack.getChildren().add(tilebag.getTile());
				}
				Hand.resetState();
				return true;
			}else if(SingleTilePlayChecker.isSingleTilePlay() && SingleTilePlayChecker.checkWord()){
				
				GameLayout.playerScore.setScore(SingleTileScoreCalculator.calculateScore());
				for(int counter = 0; counter < Hand.number_of_plays; counter++){
					if(tilebag.getTileTotal() > 0)
						GameLayout.playerRack.getChildren().add(tilebag.getTile());
				}
				Hand.resetState();
				return true;
			}else {
				Hand.undo_play();
				Hand.resetState();
				return false;
			}
				
		}
		
		public static boolean isTileBagEmpty(){
			System.out.println(scoreless);
			if (tilebag.getTileTotal() > 0)
				return false;
			else return true;
		}
		
		
		public static void restartGame(){
			
			GameLayout.resetLayout();
			tilebag = new TileBag();
			wordlist = new Dawg();
			first_play = true;
			computer = new ComPlayer();
			
			scoreless = 0;
			
			TileScoreCalculator.letterScoreInit();
			TileScoreCalculator.wordScoreInit();
			
			for (int columnindex = 0; columnindex < 7; columnindex++){
				
				GameLayout.playerRack.getChildren().add(tilebag.getTile());
				computer.fillRack(tilebag.getTile());
			}
		}
}