/*
 * AI class. 
 * */
package com.LetsPlay.gameplay.ai;

import java.util.ArrayList;
import java.util.Iterator;

import com.LetsPlay.gameplay.AbstractPlayer;
import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.ui.ScoreBoard;
import com.LetsPlay.ui.Tile;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class ComPlayer  extends AbstractPlayer{
		public ArrayList<Tile> tiles;
		private ArrayList<String> tile_letters;
		
		public ComPlayer(){
			this.player_score = 0;
			this.scoreboard = new ScoreBoard();
			this.scoreboard.setName("Computer");
			this.scoreboard.setScore(Integer.toString(this.player_score));
			this.tiles = new ArrayList<Tile>();
			this.tile_letters = new ArrayList<String>();
		}
		
		public void fillRack(Tile tile){
			this.tiles.add(tile);
			this.tile_letters.add(tile.letter);
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
		
		private void recordMove(int row, int column,String partialword){
			System.out.println("Complete word " + partialword);
		}
		
		
		public void columnBuildWord(int row, int column, String partialword){
			
			if (GameSession.board.isPositionOccupied(row, column)){
				if(GameSession.wordlist.nodeEdges(partialword).contains(GameSession.board.TileInPosition(row, column).letter)){
					
					partialword = partialword.concat(GameSession.board.TileInPosition(row, column).letter);
					System.out.println("partialword  " + partialword);
					row++;
					this.columnBuildWord(row, column, partialword);
					row--;
				}
				
			}else{
				if(GameSession.wordlist.isWordContained(partialword)){
					this.recordMove(row, column, partialword);
					}
		
				
				ArrayList<String> temp = GameSession.wordlist.nodeEdges(partialword);
		
				if (temp == null){
					return;
				}
				Iterator<String> iterator = temp.iterator();
				
			
				while(iterator.hasNext()){
					String temp2 = iterator.next();
					
					if (this.tile_letters.contains(temp2) && CrossSet.rowCrossSet(row, column, temp2)){
						
						this.tile_letters.remove(temp2);
						row++;
						this.columnBuildWord(row, column, partialword.concat(temp2));
						this.tile_letters.add(temp2);
						row--;
						
					}
				}
			}
			
		}
		
}
