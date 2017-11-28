/*
 * 	This Class checks the tiles placed on the board to see if it conforms to the rules of the Game.
 * 
 * 	During gameplay, A player can place either a single tile or multiple tiles on the board.
 * The checks made on a single tile placed is significantly different from the checks made when
 * multiple tiles (ignoring the exact number) is placed on the board. This Class handles 
 * checks for multiple tiles played.
 * 
 * 	When Multiple tiles are placed on the board, it has to conform to the following rules
 * 
 * 1) All tiles must be placed on the same row or column.
 * 2) All tiles must form a word present in the dictionary.
 * 3) If the play makes use of tiles already on the board, it must form a valid word.
 *	
 *	Each method handles a specific aspect of this rule because, as you can tell, implementing this
 * rules is difficult.
 */
package com.LetsPlay.gameplay.rules;


import java.util.Iterator;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.ui.GameLayout;

public class PlayChecker {
		
// Checks if the play was made on the same column or row.
	public static boolean onSameLine(){
		
		// Checks if tiles are on the same row.
		if (Hand.tiles_played.sameRow() != Hand.tiles_played.sameColumn())
			return true;
				else return false;
	}

	
// Check if the first play was made according to the rules of the game.
	public static boolean isFirstPlayValid(){
			return GameLayout.board.isPositionOccupied(7, 7);
		}
	
	
	public static boolean isPlayCorrect(){
		if(PlayChecker.isPlayCrossPlay())
			return (PlayChecker.crossCheckWord() && PlayChecker.checkWord());
		else return PlayChecker.checkWord();
	}
	
		
// Checks the word formed by the play. It takes into account any suffix or prefix encountered.
	private static boolean checkWord(){
			StringBuffer word = new StringBuffer();
			
			/*
			 *	This method has two parts. The first runs if all tiles were placed on the same 
			 *	row while the second part runs if they were placed on the same column.
			 *	They are identical in solution.
			 */
			
			if(Hand.tiles_played.sameRow()){
				int row = Hand.tiles_played.row.firstElement();
				int column = Hand.tiles_played.column.firstElement();
				
				// Get the word formed by the tiles played.
				while (column <= Hand.tiles_played.column.get(Hand.tiles_played.column.size() - 1)){
					if(!GameLayout.board.isPositionOccupied(row, column))
						return false;
					
					word.append(GameLayout.board.TileInPosition(row, column).letter);
					column++;
					
				}
				
				// Add prefixed word if any.
				if (PlayChecker.isPlaySuffix()){
					column = Hand.tiles_played.column.firstElement();
					StringBuffer temp = new StringBuffer();
					column--;
					while(GameLayout.board.isPositionOccupied(row, column)){
						temp.append(GameLayout.board.TileInPosition(row, column).letter);
						column--;
					}
					temp = temp.reverse();
					word = temp.append(word);
					
				}
				
				
				// Add suffixed word if any.
				if (PlayChecker.isPlayPrefix()){
					column = Hand.tiles_played.column.get(Hand.tiles_played.column.size() - 1);
					column++;
					while(GameLayout.board.isPositionOccupied(row, column)){
						word.append(GameLayout.board.TileInPosition(row, column).letter);
						column++;
					}
					
				}
				
				// return the boolean value of dictionary check.
				return (GameSession.wordlist.isWordContained(word.toString()));
				
				// This is the second part.
			} else {
				int row = Hand.tiles_played.row.firstElement();
				int column = Hand.tiles_played.column.firstElement();
				
				// Get the word formed by the tiles played.
				while (row <= Hand.tiles_played.row.get(Hand.tiles_played.row.size() - 1)){
					if(!GameLayout.board.isPositionOccupied(row, column))
						return false;
					
					word.append(GameLayout.board.TileInPosition(row, column).letter);
					row++;
					
				}
				
				// Add prefixed word if any.
				if (PlayChecker.isPlaySuffix()){
					row = Hand.tiles_played.row.firstElement();
					StringBuffer temp = new StringBuffer();
					row--;
					while(GameLayout.board.isPositionOccupied(row, column)){
						temp.append(GameLayout.board.TileInPosition(row, column).letter);
						row--;
					}
					temp = temp.reverse();
					word = temp.append(word);
					
				}
				
				// Add suffixed word if any.
				if (PlayChecker.isPlayPrefix()){
					row = Hand.tiles_played.row.get(Hand.tiles_played.row.size() - 1);
					row++;
					while(GameLayout.board.isPositionOccupied(row, column)){
						word.append(GameLayout.board.TileInPosition(row, column).letter);
						row++;
					}
					
				}
				
				// return the boolean value of dictionary check.
				return (GameSession.wordlist.isWordContained(word.toString()));
			}

		}
	

// Checks all cross words formed.
	private static boolean crossCheckWord(){	
		if(Hand.tiles_played.sameRow()){
			Iterator<Integer> column_values = Hand.tiles_played.column.iterator();
			
			/*
			 *	This method has two parts. The first runs if all tiles were placed on the same 
			 *	row while the second part runs if they were placed on the same column.
			 *	They are identical in solution.
			 */
			
			while (column_values.hasNext()){
				StringBuffer word = new StringBuffer();
				int column = column_values.next();
				int row = Hand.tiles_played.row.firstElement();
				
				// Append the letters found in the successive rows where tiles are found.
				while(GameLayout.board.isPositionOccupied(row, column)){
					word.append(GameLayout.board.TileInPosition(row, column).letter);
					row++;
				}
				StringBuffer temp = new StringBuffer();
				row = Hand.tiles_played.row.firstElement();
				row--;
				
				// Append the letters found in the preceding rows where tiles are found.
				while(GameLayout.board.isPositionOccupied(row, column)){
					temp.append(GameLayout.board.TileInPosition(row, column).letter);
					row--;
				}
				
				// Reverse value because it is a prefix. 
				temp.reverse();
				
				// Append word. 
				word = temp.append(word);
				
				/*
				 Return false if the word formed is not in the dictionary. The word.length()
				 condition is to ensure that the check continues if no cross word is found on that 
				 tile.
				*/
				
				if (word.length() != 1 && !GameSession.wordlist.isWordContained(word.toString()))
					return false;
			}
			return true;
		}else{
				Iterator<Integer> row_values = Hand.tiles_played.row.iterator();
				
				while (row_values.hasNext()){
					StringBuffer word = new StringBuffer();
					int row = row_values.next();
					int column = Hand.tiles_played.column.firstElement();
					
					// Append the letters found in the successive columns where tiles are found.
					while(GameLayout.board.isPositionOccupied(row, column)){
						word.append(GameLayout.board.TileInPosition(row, column).letter);
						column++;
					}
					StringBuffer temp = new StringBuffer();
					column = Hand.tiles_played.column.firstElement();
					column--;
					
					// Append the letters found in the preceding columns where tiles are found.
					while(GameLayout.board.isPositionOccupied(row, column)){
						temp.append(GameLayout.board.TileInPosition(row, column).letter);
						column--;
					}
					
					// Reverse value because it is a prefix.
					temp.reverse();
					
					// Append word. 
					word = temp.append(word);
					
					/*
					 Return false if the word formed is not in the dictionary. The word.length()
					 condition is to ensure that the check continues if no cross word is found on that 
					 tile.
					*/
					if (word.length() != 1 && !GameSession.wordlist.isWordContained(word.toString()))
						return false;
			}
			return true;	
		}
	}
	
