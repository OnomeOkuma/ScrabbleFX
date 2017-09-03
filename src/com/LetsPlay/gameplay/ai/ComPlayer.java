/*
 * AI class. 
 * */
package com.LetsPlay.gameplay.ai;

import java.util.ArrayList;
import java.util.Iterator;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.ui.ScoreBoard;
import com.LetsPlay.ui.Tile;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class ComPlayer {
		public ScoreBoard scoreboard;
		private int player_score;
		public ArrayList<Tile> tiles;
		
		public ComPlayer(){
			this.player_score = 0;
			this.scoreboard = new ScoreBoard();
			this.scoreboard.setName("Computer");
			this.scoreboard.setScore(Integer.toString(this.player_score));
			this.tiles = new ArrayList<Tile>();
		}
		
		public void fillRack(Tile tile){
			this.tiles.add(tile);
		}
		
		public void makePlay(int row, int column, Tile tile){
			Iterator<Node> iterator = GameSession.board.getChildrenUnmodifiable().iterator();
			
			// To avoid that Object of Group class. 
			iterator.next();
			
			while(iterator.hasNext()){
				Node temp = iterator.next();
				if(GridPane.getRowIndex(temp) == row && GridPane.getColumnIndex(temp) == column){
					Hand.setTile(tile);
					Hand.play((Canvas)temp);
					break;
				}
			}
			
		}
}
