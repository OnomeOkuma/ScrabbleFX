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
		private String highest_scoring_word = new String();
		private int highest_score = 0;
		private boolean axis = true;
		private int row = 0;
		private int column = 0;
		
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
		
		
		
		public void placeTile(int row, int column, Tile tile){
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
		
		/* 
		 * Checks the word provided and records its information if
		 * its score is higher than the previous one. 
		 */
		private void recordMoveColumn(int row, int column,String partialword){

			int score_keeper = 0;
			for (int i = partialword.length() - 1; i >= 0; i--){
				
				if(GameSession.board.isPositionOccupied(row, column)){
					
					//score_keeper += GameSession.board.TileInPosition(row, column).score;
					row--;
					
				}else {
					Iterator<Tile> iterator = this.tiles.iterator();
					String temp = Character.toString(partialword.charAt(i));
					
					while(iterator.hasNext()){
						
						Tile temp2 = iterator.next();
						
						if(temp.equals(temp2.letter)){
							
							score_keeper += temp2.score;
							row--;
							break;
						}
							
					}
					
				}
			}
			
			if (score_keeper > this.highest_score){
				this.axis = false;
				this.row = row;
				this.column = column;
				this.highest_scoring_word = partialword;
				this.highest_score = score_keeper;
				
				}
		}
		
		
		
		/* 
		 * Checks the word provided and records its information if
		 * its score is higher than the previous one. 
		 */
		private void recordMoveRow(int row, int column,String partialword){
			int score_keeper = 0;
			
			for (int i = partialword.length() - 1; i >= 0; i--){
				
				if(GameSession.board.isPositionOccupied(row, column)){
					
					//score_keeper += GameSession.board.TileInPosition(row, column).score;
					column--;
					
				}else {
					Iterator<Tile> iterator = this.tiles.iterator();
					String temp = Character.toString(partialword.charAt(i));
					
					while(iterator.hasNext()){
						
						Tile temp2 = iterator.next();
						
						if(temp.equals(temp2.letter)){
							
							score_keeper += temp2.score;
							column--;
							break;
						}
							
					}
					
				}
			}
			
			if (score_keeper > this.highest_score){
				this.axis = true;
				this.row = row;
				this.column = column;
				this.highest_scoring_word = partialword;
				this.highest_score = score_keeper;
				
				}
		}
		
		
		/*
		 * This method accepts a row index, a column index and a String containing
		 * the word formed up to that index. it uses this information to generate a word, 
		 * along column axis, with a high enough score for play.
		 */
		private void columnBuildWord(int row, int column, String partialword){
			
			// Edge case
			if (row >= 15 || column >= 15){
				return;
			}
			
			if (GameSession.board.isPositionOccupied(row, column)){
				try{
					if(GameSession.wordlist.nodeEdges(partialword).contains(GameSession.board.TileInPosition(row, column).letter)){
					
						partialword = partialword.concat(GameSession.board.TileInPosition(row, column).letter);
						row++;
						this.columnBuildWord(row, column, partialword);
						row--;
					}
				}catch(NullPointerException e){
					System.out.println("Partial word " + partialword);
				}
			}else{
				if(GameSession.wordlist.isWordContained(partialword)){
					this.recordMoveColumn(row, column, partialword);
					}
				

				ArrayList<String> temp = GameSession.wordlist.nodeEdges(partialword);
		
				if (temp == null){
					return;
				}
				Iterator<String> iterator = temp.iterator();
				
			
				while(iterator.hasNext()){
					String temp2 = iterator.next();
					
					if (this.tile_letters.contains(temp2) && BoardView.rowCrossSet(row, column, temp2)){
						
						this.tile_letters.remove(temp2);
						row++;
						this.columnBuildWord(row, column, partialword.concat(temp2));
						this.tile_letters.add(temp2);
						row--;
						
					}
				}
			}
			
		}
		
		/*
		 * This method accepts a row index, a column index and a String containing
		 * the word formed up to that index. it uses this information to generate a word, 
		 * along row axis, with a high enough score for play.
		 */
		
		private void rowBuildWord(int row, int column, String partialword){
			
			// Edge case
			if (row >= 15 || column >= 15){
				return;
			}
			
			if (GameSession.board.isPositionOccupied(row, column)){
				try{
					if(GameSession.wordlist.nodeEdges(partialword).contains(GameSession.board.TileInPosition(row, column).letter)){
					
						partialword = partialword.concat(GameSession.board.TileInPosition(row, column).letter);
						column++;
						this.rowBuildWord(row, column, partialword);
						column--;
					}
				}catch (NullPointerException e){
					System.out.println("Partial word " + partialword);
				}
			}else{
				
				
				if(GameSession.wordlist.isWordContained(partialword)){
					this.recordMoveRow(row, column, partialword);
					}
				
				
				
				ArrayList<String> temp = GameSession.wordlist.nodeEdges(partialword);
		
				if (temp == null){
					return;
				}
				Iterator<String> iterator = temp.iterator();
				
			
				while(iterator.hasNext()){
					String temp2 = iterator.next();
					
					if (this.tile_letters.contains(temp2) && BoardView.columnCrossSet(row, column, temp2)){
						
						this.tile_letters.remove(temp2);
						column++;
						this.rowBuildWord(row, column, partialword.concat(temp2));
						this.tile_letters.add(temp2);
						column--;
						
					}
				}
			}
		}
		
		
		public void generateMove(){
			for (int row = 0; row < 15; row++){
				for (int column = 0; column < 15; column++){
					
					if(BoardView.isColumnAnchorSquare(row, column))
						this.columnBuildWord(row, column, BoardView.columnPrefix(row, column));
					
					if(BoardView.isRowAnchorSquare(row, column))
						this.rowBuildWord(row, column, BoardView.rowPrefix(row, column));
				}
			}
			
			//debug
			System.out.println(this.highest_score);
			System.out.println(this.highest_scoring_word);
			System.out.println(this.row + "  " + this.column + "  " + this.axis);
			System.out.println("\n");
		}
		 
		
		public void makePlay(){
				Tile tile;
				
				if (this.axis){
					
					for (int i = 0; i <= this.highest_scoring_word.length() - 1; i++){
						if (GameSession.board.isPositionOccupied(this.row, this.column))
							this.column++;
						else{
							Iterator<Tile> iterator = this.tiles.iterator();
							while(iterator.hasNext()){
								tile = iterator.next();
								if(Character.toString(this.highest_scoring_word.charAt(i)).equals(tile.letter)){
									this.placeTile(this.row, this.column, tile);
									this.column++;
									this.tiles.remove(tile);
									this.tile_letters.remove(tile.letter);
									break;
								}
							}
						}
						
						
					}
				}else{
					for (int i = 0; i <= this.highest_scoring_word.length() - 1; i++){
						
						if (GameSession.board.isPositionOccupied(this.row, this.column))
							this.row++;
						else{
							Iterator<Tile> iterator = this.tiles.iterator();
							while(iterator.hasNext()){
								tile = iterator.next();
								if(Character.toString(this.highest_scoring_word.charAt(i)).equals(tile.letter)){
									this.placeTile(this.row, this.column, tile);
									this.row++;
									this.tiles.remove(tile);
									this.tile_letters.remove(tile.letter);
									break;
									}
								}
		
							}
						
					}
				}

				this.highest_score = 0;
				this.highest_scoring_word = new String();
				this.axis = true;
				this.row = 0;
				this.column = 0;
		}
		
}