		// Checks if the play made was suffixed to a previous play on the board.
				static boolean isPlaySuffix(){
					int column = Hand.tiles_played.column.firstElement();
					int row = Hand.tiles_played.row.firstElement();
				
				
					if (Hand.tiles_played.sameRow() && GameLayout.board.isPositionOccupied(row, (column-1)))
						return true;
					else if (Hand.tiles_played.sameColumn() && GameLayout.board.isPositionOccupied((row - 1), column))
						return true;
					return false;
				}
			
		// Checks if the play made was prefixed to a previous play made on the board.
				static boolean isPlayPrefix(){
					int column = Hand.tiles_played.column.lastElement();
					int row = Hand.tiles_played.row.lastElement();
					
					if (Hand.tiles_played.sameRow() && GameLayout.board.isPositionOccupied(row, (column + 1)))
						return true;
					else if (Hand.tiles_played.sameColumn() && GameLayout.board.isPositionOccupied((row + 1), column))
						return true;
				
					return false;
				}
				
				
		// Checks if there are cross words formed.	
				public static boolean isPlayCrossPlay(){
					if(Hand.tiles_played.sameRow()){
						Iterator<Integer> column_values = Hand.tiles_played.column.iterator();
						
						while (column_values.hasNext()){
							int column = column_values.next();
							int row = Hand.tiles_played.row.firstElement();
							
							boolean bottom_row = GameLayout.board.isPositionOccupied(row + 1, column);
							boolean top_row = GameLayout.board.isPositionOccupied(row - 1, column);
							
							
							if(top_row == true || bottom_row == true)
								return true;
						}
						return false;
					} else{
						Iterator<Integer> row_values = Hand.tiles_played.row.iterator();
						while (row_values.hasNext()){
							int row = row_values.next();
							int column = Hand.tiles_played.column.firstElement();
							
							boolean right_column = GameLayout.board.isPositionOccupied(row, column + 1);
							boolean left_column = GameLayout.board.isPositionOccupied(row, column - 1);
							
							if(right_column == true || left_column == true)
								return true;
						}
						return false;
					}
				}

}

	